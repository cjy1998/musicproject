<template>
    <div class="sidebar">
        <!--:default-active="onRoutes"菜单的点击状态
          :collapse="collapse 菜单默认的收缩状态
          router 点击后转向哪个页面-->
        <el-menu
         class="siderbar-el-menu"
         :default-active="onRoutes"
         :collapse="collapse"
         background-color="#334256"
         text-color="#ffffff"
         active-text-color="#20a0ff"
         router>
                <template v-for="item in items">
                    <template>
                        <el-menu-item :index="item.index" :key="item.index">
                            <i :class="item.icon"></i>
                            {{item.title}}
                        </el-menu-item>
                    </template>

                </template>
        </el-menu>
    </div>
</template>
<script>
import bus from '../assets/js/bus'
export default{
  data () {
    return {
      collapse: false,
      items: [
        {
          icon: 'el-icon-document',
          index: 'Info',
          title: '系统首页'
        },
        {
          icon: 'el-icon-document',
          index: 'Consumer',
          title: '用户管理'
        },
        {
          icon: 'el-icon-document',
          index: 'Singer',
          title: '歌手管理'
        },
        {
          icon: 'el-icon-document',
          index: 'SongList',
          title: '歌单管理'
        }
      ]
    }
  },
  computed: {
    onRoutes () {
      return this.$route.path.replace('/', '')
    }
  },
  created () {
    // 通过bus进行组件间的通信，来折叠侧边栏
    bus.$on('collapse', msg => {
      this.collapse = msg
    })
  }
}
</script>

// scoped的意思是样式只适用于当前vue页面
<style scoped>
.sidebar{
    display: block;
    position: absolute;
    left: 0;
    top: 70px;
    bottom: 0;
    background-color: #334256;
    overflow: scroll;
}
.sidebar::-webkit-scrollbar{
  width: 0px;
}
.siderbar-el-menu:not(.el-menu--collapse){
    width: 150px;
}
.sidebar > ul{
  height: 100%;
}
</style>
