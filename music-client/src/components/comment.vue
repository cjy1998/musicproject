<template>
  <div>
      <div class="comment">
          <h2>评论</h2>
          <div class="comment-msg">
              <div class="comment-img">
                  <img :src="attachImageUrl(avator)">
              </div>
              <el-input class="comment-input" type="textarea" :rows="2" placeholder="请输入内容" v-model="textarea">

              </el-input>
          </div>
          <el-button type="primary" class="sub-btn" @click="postComment">评论</el-button>
      </div>
      <P>精彩评论：共{{commentList.length}}条评论</P>

      <ul class="popular" v-for="(item,index) in commentList" :key="index">
          <li>
              <div class="popular-img">
                  <img :src="attachImageUrl(userPic[index])">
              </div>
              <div class="popular-msg">
                  <ul>
                      <li class="name">{{userName[index]}}</li>
                        <li class="time">{{item.createTime}}</li>
                          <li class="name">{{item.content}}</li>
                  </ul>
              </div>
              <div class="up" ref="up" @click="postUp(item.id,item.up,index)">
                  <svg class="icon">
                      <use xlink:href="#icon-zan"></use>
                  </svg>
                    {{item.up}}
              </div>
          </li>
      </ul>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import {mixin} from '../mixins'
import {setComment,setLike,getAllComment,getUserOfId} from '../api/index'
export default {
    name: 'comment',
    mixins: [mixin],
    props:[
        'playId', //歌曲或歌单Id
        'type',  //0歌曲、1歌单
    ],
    data(){
        return{
            textarea: '', //存放输入的内容
            commentList: [], //存放评论列表
            userPic: [],   //用户头像
            userName: [],   //用户昵称
        }
    },
    computed:{
        ...mapGetters([
            'id',
            'loginIn',       //用户是否已登录
            'userId',     //用户ID
            'avator',        //用户头像
        ])
    },
     mounted(){
        this.getComment();
    },
    methods:{
        //提交评论
        postComment(){
            if (this.loginIn) {
                let params = new URLSearchParams();
                if (this.type == 0) {
                    params.append('songId',this.playId);
                }else{
                    params.append('songListId',this.playId);
                }
                params.append('userId',this.userId);
                params.append('type',this.type);
                params.append('content',this.textarea);
                setComment(params)
                    .then(res => {
                        if(res.code == 1){
                            this.notify('评论成功','success');
                            this.textarea ='';
                            this.getComment();
                        }else{
                            this.notify('评论失败',error);
                        }
                    })
                    .catch(err => {
                        this.notify('评论失败','error');
                    })
            }else{
                this.notify('请先登录','warning')
            }
                
            },
            //评论列表
            getComment(){
                getAllComment(this.type,this.playId)
                .then(res => {
                    this.commentList = res;
                    for (let item of res) {
                        this.getUsers(item.userId)
                        
                    }
                })
                .catch(err => {
                    this.notify('评论失败','error')
                })
            },
            //获取用户的头像和昵称
            getUsers(id){
                getUserOfId(id)
                .then(res =>{
             
                    this.userPic.push(res.avator);
                    this.userName.push(res.username);
                })
                .catch(err => {
             
                    this.notify('出错了','error');
                })
            },
            //给某一个评论点赞
            postUp(id,up,index){
            if (this.loginIn) {
                let params = new URLSearchParams();
                
                params.append('id',id);
                params.append('up',up+1);
            
                setLike(params)
                    .then(res => {
                        if(res.code == 1){
                          this.$refs.up[index].children[0].style.color = '#2796cd'
                            this.getComment();
                        }else{
                            this.notify('点赞失败',error);
                        }
                    })
                    .catch(err => {
                        this.notify('点赞失败','error');
                    })
            }else{
                this.notify('请先登录','warning')
            }
            }

    },
   
        
    
}
</script>

<style lang="scss" scoped>
@import '../assets/css/comment.scss';
</style>