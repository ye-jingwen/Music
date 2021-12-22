import Axios from "axios";
import { get, post } from "./http"

/********** 歌手相关 **********/
//查询歌手
export const getAllSinger = () => get(`singer/allSinger`);
//
//根据性别查询歌手
export const getSingerOfSex = (sex) => get(`singer/selectBySex?sex=${sex}`);

/********** 歌曲相关 **********/
//根据歌手id查询歌曲
export const selectBySingerId = (id) => get(`song/singer/selectBySingerId?singerId=${id}`);
//根据歌曲id查询歌曲对象
export const selectBySongId = (id) => get(`song/selectBySongId?id=${id}`);
//根据歌曲名字查询歌曲对象
export const selectBySongName = (songName) => get(`song/selectBySongName?songName=${songName}`);
//根据歌曲名字模糊查询歌曲
export const selectLikeSongName = (keywords) => get(`song/selectLikeSongName?songName=${keywords}`);

/********** 歌单相关 **********/
//查询歌单
export const getAllSongList = () => get(`songList/allSongList`);
//根据标题模糊查询歌单列表
export const selectLikeTitle = (keywords) => get(`songList/selectLikeTitle?title=${keywords}`);
//根据风格模糊查询歌单列表
export const selectLikeStyle = (style) => get(`songList/selectLikeStyle?style=${style}`);

/********** 歌单歌曲相关 **********/
//根据歌单id查询歌曲
export const selectListSong = (songListId) => get(`listSong/selectListSong?songListId=${songListId}`);

/********** 用户相关 **********/
//查询用户
export const getAllConsumer = () => get(`consumer/allConsumer`);
//注册
export const SignUp = (params) => post(`/consumer/insertConsumer`, params);
//登录
export const loginIn = (params) => post(`/consumer/login`, params);
//根据用户id查询该用户的详细信息
export const selectUserById = (id) => get(`/consumer/selectById?id=${id}`);
//更新用户信息
export const updateUserMsg =(params) => post(`/consumer/updateConsumer`,params);

/********** PlayBar相关 **********/
//下载音乐
export const download = (url) => Axios({
    method: 'get',
    url: url,
    responseType: 'blob',
});
//新增收藏
export const setCollect =(params) => post(`/collect/insertCollect`,params);
//指定用户的收藏列表
export const getCollectOfUserId = (userId) => get(`/collect/selectByUserId?userId=${userId}`);

/********** 评价相关 **********/
//提交评分
export const setRank = (params) => post(`/rank/insertRank`, params);
//获取指定歌单的平均分
export const getRankOfSongListId = (songListId) => get(`/rank/averageRank?songListId=${songListId}`);

/********** 评论相关 **********/
//提交评论
export const setComment = (params) => post(`/comment/insertComment`, params);
//点赞
export const setLike = (params) => post(`/comment/like`, params);
//返回当前歌单或歌曲的评论列表
export const getAllComment = (type, id) => {
    if (type == 0) {              //歌曲
        return get(`/comment/selectBySongId?songId=${id}`);
    } else {                      //歌单
        return get(`/comment/selectBySongListId?songListId=${id}`);
    }
}