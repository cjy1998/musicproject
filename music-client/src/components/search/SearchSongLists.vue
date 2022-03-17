<template>
    <div class="search-song-Lists">
       <content-list :contentList="albumData"></content-list>
    </div>
</template>
<script>
import ContentList from '../ContentList.vue'
import {getlikeTitle} from '../../api/index'
import {mixin} from '../../mixins'
export default {
  components: { ContentList },
    name: 'search-song-lists',
    comments:{
        ContentList
    },
    data(){
        return{
            albumData: []
        }
    },
    mounted(){
        this.getSearchList();
    },
    methods:{
        getSearchList(){
            if(!this.$route.query.keywords){
                this.notify('您输入的内容为空','warning')
            }else{
                getlikeTitle(this.$route.query.keywords)
                    .then(res =>{
                        if(res){
                            this.albumData = res
                        }else{
                            this.notify('暂无该歌曲内容','warning')
                        }
                    })
                
            }
           
        }
    }
}
</script>
<style lang="scss" scoped>
@import '../../assets/css/search-song-Lists.scss';
</style>