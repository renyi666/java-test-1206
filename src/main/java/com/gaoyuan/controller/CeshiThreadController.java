package com.gaoyuan.controller;


import com.gaoyuan.dao.BookDao;
import com.gaoyuan.dao.imp.BookDaoImp;
import com.gaoyuan.model.Book;
import com.gaoyuan.service.BaseService;
import com.gaoyuan.service.TestServince;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */

 @Controller
public class CeshiThreadController implements Runnable {

    @Autowired
    private BookDao BookDao;

//    public CeshiThreadController(BookDao BookDao) {
//        this.BookDao = BookDao;
//    }
    @Override
    public void run() {

        long num = 80;
        long a;
        List<Book> result = new ArrayList();
        for (a = 0; a < num; a++) {
            Book book = new Book();
            book.setName("c");
            book.setIsbn(123);
            result.add(book);
        }
        System.out.println(new Date());

        BookDao.addbookall(result);

        System.out.println(new Date());


    }
}

