import com.jason.freamwork.service.ServiceApi;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by suliguo on 2017/5/22.
 */
public class Run {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/spring_dubbo.xml");
        context.start();
        // 注意这个 bean 在改项目中并没有这个bean的实现
        //这里是 通过dubbo在zookeeper的服务列表中 通过 HelloService 获取服务
        ServiceApi api = (ServiceApi) context.getBean("HelloService");
        System.out.println(api.sayHello("this dubbo zookeeper"));
    }
}
