package com.gaoyuan.controller;

import com.gaoyuan.dao.BookDao;
import com.gaoyuan.model.AjaxReturn;
import com.gaoyuan.model.Book;
import com.gaoyuan.model.ResultJson;
import com.gaoyuan.model.User;
import com.gaoyuan.service.TestServince;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/6.
 */
@Controller
@RequestMapping(value = "/Test")
public class TestController {
    @Autowired
    private TestServince baseService;
    @Autowired
    private BookDao BookDao;

    @RequestMapping(value = "/ceshi")
    public ModelAndView ceshi() {

        System.out.println("aaaaaa");
        return new ModelAndView("ceshi");

    }

    @RequestMapping(value = "/ceshi1")

    public void ceshi1() {
        Integer isbn = 123456789;

        baseService.getByIsbn(isbn);

        System.out.println("aaaaaa");


    }

    @RequestMapping(value = "/ceshi2")
    public
    @ResponseBody
    ResultJson ceshi2() {
        Integer isbn = 123456789;


        ResultJson resultJson = new ResultJson();
        System.out.println(baseService.getByIsbn(isbn));

        Book byIsbn = baseService.getByIsbn(isbn);
        System.out.println(byIsbn);


        System.out.print(byIsbn.getName());
        resultJson.setList(byIsbn);

        resultJson.setMsg(byIsbn.getName());


        System.out.println(resultJson);
        return resultJson;


    }

    @RequestMapping(value = "ceshi3")
    public
    @ResponseBody
    ResultJson ceshi3(HttpServletRequest request) {

        String isbn = request.getParameter("isbn");
        ResultJson resultJson = new ResultJson();

        Book byIsbn = baseService.getByIsbn(Integer.valueOf(isbn));

        System.out.print(byIsbn.getName());
        resultJson.setList(byIsbn);

        resultJson.setMsg(byIsbn.getName());


        System.out.println(resultJson);
        return resultJson;


    }

    @RequestMapping(value = "ceshi4")
    public
    @ResponseBody
    ResultJson ceshi4() {

        String nickname = "gaoyuan";
        ResultJson resultJson = new ResultJson();
        User user_result = baseService.getByNickname(nickname);
        Object object = user_result;
        resultJson.setList(object);
        System.out.println(resultJson);
        return resultJson;
    }

    @RequestMapping(value = "ceshi5")

    public
    @ResponseBody
    ResultJson ceshi5() {

        String name = "三国演义";
        System.out.println("aaa");

        long isbn = 1233333333333L;
        System.out.println(isbn);
        Book book = new Book();
        book.setIsbn(isbn);
        book.setName(name);
        ResultJson resultJson = new ResultJson();
        resultJson.setMsg(String.valueOf(BookDao.addbook(book)));

        return resultJson;

    }


    @RequestMapping(value = "all")
    public ModelAndView ALL() {
        ModelAndView modelAndView = new ModelAndView("all");
        System.out.println("bb");
        List<Book> result = BookDao.getall();


        for (Book x : result
                ) {
            System.out.println(x.getName());

        }

        modelAndView.addObject("result1", result);

        BaseController baseController = new BaseController();

        System.out.println(baseController.shorSuccess());
        return modelAndView;

    }


    @RequestMapping(value = "all1")
    public
    @ResponseBody
    ResultJson ALL1() {

        ResultJson resultJson = new ResultJson();
        List<Book> result = BookDao.getall();


        for (Book x : result
                ) {
            System.out.println(x.getName());

        }

        System.out.println("aaa");
        System.out.println(result);


        resultJson.setList(result);


        System.out.println(resultJson);
        return resultJson;


    }


    @RequestMapping(value = "dologin")
    public
    @ResponseBody
    String dologin(HttpServletRequest request) {

        String nickname = request.getParameter("nickname");
        Integer password = Integer.valueOf(request.getParameter("password"));
        System.out.println(nickname);
        System.out.println(password);
        User user = baseService.getByNickname(nickname);
        if (user == null || user.equals("")) {

            return "no user";
        }
        Integer retrun_password = user.getPassword();
        if (password.equals(retrun_password)) {

            return "success";
        }

        return "aa";

    }

    //新建一个登陆页面，实现用户名和密码的输入判断
    @RequestMapping(value = "login")
    public ModelAndView login() {

        return new ModelAndView("login");
    }

    @RequestMapping(value = "registerpage")
    public ModelAndView registerpage(){

        return new ModelAndView("registerpage");

    }
    //ajax判断传递的值是否正确
    @RequestMapping(value = "ver")
    public
    @ResponseBody
    AjaxReturn ver(HttpServletRequest request) {


        AjaxReturn ajaxReturn = new AjaxReturn();

        String name = request.getParameter("name");
        int password = Integer.parseInt(request.getParameter("password"));

        User user = baseService.getByNickname(name);


        if (user == null || user.equals("")) {

            ajaxReturn.setMsg("fail");
            return ajaxReturn;

        }
        if (user.getPassword().equals(password)) {

            ajaxReturn.setMsg("success");
            return ajaxReturn;
        }

        ajaxReturn.setMsg("fail");
        return ajaxReturn;


    }


    //注册新用户，注册页面与登录页面共用一个即可
    @RequestMapping(value = "register")
    public
    @ResponseBody
    AjaxReturn register(HttpServletRequest request) {
        AjaxReturn ajaxReturn = new AjaxReturn();
        String name = request.getParameter("name");
        int user_result = baseService.judgeUser(name);

        if (user_result == 1) {

            ajaxReturn.setMsg("fail");
            return ajaxReturn;
        }

        int password = Integer.parseInt(request.getParameter("password"));
        HashMap<String, String> map = new HashMap();
        map.put("name", name);
        map.put("password", String.valueOf(password));
        int result = baseService.insertUser(map);
        if (result == 1) {

            ajaxReturn.setMsg("success");
        } else {

            ajaxReturn.setMsg("fail");
        }

        return ajaxReturn;
    }


    //文件上传
    @RequestMapping(value = "sumbitFile")
    public void submit(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {

        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        System.out.println(path);
        System.out.println(fileName);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);


    }


}
