package com.gaoyuan.service;

import com.gaoyuan.dao.BlogDao;
import com.gaoyuan.dao.UserDao;
import com.gaoyuan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.ls.LSException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaoyuan on 2017/2/16.
 */
public class BlogService  implements  Blog{

    @Autowired
    private BlogDao BlogDao;
    @Autowired
    private UserDao UserDao;

    /**
     * 根据用户id获取博客
     * @param map
     * @return
     */
    @Override
    public List getByUserId(Map map) {

        List<com.gaoyuan.model.Blog> list   =    BlogDao.getBlog(map);
        int resultNumber        =   list.size();

        list.toArray();
        System.out.println(list.get(1)+"==============");
        for (int i=0;i<resultNumber;i++){

            HashMap map1    =    new HashMap();
            map1.put("id",list.get(i).getUser_id());
//            System.out.println(map1);
            User user   =    UserDao.getById(map1);
//            list.set(i,user);


        }

//        System.out.println(list);

       return  list;
        
    }

    /**
     * 添加博客
     * @param map
     * @return
     */
    @Override
    public int insertBlog(Map map) {
        return  BlogDao.insertBlog(map);
    }

    /**
     * 获得所有博客
     * @return
     */
    @Override
    public List getAll() {
        return  BlogDao.getAll();
        
    }

    @Override
    public List testAll() {

        return  BlogDao.testAll();
    }

    @Override
    public com.gaoyuan.model.Blog getByBlogId(Map map) {
        return  BlogDao.getByBlogId(map);
    }

    @Override
    public int deleteById(Map map) {

        return BlogDao.deleteById(map);
    }

}
