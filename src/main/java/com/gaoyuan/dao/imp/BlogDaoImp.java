package com.gaoyuan.dao.imp;

import com.gaoyuan.dao.BlogDao;
import com.gaoyuan.model.Blog;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by gaoyuan on 2017/2/16.
 */
public class BlogDaoImp  extends SqlSessionDaoSupport implements BlogDao {
    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public Blog getAll() {
        return null;
    }

    @Override
    public int insertBlog(Map map) {
        return 0;
    }

    /**
     * 根据用户id获取博客
     * @param map
     * @return
     */
    @Override
    public List<Blog> getBlog(Map map) {

        return  getSqlSession().selectList("com.gaoyuan.ceshi.mapper.blogMapper.getByUserId",map);
    }
}
