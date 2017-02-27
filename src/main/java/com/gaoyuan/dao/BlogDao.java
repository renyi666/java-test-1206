package com.gaoyuan.dao;

import com.gaoyuan.model.Blog;

import java.util.List;
import java.util.Map;

/**
 * Created by gaoyuan on 2017/2/16.
 */
public interface BlogDao {
     List<Object> getAll();
     int insertBlog(Map map);
     List getBlog(Map map);
      List testAll();
     Blog getByBlogId(Map map);
    int deleteById(Map map);


}
