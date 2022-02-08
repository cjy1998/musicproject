import { valueAxis } from "echarts/lib/theme/dark";
import Vue  from "vue";
import vuex from "vuex";

Vue.use(vuex)

const store =new vuex.Store({
    state:{
        HOST: 'http://127.0.0.1:8888',
        isPlay: false,  //是否播放中
        url: '',  //歌曲地址
        id: '' //歌曲id

    },
    getters:{
        isPlay: state => state.isPlay,
        url: state => state.url,
        id: state => state.id
    },
    mutations:{
    setIsPlay:(state,isPlay)=>{state.isPlay = isPlay},
    setUrl:(state,url)=>{state.url = url},
    setIsId:(state,id)=>{state.id = id},

}
}
)

export default store;

