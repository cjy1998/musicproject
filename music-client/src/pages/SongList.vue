<template>
    <div class="song-list">
        <ul class="song-list-header">
         <li v-for="(item,index) in songStyle" :key="index" 
         @click="handleChangeView(item.name)"
         :class="{active:item.name == activeName}">
             {{item.name}}
         </li>
        </ul>
        <div>
       <content-list :contentList="data"></content-list>
       <div class="pagination">
           <el-pagination @current-change="handleCurrentChange"
            background 
           layout="total,prev,pager,next"
           :current-page="currentPage"
           :page-size="pageSize"
           :total="albumData.length">
           </el-pagination>
       </div>
       </div>
    </div>
</template>
<script>
import ContentList from '../components/ContentList.vue'
import {getAllSongList,getlikeStyle} from '../api/index'
import {mixin} from '../mixins'
import {songStyle} from '../assets/data/songList'
export default {
  components: { ContentList },
    name: 'song-list',
    comments:{
        ContentList
    },
    data(){
        return{
            albumData: [],   //歌单数据
            pageSize: 15,  //页面大小,一页有15条数据
            currentPage: 1,  //当前页，默认第一页
            songStyle:[],       //歌单风格
            activeName: '全部歌单',      //当前风格

        }
    },
    computed:{
        //计算当前表格中的数据
        data(){
          return   this.albumData.slice((this.currentPage - 1)*this.pageSize,this.currentPage*this.pageSize)
        }
    },
    mounted(){
        this.getSongList();
        this.songStyle = songStyle;
    },
    methods:{
        getSongList(){
           
               getAllSongList()
                    .then(res =>{
                        this.currentPage = 1
                            this.albumData = res
                      
                    })
        },
        //获取当前页
        handleCurrentChange(val){
            this.currentPage = val;
        },
        //根据style显示对应的歌单
        handleChangeView(name){
            this.activeName = name;
            this.albumData = [];
            if (name == '全部歌单') {
                this.getSongList()
            }else{
                this.goSongListOfStyle(name)
            }
        },
        //根据style查询对应的歌单
        goSongListOfStyle(style){
            getlikeStyle(style)
            .then(res => {
                this.currentPage = 1
                this.albumData = res
            })
        }
    }
}
</script>
<style lang="scss" scoped>
  @import '../assets/css/song-list.scss';
</style>