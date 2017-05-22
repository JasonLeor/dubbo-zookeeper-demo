package com.jason.freamwork.impl;

import com.jason.freamwork.service.ServiceApi;

import java.util.List;

/**
 * Created by suliguo on 2017/5/22.
 */
public class ServiceImpl implements ServiceApi{
    public String sayHello(String word) {
        return "hello "+word;
    }

    public List getUsers() {
        return null;
    }
}
