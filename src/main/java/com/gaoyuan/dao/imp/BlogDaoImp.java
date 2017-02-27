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
    public List<Object> getAll() {


        return  getSqlSession().selectList("com.gaoyuan.ceshi.mapper.blogMapper.getAll");

    }

    @Override
    public int insertBlog(Map map) {
        return getSqlSession().insert("com.gaoyuan.ceshi.mapper.blogMapper.insertBlog",map);
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

    @Override
    public List testAll() {
        return  getSqlSession().selectList("com.gaoyuan.ceshi.mapper.blogMapper.testAll");

    }

    @Override
    public Blog getByBlogId(Map map) {
        return  getSqlSession().selectOne("com.gaoyuan.ceshi.mapper.blogMapper.getByBlogId",map);

    }

    @Override
    public int deleteById(Map map) {
        return  getSqlSession().delete("com.gaoyuan.ceshi.mapper.blogMapper.deleteById",map);

    }
}
