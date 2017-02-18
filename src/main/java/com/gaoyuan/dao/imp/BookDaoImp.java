package com.gaoyuan.dao.imp;

import com.gaoyuan.dao.BookDao;
import com.gaoyuan.model.Book;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/6.
 */

public class BookDaoImp extends SqlSessionDaoSupport implements BookDao {
    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public Book getByIsbn(Map map) {


        return getSqlSession().selectOne("com.gaoyuan.ceshi.mapper.bookMapper.getByIsbn", map);

    }

    @Override
    public int addbook(Book book) {
        return getSqlSession().insert("com.gaoyuan.ceshi.mapper.bookMapper.addbook", book);
    }

    @Override
    public List<Book> getall() {
        System.out.println("ccc");
        return getSqlSession().selectList("com.gaoyuan.ceshi.mapper.bookMapper.getAll");
    }

    @Override
    public int addbookall(List list) {
        return getSqlSession().insert("com.gaoyuan.ceshi.mapper.bookMapper.addbookall", list);    }


}
