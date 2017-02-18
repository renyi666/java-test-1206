package com.gaoyuan.controller;

import com.gaoyuan.dao.BlogDao;
import com.gaoyuan.model.User;
import com.gaoyuan.service.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.dc.pr.PRError;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaoyuan on 2017/2/16.
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private BlogDao BlogDao;
    @Autowired
    private Blog BlogService;


    /**
     * 博客首页
     * 获得用户所属博客
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView index(ModelAndView modelAndView, HttpSession session){

        User user   = (User) session.getAttribute("userInfo");

        HashMap map = new HashMap();
        map.put("user_id",user.getId());

        List<com.gaoyuan.model.Blog> list   =   BlogService.getByUserId(map);

        modelAndView.addObject("user",user);
        modelAndView.addObject("list",list);
        System.out.println(list.get(0).getTitle());

        return  modelAndView;

    }

}
