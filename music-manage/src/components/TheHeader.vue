<template>
    <div class="header">
        <!-- 折叠左侧图片 -->
        <div class="collapse-btn" @click="collapseChange">
            <i class="el-icon-menu"></i>
        </div>
        <div class="logo">音乐网站后台管理</div>
        <div class="header-right">
          <div class="btn-fullscreen" @click="handleFullScreen">
           <el-tooltip :content="fullscreen?'取消全屏':'全屏'" placement="bottom">
            <i class="el-icon-rank"></i>
            </el-tooltip>
          </div>
          <div class="user-avator">
              <img src="../assets/img/user.jpg">
          </div>
          <!-- 退出登录 -->
          <el-dropdown class="user-name" trigger="click" @command="hadleCommand">
            <span class="el-dropdown-link">
            {{userName}}
              <i class="el-icon-caret-bottom"></i>
            </span>
          
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="logout">退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
    </div>
</template>
<script>
import bus from '../assets/js/bus'
export default {
  data () {
    return {
      collapse: false,
      fullscreen: false
    }
  },
  computed:{
  userName(){
    return localStorage.getItem('userName')
  }
  },
  methods: {
    //侧边栏折叠
    collapseChange () {
      this.collapse = !this.collapse
      bus.$emit('collapse', this.collapse)
    },
  //全屏事件
  handleFullScreen(){
    if(this.fullscreen){
      if(document.exitFullscreen){
        document.exitFullscreen();
      }else if(document.webkitCancelFullScreen){ //safari,chrome早期版本
        document.webkitCancelFullScreen();
      }else if(document.mozCancelFullScreen){//firefox
        document.mozCancelFullScreen();
      }else if(document.msExitFullScreen){//ie
      document.msExitFullScreen();
      }
    }else{
      let element =document.documentElement;
      if(element.requestFullscreen){
        element.requestFullscreen();
      }else if(document.webkitRequestFullScreen){ //safari,chrome早期版本
        document.webkitRequestFullScreen();
      }else if(document.mozRequestFullScreen){//firefox
        document.mozRequestFullScreen();
      }else if(document.msRequestFullScreen){//ie
      document.msRequestFullScreen();
      }
    }
    this.fullscreen =!this.fullscreen;
  },
  hadleCommand(command){//退出登录
    if(command == "logout"){
      localStorage.removeItem('userName');
      this.$router.push("/");
    }
  }
  }
}
</script>
<style scoped>
.header{
    position: relative;
    background-color: #253041;
    box-sizing: border-box;
    width: 100%;
    height: 70px;
    font-size: 22px;
    color: #fff;
}
.collapse-btn{
    float: left;
    padding: 0 21px;
    /* cursor:hand 与 cursor:pointer 的效果是一样，
    都像手形光标。但用FireFox浏览时才注意到使用cursor:hand在FireFox里并被支持。 */
    cursor: pointer;
    line-height: 70px;
}
.header .logo{
  float:left;
  line-height: 70px;
}
.header-right{
  float: right;
  padding-right: 50px;
  /* 弹性布局 */
  display: flex;
  height: 70px;
  align-items: center;
}
.btn-fullscreen{
  /* 旋转45° */
  transform: rotate(45deg);
  margin-right: 5px;
  font-size: 24px;
}
.user-avator{
  margin-left: 20px;
}
.user-avator img{
  display: block;
  width: 40px;
  height: 40px;
  border-radius:50% ;
}
.user-name{
  margin-left: 10px;

}
.el-dropdown-link{
  color: #fff;
  cursor: pointer;
}
</style>
