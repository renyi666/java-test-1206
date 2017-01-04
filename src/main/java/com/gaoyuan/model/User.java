package com.gaoyuan.model;

/**
 * Created by Administrator on 2016/12/10.
 */
public class User {
    private  Integer id;
    private  String nickname;
    private  Integer password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
}
