import { get, post } from "./http"

/********** 歌手相关 **********/
//查询歌手
export const getAllSinger = () => get(`singer/allSinger`);

/********** 歌曲相关 **********/
//根据歌手id查询歌曲
export const selectBySingerId = (id) => get(`song/singer/selectBySingerId?singerId=${id}`);
//根据歌曲id查询歌曲对象
export const selectBySongId = (id) => get(`song/selectBySongId?id=${id}`);
//根据歌曲名字查询歌曲对象
export const selectBySongName = (songName) => get(`song/selectBySongName?songName=${songName}`);

/********** 歌单相关 **********/
//查询歌单
export const getAllSongList = () => get(`songList/allSongList`);

/********** 歌单歌曲相关 **********/
//根据歌单id查询歌曲
export const selectListSong = (songListId) => get(`listSong/selectListSong?songListId=${songListId}`);

/********** 用户相关 **********/
//查询用户
export const getAllConsumer = () => get(`consumer/allConsumer`);
