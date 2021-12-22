package com.yeye.musicserver.service.impl;

import com.yeye.musicserver.dao.RankMapper;
import com.yeye.musicserver.pojo.Rank;
import com.yeye.musicserver.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: music-server
 * @description: 评价业务逻辑实现类
 * @author: YEYE
 * @create: 2021-12-20
 **/
@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RankMapper rankMapper;

    //判断是否增加成功
    @Override
    public boolean insert(Rank rank) {
        return rankMapper.insert(rank) > 0;
    }

    //查总分
    @Override
    public int selectScoreSum(Integer songListId) {
        return rankMapper.selectScoreSum(songListId);
    }

    //查总评分人数
    @Override
    public int selectRankNum(Integer songListId) {
        return rankMapper.selectRankNum(songListId);
    }

    //计算平均分,满分10分
    @Override
    public int averageRank(Integer songListId) {
        int rankNum = rankMapper.selectRankNum(songListId);
        if (rankNum == 0) {
            return 5;
        } else {
            return rankMapper.selectScoreSum(songListId) / rankNum;
        }
    }
}
