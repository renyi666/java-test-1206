package com.gaoyuan.dao.imp;

import com.gaoyuan.dao.UserDao;
import com.gaoyuan.model.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by Administrator on 2016/12/10.
 */
public class UserDaoImp extends SqlSessionDaoSupport implements UserDao {
    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public User getByNickname(Map map) {
        System.out.println(map);


        return getSqlSession().selectOne("com.gaoyuan.ceshi.mapper.userMapper.getByNickname", map);


    }

    @Override
    public int insertUser(Map map) {
        System.out.println("third");
        return getSqlSession().insert("com.gaoyuan.ceshi.mapper.userMapper.insertUser", map);
    }

    @Override
    public User getById(Map map) {

        return getSqlSession().selectOne("com.gaoyuan.ceshi.mapper.userMapper.getById", map);
    }
}
