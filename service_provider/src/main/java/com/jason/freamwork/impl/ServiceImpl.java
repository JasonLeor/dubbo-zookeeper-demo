package com.jason.freamwork.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jason.freamwork.service.ServiceApi;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by suliguo on 2017/5/22.
 */
@Component
@Service(timeout = 5000,retries = 0)//retries 超时重连次数
public class ServiceImpl implements ServiceApi{
    private final AtomicInteger i = new AtomicInteger();
    public String sayHello(String word) {
        String result = "request:"+word+",response:"+i.getAndIncrement();
        System.out.println(result);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List getUsers() {
        return null;
    }
}
