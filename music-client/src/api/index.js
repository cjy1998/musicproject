import Axios from "axios";
import {get,post} from "./http";

//============歌手相关================
//查询歌手
export const getAllSinger =() => get(`singer/allSinger`);
//根据性别查询歌手
export const getSingerOfSex = (sex) => get(`singer/singerOfSex?sex=${sex}`)
//============歌曲相关================
//根据歌手id查询歌曲
export const songOfSingerId =(id) => get(`song/singer/detail?singerId=${id}`);
//根据歌曲id查询歌曲对象
export const songOfSongId =(id) => get(`song/detail?songId=${id}`);
//根据歌手名字模糊查询歌曲
export const likeSongOfName =(keywords) => get(`song/likeSongOfName?songName=${keywords}`);

//============歌单相关================
//查询歌单
export const getAllSongList =() => get(`songList/allSongList`);
//根据歌单模糊查询
export const  getlikeTitle = (keywords) => get(`songList/likeTitle?title=${keywords}`)
//根据风格模糊查询歌单
export const  getlikeStyle = (style) => get(`songList/likeStyle?style=${style}`)
//============歌单的歌曲相关============
//根据歌单id查询歌曲列表
export const listSongDetail = (songListId) => get(`listSong/detail?songListId=${songListId}`);

//============用户相关================
//查询用户
export const getAllConsumer =() => get(`consumer/allConsumer`);
//更新用户信息
export const updateUserMsg = (params) => post(`consumer/update`,params);
//下载歌曲
export const download = (url) => Axios({

    method: 'get',
    url: url,
    responseType: 'blob'
})

//注册
export const SignUp = (params) => post(`consumer/add`,params);
//登录
export const loginIn = (params) => post(`consumer/login`,params);
//根据用户id查询用户的详细信息
export const getUserOfId = (id) => get(`consumer/selectByPrimaryKey?id=${id}`)
//==========================评价
//提交评分
export const setRank = (params) => post(`rank/add`,params);
//获取评分
export const getRankOfSongListId = (songListId) => get(`/rank?songListId=${songListId}`);

//================评论===============
//提交品论
export const setComment = (params) => post(`/comment/add`,params);
//点赞
export const setLike = (params) => post(`/comment/like`,params);
//返回当前歌单或歌曲的评论列表
export const getAllComment = (type,id) => {
    if(type == 0){
        return get(`/comment/commentOfSongId?songId=${id}`);
    }else{
        return get(`/comment/commentOfSongListId?songListId=${id}`);
    }
}

//########################收藏########################
//新增收藏
export const setCollect = (params) => post(`collect/add`,params);
//指定用户的收藏列表
export const getCollectOfUserId = (userId) => get(`collect/collectOfUserId?userId=${userId}`);