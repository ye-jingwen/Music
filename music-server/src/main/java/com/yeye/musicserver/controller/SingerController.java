package com.yeye.musicserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.yeye.musicserver.pojo.Singer;
import com.yeye.musicserver.service.SingerService;
import com.yeye.musicserver.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: music-server
 * @description: 歌手控制器类
 * @author: YEYE
 * @create: 2021-12-07
 **/
@RestController
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private SingerService singerService;

    //添加歌手
    @RequestMapping(value = "/insertSinger", method = RequestMethod.POST)
    public Object insertSinger(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name").trim();
        String sex = request.getParameter("sex").trim();
        String pic = request.getParameter("pic").trim();
        String birth = request.getParameter("birth").trim();
        String location = request.getParameter("location").trim();
        String introduction = request.getParameter("introduction").trim();

        //将数据库中datetime转换为yyyy-mm-dd
        DateFormat dataFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date birthDate = new Date();
        try {
            birthDate = dataFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //保存到歌手的对象中
        Singer singer = new Singer();
        singer.setName(name);
        singer.setSex(new Byte(sex));
        singer.setPic(pic);
        singer.setBirth(birthDate);
        singer.setLocation(location);
        singer.setIntroduction(introduction);
        boolean flag = singerService.insert(singer);
        if (flag) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "添加成功");
        } else {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "添加失败");
        }
        return jsonObject;
    }

    //修改歌手
    @RequestMapping(value = "/updateSinger", method = RequestMethod.POST)
    public Object updateSinger(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String name = request.getParameter("name").trim();
        String sex = request.getParameter("sex").trim();
        String pic = request.getParameter("pic").trim();
        String birth = request.getParameter("birth").trim();
        String location = request.getParameter("location").trim();
        String introduction = request.getParameter("introduction").trim();

        //将数据库中datetime转换为yyyy-mm-dd
        DateFormat dataFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date birthDate = new Date();
        try {
            birthDate = dataFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //保存到歌手的对象中
        Singer singer = new Singer();
        singer.setId(Integer.parseInt(id));
        singer.setName(name);
        singer.setSex(new Byte(sex));
        singer.setPic(pic);
        singer.setBirth(birthDate);
        singer.setLocation(location);
        singer.setIntroduction(introduction);
        boolean flag = singerService.update(singer);
        if (flag) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "修改成功");
        } else {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "修改失败");
        }
        return jsonObject;
    }

    //删除歌手
    @RequestMapping(value = "/deleteSinger", method = RequestMethod.GET)
    public Object deleteSinger(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        boolean flag = singerService.delete(Integer.parseInt(id));
//        if (flag) {
//            jsonObject.put(Consts.CODE, 1);
//            jsonObject.put(Consts.MSG, "删除成功");
//        } else {
//            jsonObject.put(Consts.CODE, 0);
//            jsonObject.put(Consts.MSG, "删除失败");
//        }
//        return jsonObject;
        return flag;
    }

    //根据id查询歌手
    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    public Singer selectById(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        return singerService.selectById(Integer.parseInt(id));
    }

    //根据性别查询歌手
    @RequestMapping(value = "/selectBySex", method = RequestMethod.GET)
    public List<Singer> selectBySex(HttpServletRequest request) {
        String sex = request.getParameter("sex").trim();
        return singerService.selectBySex(Integer.parseInt(sex));
    }

    //根据歌手名字模糊查询列表
    @RequestMapping(value = "/selectByName", method = RequestMethod.GET)
    public List<Singer> selectByName(HttpServletRequest request) {
        String name = request.getParameter("name").trim();
        return singerService.selectByName("%"+name+"%");
    }

    //查询所有歌手
    @RequestMapping(value = "/allSinger", method = RequestMethod.GET)
    public List<Singer> allSinger(HttpServletRequest request) {
        return singerService.allSinger();
    }
}
