package com.yeye.musicserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.yeye.musicserver.pojo.Collect;
import com.yeye.musicserver.service.CollectService;
import com.yeye.musicserver.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: music-server
 * @description: 收藏
 * @author: YEYE
 * @create: 2021-12-23
 **/
@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;

    // 添加收藏
    @RequestMapping(value = "/insertCollect",method = RequestMethod.POST)
    public Object insertCollect(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String userId = request.getParameter("userId");           //用户id
        String type = request.getParameter("type");               //收藏类型（0歌曲1歌单）
        String songId = request.getParameter("songId");           //歌曲id
        if(songId==null||songId.equals("")){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"收藏歌曲为空");
            return jsonObject;
        }
        if(collectService.existSongId(Integer.parseInt(userId),Integer.parseInt(songId))){
            jsonObject.put(Consts.CODE,2);
            jsonObject.put(Consts.MSG,"已收藏");
            return jsonObject;
        }

        //保存到收藏的对象中
        Collect Collect = new Collect();
        Collect.setUserId(Integer.parseInt(userId));
        Collect.setType(new Byte(type));
        Collect.setSongId(Integer.parseInt(songId));
        boolean flag = collectService.insert(Collect);
        if(flag){   //保存成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"收藏成功");
        }else{
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"收藏失败");
        }
        return jsonObject;
    }

    //删除收藏
    @RequestMapping(value = "/deleteCollect",method = RequestMethod.GET)
    public Object deleteCollect(HttpServletRequest request){
        String userId = request.getParameter("userId");           //用户id
        String songId = request.getParameter("songId");           //歌曲id
        boolean flag = collectService.deleteByUserIdAndSongId(Integer.parseInt(userId),Integer.parseInt(songId));
        return flag;
    }

    //查询某个用户的收藏列表
    @RequestMapping(value = "/selectByUserId",method = RequestMethod.GET)
    public Object selectByUserId(HttpServletRequest request){
        String userId = request.getParameter("userId");          //用户id
        return collectService.selectByUserId(Integer.parseInt(userId));
    }
    // 查询所有收藏
    @RequestMapping(value = "/allCollect",method = RequestMethod.GET)
    public Object allCollect(HttpServletRequest request){
        return collectService.allCollect();
    }
}
