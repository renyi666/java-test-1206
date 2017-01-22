package com.gaoyuan.service;

import com.gaoyuan.model.Book;
import com.gaoyuan.model.User;

import java.util.Map;

/**
 * Created by Administrator on 2016/12/6.
 */
public interface TestServince {
    public Book getByIsbn(Integer isbn);

    public User getByNickname(String nickname);

    public int insertUser(Map map);

    public int judgeUser(String name);
    public  int insertFile(Map map);
    public  int InsertBookMost(Map map);
}
