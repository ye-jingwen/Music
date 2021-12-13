package com.yeye.musicserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.yeye.musicserver.pojo.ListSong;
import com.yeye.musicserver.service.ListSongService;
import com.yeye.musicserver.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: music-server
 * @description: 歌单歌曲控制器类
 * @author: YEYE
 * @create: 2021-12-14
 **/
@RestController
@RequestMapping("/listSong")
public class ListSongController {
    @Autowired
    private ListSongService listSongService;

    //给歌单添加歌曲
    @RequestMapping(value = "/insertListSong", method = RequestMethod.POST)
    public Object insertListSong(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String songId = request.getParameter("songId").trim();
        String songListId = request.getParameter("songListId").trim();

        ListSong listSong = new ListSong();
        listSong.setSongId(Integer.parseInt(songId));
        listSong.setSongListId(Integer.parseInt(songListId));
        boolean flag = listSongService.insert(listSong);
        if (flag) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "保存成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "保存失败");
        return jsonObject;
    }

    //根据歌单id查询歌曲
    @RequestMapping(value = "/selectListSong", method = RequestMethod.GET)
    public Object selectListSong(HttpServletRequest request) {
        String songListId = request.getParameter("songListId");
        return listSongService.selectListSongBySongListId(Integer.parseInt(songListId));
    }

    //删除歌单里的歌曲
    @RequestMapping(value = "/deleteListSong", method = RequestMethod.GET)
    public Object deleteListSong(HttpServletRequest request) {
        String songId = request.getParameter("songId").trim();
        String songListId = request.getParameter("songListId").trim();
        boolean flag = listSongService.deleteBySongIdAndSongListId(Integer.parseInt(songId), Integer.parseInt(songListId));
        return flag;
    }
}
