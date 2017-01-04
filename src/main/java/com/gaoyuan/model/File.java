package com.gaoyuan.model;

/**
 * Created by Administrator on 2016/12/29.
 */
public class File {
    private  int id;
    private  String name;
    private  String path;
    private  int crate_time;
    private  int update_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCrate_time() {
        return crate_time;
    }

    public void setCrate_time(int crate_time) {
        this.crate_time = crate_time;
    }

    public int getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(int update_time) {
        this.update_time = update_time;
    }
}
