package com.gaoyuan.controller;

import com.gaoyuan.model.Error;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**错误页面显示
 * Created by gaoyuan on 2017/2/15.
 */
@Controller
@RequestMapping(value = "/error")
public class ErrorController {


    @RequestMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request,Error error){



        int status  = Integer.parseInt(request.getParameter("status"));

        switch (status){
            case  -1:
                error.setStatus(-1);
                error.setMessage("用户名或密码错误");
            break;
            case  -2:
                error.setStatus(-2);
                error.setMessage("查找不到该用户");
                break;
            case -3:
                error.setStatus(-3);
                error.setMessage("您填写的注册用户有一项为空");
                break;
            case -4:
                error.setMessage("用户已经存在");
                error.setStatus(-4);
                break;
            case -5:
                error.setStatus(-5);
                error.setMessage("注册用户失败");
                break;
        }


        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("error",error);

         return  modelAndView;



    }

}
