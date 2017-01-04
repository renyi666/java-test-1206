package com.gaoyuan.model;

/**
 * Created by Administrator on 2016/12/6.
 */
public class Book {
     private Integer id;
    private long isbn;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
