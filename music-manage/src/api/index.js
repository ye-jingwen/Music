import { get, post } from "./http"

//判断管理员是否登陆成功
export const getLoginStatus = (params) => post(`admin/login/status`, params);

/********** 歌手相关 **********/
//查询歌手
export const getAllSinger = () => get(`singer/allSinger`);
//添加歌手
export const setSinger = (params) => post(`singer/insertSinger`, params);
//编辑歌手
export const updateSinger = (params) => post(`singer/updateSinger`, params);
//删除歌手
export const delSinger = (id) => get(`singer/deleteSinger?id=${id}`);

/********** 歌曲相关 **********/
//根据歌手id查询歌曲
export const selectBySingerId = (id) => get(`song/singer/selectBySingerId?singerId=${id}`);
//根据歌曲id查询歌曲对象
export const selectBySongId = (id) => get(`song/selectBySongId?id=${id}`);
//根据歌曲名字查询歌曲对象
export const selectBySongName = (songName) => get(`song/selectBySongName?songName=${songName}`);
//编辑歌曲
export const updateSong = (params) => post(`song/updateSong`, params);
//删除歌曲
export const delSong = (id) => get(`song/deleteSong?id=${id}`);

/********** 歌单相关 **********/
//查询歌单
export const getAllSongList = () => get(`songList/allSongList`);
//添加歌单
export const setSongList = (params) => post(`songList/insertSongList`, params);
//编辑歌单
export const updateSongList = (params) => post(`songList/updateSongList`, params);
//删除歌单
export const delSongList = (id) => get(`songList/deleteSongList?id=${id}`);

/********** 歌单歌曲相关 **********/
//根据歌单id查询歌曲
export const selectListSong = (songListId) => get(`listSong/selectListSong?songListId=${songListId}`);
//给歌单增加歌曲
export const setListSong = (params) => post(`listSong/insertListSong`, params);
//删除歌曲
export const deleteListSong = (songId,songListId) => get(`listSong/deleteListSong?songId=${songId}&songListId=${songListId}`);

/********** 用户相关 **********/
//查询用户
export const getAllConsumer =() => get(`consumer/allConsumer`);
//添加用户
export const setConsumer = (params) => post(`consumer/insertConsumer`,params);
//编辑用户
export const updateConsumer = (params) => post(`consumer/updateConsumer`,params);
//删除用户
export const delConsumer = (id) => get(`consumer/deleteConsumer?id=${id}`);
//根据用户id查询该用户的详细信息
export const selectById =(id) => get(`/consumer/selectById?id=${id}`);
