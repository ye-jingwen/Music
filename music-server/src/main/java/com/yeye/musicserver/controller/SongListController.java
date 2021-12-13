package com.yeye.musicserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.yeye.musicserver.pojo.SongList;
import com.yeye.musicserver.service.SongListService;
import com.yeye.musicserver.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: music-server
 * @description: 歌单控制器类
 * @author: YEYE
 * @create: 2021-12-13
 **/
@RestController
@RequestMapping("/songList")
public class SongListController {
    @Autowired
    SongListService songListService;

    //添加歌单
    @RequestMapping(value = "/insertSongList", method = RequestMethod.POST)
    public Object insert(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String title = request.getParameter("title").trim();
        String pic = request.getParameter("pic").trim();
        String introduction = request.getParameter("introduction").trim();
        String style = request.getParameter("style").trim();

        //保存对象到歌单中
        SongList songList = new SongList();
        songList.setTitle(title);
        songList.setTitle(pic);
        songList.setTitle(introduction);
        songList.setTitle(style);
        boolean flag = songListService.insert(songList);
        if(flag){   //保存成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"添加成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"添加失败");
        return jsonObject;
    }

    //修改歌单
    @RequestMapping(value = "/updateSongList",method = RequestMethod.POST)
    public Object updateSongList(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String title = request.getParameter("title").trim();
        String introduction = request.getParameter("introduction").trim();
        String style = request.getParameter("style").trim();

        //保存到歌单的对象中
        SongList songList = new SongList();
        songList.setId(Integer.parseInt(id));
        songList.setTitle(title);
        songList.setIntroduction(introduction);
        songList.setStyle(style);
        boolean flag = songListService.update(songList);
        if(flag){   //保存成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"修改成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"修改失败");
        return jsonObject;
    }

    //删除歌单
    @RequestMapping(value = "/deleteSongList",method = RequestMethod.GET)
    public Object deleteSongList(HttpServletRequest request){
        String id = request.getParameter("id").trim();          //id
        boolean flag = songListService.delete(Integer.parseInt(id));
        return flag;
    }

    //根据Id查询整个对象
    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    public Object selectById(HttpServletRequest request){
        String id = request.getParameter("id").trim();          //id
        return songListService.selectById(Integer.parseInt(id));
    }

    //根据标题精确查询歌单列表
    @RequestMapping(value = "/selectByTitle",method = RequestMethod.GET)
    public Object selectByTitle(HttpServletRequest request){
        String title = request.getParameter("title").trim();          //歌单标题
        return songListService.selectByTitle(title);
    }

    //根据标题模糊查询歌单列表
    @RequestMapping(value = "/selectLikeTitle",method = RequestMethod.GET)
    public Object selectLikeTitle(HttpServletRequest request){
        String title = request.getParameter("title").trim();          //歌单标题
        return songListService.selectLikeTitle("%"+title+"%");
    }
    //根据风格模糊查询歌单列表
    @RequestMapping(value = "/selectLikeStyle",method = RequestMethod.GET)
    public Object selectLikeStyle(HttpServletRequest request){
        String style = request.getParameter("style").trim();          //歌单风格
        return songListService.selectLikeStyle("%"+style+"%");
    }

    //查询所有歌单
    @RequestMapping(value = "/allSongList",method = RequestMethod.GET)
    public Object allSongList(HttpServletRequest request){
        return songListService.allSongList();
    }
}
