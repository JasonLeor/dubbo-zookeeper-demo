package com.test.jason;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.jason.freamwork.service.ServiceApi;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by suliguo on 2017/6/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring_dubbo.xml")
public class Test {
    @Reference(async = true)
    private ServiceApi serviceApi;
    @org.junit.Test
    public void fun1() throws ExecutionException, InterruptedException {
        String result =serviceApi.sayHello("1");

        Future<String> future = RpcContext.getContext().getFuture();
        result = future.get();
        System.out.println(  result);
    }
}
