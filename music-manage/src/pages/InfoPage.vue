<template>
<div> 
    <!--gutter间距  -->
    <el-row :gutter="20" class="mgb20">
            <el-col  :span='6'>
            <el-card>
                <div class="grid-content">
                    <div class="grid-content-center">
                <div class=".grid-num">{{consumerCount}}</div>
                <div>用户总数</div>
                </div>
                </div>
            </el-card>
            </el-col>
 <!-- **************************************** -->

                <el-col  :span='6'>
            <el-card>
                <div class="grid-content">
                    <div class="grid-content-center">
                <div class=".grid-num">{{songCount}}</div>
                <div>歌曲总数</div>
                </div>
                </div>
            </el-card>
            </el-col>
             <!-- **************************************** -->
                <el-col  :span='6'>
            <el-card>
                <div class="grid-content">
                    <div class="grid-content-center">
                <div class=".grid-num">{{singerCount}}</div>
                <div>歌手总数</div>
                </div>
                </div>
            </el-card>
            </el-col>
            <!-- **************************************** -->
                <el-col  :span='6'>
            <el-card>
                <div class="grid-content">
                    <div class="grid-content-center">
                <div class=".grid-num">{{songListCount}}</div>
                <div>歌单总数</div>
                </div>
                </div>
            </el-card>
            </el-col>
         </el-row>

         <!-- 饼状图和柱状图 -->
          <el-row :gutter="20" class="mgb20">
            <el-col  :span='12'>
                <h3>用户性别比例</h3>
                <div style="background-color:white">
                    <!-- Vue.use(VCharts) 插件使用 -->
                    <ve-pie :data="consumerSex"></ve-pie>
                </div>
            </el-col>
          
            <el-col  :span='12'>
                <h3>歌单风格分布</h3>
                <div style="background-color:white">
                    <!-- Vue.use(VCharts) 插件使用 -->
                    <ve-histogram :data="songStyle" :theme="options"></ve-histogram>
                </div>
            </el-col>
          </el-row>
</div>
</template>
<script>
import {getAllConsumer,getAllSongList,getAllSinger,getAllSong} from '../api/index';
export default {
  data(){
      return{
          consumerCount: 0,    //用户总数
          songCount: 0,        //歌曲总数
          singerCount: 0,     //歌手总数
          songListCount: 0,   //歌单总数
          consumer:[],          //所有用户
          songList: [],         //所有歌单
          consumerSex:{         //按性别分类的用户数
          columns: ['性别','总数'],
          rows: [
               {'性别': '男','总数': 0},
              {'性别': '女','总数': 0}
              
          ]},
        songStyle:{         //按歌单风格分类
          columns: ['风格','总数'],
          rows: [
                {'风格': '华语','总数': 0},
                {'风格': '流行','总数': 0},
                {'风格': '欧美','总数': 0},
                {'风格': '日韩','总数': 0},
          ]},
          options:{
              color: ['#87cefa']
          }
          }
  },
  created() {

  },
  mounted() {
      //页面所有的元素加载完执行
        this.getConsumer();
        this.getsongList();
        this. getSinger();
        this.getSong()
  },
  methods: {
      getConsumer(){
          getAllConsumer().then(res => {
               this.consumer = res;
              this.consumerCount = res.length;
              this.consumerSex.rows[0]['总数'] = this.setSex(1,this.consumer);
               this.consumerSex.rows[1]['总数'] = this.setSex(0,this.consumer);
          })
      },
      setSex(sex,consumer){             //根据性别获取用户数
        let count = 0;
        for(let item of consumer){
            if(sex == item.sex){
                count++;
            }
        }
        return count
      },
      getsongList(){
          getAllSongList().then(res => {
              this.songListCount = res.length;
              for(let items of res){
                  this.setSongList(items.style)
              }
          })
      },
      setSongList(style){             //根据风格获取歌单
    
        for(let items of this.songStyle.rows){
            if(style.includes(items['风格'])){
                items['总数']++;
            }
        }
      },
      getSinger(){
          getAllSinger().then(res =>{
              this.singerCount = res.length
          })
      },
      getSong(){
          getAllSong().then(res => {
              this.songCount = res.length
          })
      }
  }
}
</script>

<style scoped>
.grid-content{
    display: flex;
    align-items: center;
    height: 50px;
}
.grid-content-center{
    flex: 1;
    text-align: center;
    font-size: 14px;
    color: darkgray;
}
.grid-num{
    font-size: 30px;
    font-weight: bold;
}
</style>