package com.gaoyuan.controller;

import com.gaoyuan.dao.BookDao;
import com.gaoyuan.dao.imp.BookDaoImp;
import com.gaoyuan.model.AjaxReturn;
import com.gaoyuan.model.Book;
import com.gaoyuan.model.ResultJson;
import com.gaoyuan.model.User;
import com.gaoyuan.service.TestServince;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

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
        String retrun_password = user.getPassword();
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
    public ModelAndView registerpage() {

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


    /**
     * 注册新用户，注册页面与登录页面共用一个即可
     *
     * @param request
     * @return
     */
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


    /**
     * 文件上传
     *
     * @param file
     * @param request
     * @param model
     */
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

    /**
     * 测试多线程
     */

    @RequestMapping(value = "ceshiThread")
    public void ceshiThread() {

//        MyThread1 myThread   =    new MyThread1();
//        Thread t1 = new Thread(myThread);
//        Thread t2 = new Thread(myThread);
//        Thread t3 = new Thread(myThread);
//        t1.start();
//        t2.start();
//        t3.start();

//        new Thread(new ThreadTest1("su")).start();
//        ThreadTest1 threadTest1 = new ThreadTest1("su");
//        ThreadTest1 threadTest2 = new ThreadTest1("su");
//        threadTest1.run();
//        threadTest2.run();
        CeshiThreadController ceshiThreadController = new CeshiThreadController();
        ceshiThreadController.run();
    }


    /**
     * 测试直接一条一条添加用时    失败 提示错误
     */
    @RequestMapping(value = "ceshiInsert")

    public void ceshiInsert() {
        long num = 80;
        int i = 10;
        long a;
        Book book = new Book();
//        for (a=0;a<i;a++){
//            long mixed  =num/a;
//            long mined = num/(a-1);
//        }
        System.out.println(new Date());

        for (a = 0; a < num; a++) {

            book.setName("c");
            book.setIsbn(a);
            BookDao.addbook(book);


        }

        System.out.println(new Date());


    }

    /**
     * 使用批量添加数据时查看时间
     */
    @RequestMapping(value = "ceshiInserta")
    public void ceshiInserta() {
        long num = 80;
        long a;
//        BookDaoImp bookDaoImp = new BookDaoImp();
        List<Book> result = new ArrayList();

        for (a = 0; a < num; a++) {
            Book book = new Book();
            book.setName("c");
            book.setIsbn(12);
            result.add(book);

        }
        System.out.println(new Date());

        BookDao.addbookall(result);
//        bookDaoImp.addbookall(result);
        System.out.println(new Date());


    }


}

class MyThread extends Thread {

    public void run() {
        String name = Thread.currentThread().getName();
        String inf = Thread.currentThread().toString();
        long idnum = Thread.currentThread().getId();
        int num = 0;
        for (int i = 0; i < 10; i++) {//不管是新建一个对象，还是两个对象，//2，都是打印20个数据
// for(;i<10;i++){//新建一个对象的时候，打印11个左右的数据 ,新建两个对象的时候，//2，会打印20个数据。//1
            System.out.println("i----------" + i + ",thread name==" + name
                    + ",threadid==" + idnum + ",thread inf==" + inf);

            num++;
        }
        System.out.println(num);
    }
}

class MyThread1 implements Runnable {

    @Override
    public void run() {
// TODO Auto-generated method stub
        String name = Thread.currentThread().getName();
        String inf = Thread.currentThread().toString();
        long idnum = Thread.currentThread().getId();
        for (int i = 0; i < 10; i++) {
            System.out.println("aaaaa----------" + ",thread name==" + name
                    + ",threadid==" + idnum + ",thread inf==" + inf);
        }
    }

}

class ThreadTest1 implements Runnable {
    String threadName;

    public ThreadTest1(String str) {
        threadName = str;
    }

    @Override
    public void run() {
// TODO Auto-generated method stub
        for (int i = 0; i < 10; i++) {
            System.out.println("执行第" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
//System.out.println("执行完第"+i);
        }
        System.out.println("结束");
    }


}
