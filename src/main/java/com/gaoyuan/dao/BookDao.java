package com.gaoyuan.dao;

import com.gaoyuan.model.Book;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/6.
 */
public interface BookDao {
    public Book getByIsbn(Map map);
    public int addbook(Book book);
    public List getall();
}
