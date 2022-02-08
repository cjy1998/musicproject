<template>
  <div id="app">
    <song-audio></song-audio>
    <router-view></router-view>
  </div>
</template>

<script>
import SongAudio from './components/SongAudio.vue';

export default {
  components: { SongAudio },
  name: 'App'
}
</script>

<style>
</style>
