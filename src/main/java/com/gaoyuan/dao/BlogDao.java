package com.gaoyuan.dao;

import com.gaoyuan.model.Blog;

import java.util.List;
import java.util.Map;

/**
 * Created by gaoyuan on 2017/2/16.
 */
public interface BlogDao {
    public Blog getAll();
    public int insertBlog(Map map);
    public List getBlog(Map map);
}
