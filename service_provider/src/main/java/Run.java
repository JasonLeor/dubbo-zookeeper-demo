import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by suliguo on 2017/5/22.
 */
public class Run {
    public static void main(String[] args) throws IOException {
        // 在spring 配置中 暴露一些东西 这里 是暴露了 Bean:HelloService
        // 暴露后 在其他 客户端(消费者) 中可通过 dubbo 获取 该服务 并使用
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/spring_dubbo.xml");
        context.start();
        System.out.println("provider starting");
        System.in.read();
    }
}
