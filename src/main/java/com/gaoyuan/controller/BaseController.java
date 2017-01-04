package com.gaoyuan.controller;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/14.
 */
public class BaseController {


    public String[] shorSuccess(){


        String[] map    = {"status","msg","result"};
        System.out.println(map);

        return  map;
    }

}
