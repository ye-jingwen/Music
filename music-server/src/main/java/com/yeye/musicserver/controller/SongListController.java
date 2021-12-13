package com.yeye.musicserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.yeye.musicserver.pojo.SongList;
import com.yeye.musicserver.service.SongListService;
import com.yeye.musicserver.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

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
    private SongListService songListService;

    //添加歌单
    @RequestMapping(value = "/insertSongList", method = RequestMethod.POST)
    public Object insertSongList(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String title = request.getParameter("title").trim();
        String pic = request.getParameter("pic").trim();
        String introduction = request.getParameter("introduction").trim();
        String style = request.getParameter("style").trim();

        //保存对象到歌单中
        SongList songList = new SongList();
        songList.setTitle(title);
        songList.setPic(pic);
        songList.setIntroduction(introduction);
        songList.setStyle(style);
        boolean flag = songListService.insert(songList);
        if (flag) {   //保存成功
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "添加成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "添加失败");
        return jsonObject;
    }

    //修改歌单
    @RequestMapping(value = "/updateSongList", method = RequestMethod.POST)
    public Object updateSongList(HttpServletRequest request) {
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
        if (flag) {   //保存成功
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "修改成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "修改失败");
        return jsonObject;
    }

    //删除歌单
    @RequestMapping(value = "/deleteSongList", method = RequestMethod.GET)
    public Object deleteSongList(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        boolean flag = songListService.delete(Integer.parseInt(id));
        return flag;
    }

    //根据Id查询整个对象
    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    public Object selectById(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        return songListService.selectById(Integer.parseInt(id));
    }

    //根据标题精确查询歌单列表
    @RequestMapping(value = "/selectByTitle", method = RequestMethod.GET)
    public Object selectByTitle(HttpServletRequest request) {
        String title = request.getParameter("title").trim();
        return songListService.selectByTitle(title);
    }

    //根据标题模糊查询歌单列表
    @RequestMapping(value = "/selectLikeTitle", method = RequestMethod.GET)
    public Object selectLikeTitle(HttpServletRequest request) {
        String title = request.getParameter("title").trim();
        return songListService.selectLikeTitle("%" + title + "%");
    }

    //根据风格模糊查询歌单列表
    @RequestMapping(value = "/selectLikeStyle", method = RequestMethod.GET)
    public Object selectLikeStyle(HttpServletRequest request) {
        String style = request.getParameter("style").trim();
        return songListService.selectLikeStyle("%" + style + "%");
    }

    //查询所有歌单
    @RequestMapping(value = "/allSongList", method = RequestMethod.GET)
    public Object allSongList(HttpServletRequest request) {
        return songListService.allSongList();
    }

    //更新歌单图片
    @RequestMapping(value = "/updateSongListPic", method = RequestMethod.POST)
    public Object updateSongListPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id") int id) {
        JSONObject jsonObject = new JSONObject();
        if (avatorFile.isEmpty()) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "文件上传失败");
            return jsonObject;
        }
        //文件名=当前时间到毫秒+原来的文件名
        String fileName = System.currentTimeMillis() + avatorFile.getOriginalFilename();
        //文件路径
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
                + System.getProperty("file.separator") + "songListPic";
        //如果文件路径不存在，新增该路径
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdir();
        }
        //实际的文件地址
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        //存储到数据库里的相对文件地址
        String storeAvatorPath = "/img/songListPic/" + fileName;
        try {
            avatorFile.transferTo(dest);
            SongList songList = new SongList();
            songList.setId(id);
            songList.setPic(storeAvatorPath);
            boolean flag = songListService.update(songList);
            if (flag) {
                jsonObject.put(Consts.CODE, 1);
                jsonObject.put(Consts.MSG, "上传成功");
                jsonObject.put("pic", storeAvatorPath);
                return jsonObject;
            }
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "上传失败");
            return jsonObject;
        } catch (IOException e) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "上传失败" + e.getMessage());
        } finally {
            return jsonObject;
        }
    }
}
