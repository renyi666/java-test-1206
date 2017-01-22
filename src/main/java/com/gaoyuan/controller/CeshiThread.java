package com.gaoyuan.controller;

/**
 * Created by Administrator on 2017/1/22.
 */
public class CeshiThread extends  Thread {
    @Override
    public void run() {
        for (int i=0;i<30;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
