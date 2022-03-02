<template>
  <div id="app"> 
    
    <the-header></the-header>   
    <router-view class="music-content"/>   
     <song-audio/>
     <the-a-side/>
     <play-bar/>
    <scroll-top></scroll-top>
    <the-footer></the-footer>
   
  </div>
</template>

<script>
import ScrollTop from './components/ScrollTop.vue'
import TheFooter from './components/TheFooter.vue'
import TheHeader from './components/TheHeader.vue'
import SongAudio from './components/SongAudio.vue'
import PlayBar from './components/PlayBar.vue'
import TheASide from './components/TheAside.vue'
export default {
  name: 'App',
  components: {
    TheHeader,
    ScrollTop,
    TheFooter,
    SongAudio,
    PlayBar,
    TheASide
    
  }
}
</script>

<style  lang="scss" scoped>
@import './assets/css/app.scss';
</style>
