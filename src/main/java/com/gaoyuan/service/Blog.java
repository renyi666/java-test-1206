package com.gaoyuan.service;

import java.util.List;
import java.util.Map;

/**
 * Created by gaoyuan on 2017/2/16.
 */
public interface Blog {
    List getByUserId(Map map);
    int insertBlog(Map map);
    List getAll();
    List testAll();
    com.gaoyuan.model.Blog getByBlogId(Map map);
    int deleteById(Map map);

}
