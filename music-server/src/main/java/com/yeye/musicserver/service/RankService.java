package com.yeye.musicserver.service;

import com.yeye.musicserver.pojo.Rank;

/**
 * @program: music-server
 * @description: 评价业务逻辑接口
 * @author: YEYE
 * @create: 2021-12-20
 **/
public interface RankService {
    //判断是否增加成功
    public boolean insert(Rank rank);

    //查总分
    public int selectScoreSum(Integer songListId);

    //查总评分人数
    public int selectRankNum(Integer songListId);

    //计算平均分
    public int averageRank(Integer songListId);
}
