package com.yeye.musicserver.dao;

import com.yeye.musicserver.pojo.Rank;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @program: music-server
 * @description: 评价接口
 * @author: YEYE
 * @create: 2021-12-19
 **/
@Repository
public interface RankMapper {
    //增加
    public int insert(Rank rank);

    //查总分
    public int selectScoreSum(Integer songListId);

    //查总评分人数
    public int selectRankNum(Integer songListId);
}
