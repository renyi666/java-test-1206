package com.gaoyuan.service;

import com.gaoyuan.dao.BookDao;
import com.gaoyuan.dao.FileDao;
import com.gaoyuan.dao.UserDao;
import com.gaoyuan.model.Book;
import com.gaoyuan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/6.
 */
@Service
public class BaseService implements TestServince {

    @Autowired
    private BookDao BookDao;
    @Autowired

    private UserDao Userdao;
    @Autowired

    private FileDao FileDao;

    @Override
    public Book getByIsbn(Integer isbn) {
        Map<String, Integer> map = new HashMap();
        map.put("isbn", isbn);
        System.out.println(map);
        return BookDao.getByIsbn(map);


    }

    @Override
    public User getByNickname(String nickname) {
        Map<String, String> map = new HashMap();
        map.put("nickname", '"' + nickname + '"');

        return Userdao.getByNickname(map);


    }

    @Override
    public int insertFile(Map map) {
        return FileDao.AddFile(map);
    }

    @Override
    public int InsertBookMost(Map map) {
        return 0;
    }

    @Override
    public int addBookAll(List list) {
        return  BookDao.addbookall(list);
    }

    @Override
    public int insertUser(Map map) {


        return Userdao.insertUser(map);
    }

    //判断是否有这个用户
    @Override
    public int judgeUser(String name) {
        int result;

        Map<String, String> map = new HashMap();
        map.put("nickname", '"' + name + '"');
        User user = Userdao.getByNickname(map);
        if (user == null || user.equals("")) {
            result = 0;
        } else {
            result = 1;
        }
        return result;

    }
}
