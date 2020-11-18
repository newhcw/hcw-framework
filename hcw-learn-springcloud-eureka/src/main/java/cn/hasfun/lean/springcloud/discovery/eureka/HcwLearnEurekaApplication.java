package cn.hasfun.lean.springcloud.discovery.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HcwLearnEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HcwLearnEurekaApplication.class, args);
    }

}
