package com.gaoyuan.dao;

import com.gaoyuan.model.User;

import java.util.Map;

/**
 * Created by Administrator on 2016/12/10.
 */
public interface UserDao {
    public User getByNickname(Map map);
    public int insertUser(Map map);



}
