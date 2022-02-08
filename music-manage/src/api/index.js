import {get,post} from "./http";

// 判断管理员是否登录成功
export const getLoginStatus = (params) => post(`admin/login/status`,params);
//查询歌手
export const getAllSinger =()  => get(`singer/allSinger`);
//添加歌手
export const setSinger = (params) => post(`singer/add`,params);
//修改歌手
export const updateSinger = (params) => post(`singer/update`,params);
//删除歌手
export const deleteSinger = (id) => get(`singer/delete?id=${id}`);
//============歌曲相关================
//根据歌手id查询歌曲
export const songOfSingerId =(id) => get(`song/singer/detail?singerId=${id}`);
//编辑歌曲
export const updateSong = (params) => post(`song/update`,params);
//删除歌曲
export const delSong = (id) => get(`song/delete?id=${id}`);
//============歌单相关================
//查询歌单
export const getAllSongList =()  => get(`songList/allSongList`);
//添加歌手
export const setSongList = (params) => post(`songList/add`,params);
//修改歌手
export const updateSongList = (params) => post(`songList/update`,params);
//删除歌手
export const deleteSongList = (id) => get(`songList/delete?id=${id}`);