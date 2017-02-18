package com.gaoyuan.controller;

import com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember;
import com.gaoyuan.dao.UserDao;
import com.gaoyuan.model.Error;
import com.gaoyuan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by gaoyuan on 2017/2/15.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserDao UserDao;

    /**
     * 用户登录页面
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView login(HttpSession session,HttpServletRequest request) {

        if(session.getAttribute("userId")!=null){

            return new ModelAndView("redirect:/blog/index");
        }

        System.out.println(session.getAttribute("userId"));

        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    /**
     * 登录验证
     * @param request
     * @return
     */
    @RequestMapping(value = "/logincheck")
    public String logincheck(HttpServletRequest request, RedirectAttributes redirectAttributes, HttpSession session) {


        //如果为空就跳到自定义显示错误页面
        if (request.getParameter("name") == "" || request.getParameter("password") == "") {
            //跳转的时候传值
            redirectAttributes.addAttribute("status", -1);
            return "redirect:/error/index";
        }

        HashMap map = new HashMap();
        map.put("nickname", '"' + request.getParameter("name") + '"');
        User user = UserDao.getByNickname(map);

        //查询出的用户为空
        if (user == null) {
            redirectAttributes.addAttribute("status", -2);

            return "redirect:/error/index";
        }
        if(user.getPassword()!=request.getParameter("password")){
            redirectAttributes.addAttribute("status", -1);

            return "redirect:/error/index";

        }

        //设置session
        System.out.println(user.getId()+"=====================bbbbbb");
        session.setAttribute("userId", user.getId());
        session.setAttribute("userInfo",user);

        return "redirect:/blog/index";

    }

    /**
     * 用户注册页面
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/register")
    public ModelAndView register(ModelAndView modelAndView) {
        return modelAndView;
    }

    /**
     * 注册验证
     * @return
     */
    @RequestMapping(value = "/registercheck")
    public String registercheck(HttpServletRequest request, User user, RedirectAttributes redirectAttributes) {

        System.out.println(request.getParameter("name"));
        //为空则跳转错误页面
        if (request.getParameter("name") == "" || request.getParameter("password") == "") {
            redirectAttributes.addAttribute("status", -3);
            return "redirect:/error/index";

        }

        HashMap map = new HashMap();
        map.put("nickname", '"' + request.getParameter("name") + '"');
        user = UserDao.getByNickname(map);

        //查询有值  则跳转提示用户已存在
        if (user != null) {
            redirectAttributes.addAttribute("status", -4);
            return "redirect:/error/index";
        }

        map.clear();
        map.put("name",request.getParameter("name"));

        map.put("password",request.getParameter("password"));
        map.put("mobile",request.getParameter("mobile"));
        map.put("email",request.getParameter("email"));
        map.put("address",request.getParameter("address"));

        if (UserDao.insertUser(map)!=1){
            redirectAttributes.addAttribute("status", -5);
            return "redirect:/error/index";

        }

        return "redirect:/user/login";

    }

    /**
     * 用户注销
     * @param session
     * @return
     */

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){

        session.invalidate();


        return "redirect:/user/login";


    }



}
