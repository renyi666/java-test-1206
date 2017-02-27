package com.gaoyuan.controller;

import com.gaoyuan.dao.BlogDao;
import com.gaoyuan.model.User;
import com.gaoyuan.service.Blog;
import org.omg.CORBA.MARSHAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.dc.pr.PRError;

import javax.servlet.http.HttpServletRequest;
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
     * 获得所有博客
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView index(ModelAndView modelAndView, HttpSession session){

        User user   = (User) session.getAttribute("userInfo");

        HashMap map = new HashMap();
        map.put("user_id",user.getId());

//        List<com.gaoyuan.model.Blog> list   =   BlogService.getByUserId(map);
        List<com.gaoyuan.model.Blog> list1  =   BlogService.testAll();

        System.out.println(list1.size());


        modelAndView.addObject("user",user);

//        modelAndView.addObject("list",list);

        modelAndView.addObject("list1",list1);

        return  modelAndView;

    }

    /**
     * 添加博客页面
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "add")
    public  ModelAndView add( ModelAndView modelAndView){
        return  modelAndView;

    }

    /**
     * 添加博客验证
     * @param httpSession
     * @param httpServletRequest
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "addcheck")
    public String  addcheck(HttpSession httpSession, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes){

        HashMap map =    new HashMap();
        map.put("title",httpServletRequest.getParameter("title"));
        map.put("content",httpServletRequest.getParameter("content"));
        map.put("pub_date",httpServletRequest.getParameter("pub_date"));
        map.put("user_id",httpSession.getAttribute("userId"));
        int result  =BlogService.insertBlog(map);
        if(result==1){
            return "redirect:/blog/index";

        }else {
            redirectAttributes.addAttribute("status", -4);
            return "redirect:/error/index";

        }
    }

    /**
     * 博客详情
     * @param request
     * @param session
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "detail")

    public ModelAndView detail(HttpServletRequest request,HttpSession session, ModelAndView modelAndView,RedirectAttributes redirectAttributes){

        HashMap map     =    new HashMap();
        map.put("id",request.getParameter("blogid"));
        com.gaoyuan.model.Blog blog     =    BlogService.getByBlogId(map);
        if(blog==null){
            redirectAttributes.addAttribute("status", -7);
            return new ModelAndView("redirect:/error/index");
        }
        modelAndView.addObject("list",blog);
        return  modelAndView;


    }

    /**
     * 删除博客
     * @param session
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "delete")
    public String delete(HttpSession session,HttpServletRequest request,RedirectAttributes redirectAttributes){

        HashMap map =    new HashMap();
        map.put("id",request.getParameter("blogid"));
        com.gaoyuan.model.Blog blog = BlogService.getByBlogId(map);
        if(blog==null){
            redirectAttributes.addAttribute("status", -7);
            return  "redirect:/error/index";
        }


        if(BlogService.deleteById(map)!=1){
            redirectAttributes.addAttribute("status", -6);
            return  "redirect:/error/index";
        }

        String url  =request.getHeader("Referer");
        return "redirect:/blog/index";

    }
}
