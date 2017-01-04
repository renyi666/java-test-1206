package com.gaoyuan.dao.imp;

import com.gaoyuan.dao.FileDao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Map;

/**
 * Created by Administrator on 2016/12/29.
 */
public class FileDaoImp  extends SqlSessionDaoSupport implements FileDao {
    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int AddFile(Map map) {
        return getSqlSession().selectOne("com.gaoyuan.ceshi.mapper.fileMapper.insertFile", map);
    }
}
