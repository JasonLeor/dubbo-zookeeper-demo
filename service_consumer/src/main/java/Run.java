import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.jason.freamwork.service.ServiceApi;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by suliguo on 2017/5/22.
 */
public class Run {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/spring_dubbo.xml");
        context.start();
        // 注意这个 bean 在改项目中并没有这个bean的实现
        //这里是 通过dubbo在zookeeper的服务列表中 通过 HelloService 获取服务
        ServiceApi api = (ServiceApi) context.getBean("HelloService");
        // 1
        String result =api.sayHello("1");
//        for (int i =0;i<10;i++) {
//            System.out.println(api.sayHello("0"));
//        }
        Future future = RpcContext.getContext().getFuture();

        // 这样调用的作用是 让1处代码异步执行 然后在这句代码等待会调用
        // 还可以 使用callback 异步回调方法 然后不用在改处 等待
        //这种编程 像是 js 的callback机制
        result = (String) future.get();
        System.out.println(result);
    }
}
