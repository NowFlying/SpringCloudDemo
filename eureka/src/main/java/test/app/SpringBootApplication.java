package test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 *
 * @author guoqiangfeng
 * @since 2018/4/18
 */

@org.springframework.boot.autoconfigure.SpringBootApplication()
@EnableEurekaServer
public class SpringBootApplication {



    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

}
