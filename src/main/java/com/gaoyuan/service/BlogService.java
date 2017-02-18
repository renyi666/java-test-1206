package com.gaoyuan.service;

import com.gaoyuan.dao.BlogDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by gaoyuan on 2017/2/16.
 */
public class BlogService  implements  Blog{

    @Autowired
    private BlogDao BlogDao;

    /**
     * 根据用户id获取博客
     * @param map
     * @return
     */
    @Override
    public List getByUserId(Map map) {

        return  BlogDao.getBlog(map);
    }
}
