package com.yeye.musicserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.yeye.musicserver.pojo.Rank;
import com.yeye.musicserver.service.RankService;
import com.yeye.musicserver.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: music-server
 * @description: 评价控制器类
 * @author: YEYE
 * @create: 2021-12-20
 **/
@RestController
@RequestMapping("/rank")
public class RankController {
    @Autowired
    private RankService rankService;

    //新增评价
    @RequestMapping(value = "/insertRank",method = RequestMethod.POST)
    public Object insertRank(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String songListId = request.getParameter("songListId");
        String consumerId = request.getParameter("consumerId");
        String score = request.getParameter("score");

        Rank rank = new Rank();
        rank.setSongListId(Integer.parseInt(songListId));
        rank.setConsumerId(Integer.parseInt(consumerId));
        rank.setScore(Integer.parseInt(score));
        boolean flag = rankService.insert(rank);
        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"评价成功");
        }else {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "评价失败");
        }
        return jsonObject;
    }

    // 计算平均分
    @RequestMapping(value = "/averageRank",method = RequestMethod.GET)
    public Object averageRank(HttpServletRequest request){
        String songListId = request.getParameter("songListId");
        return rankService.averageRank(Integer.parseInt(songListId));
    }
}
