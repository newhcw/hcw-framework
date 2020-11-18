package cn.hasfun.learn.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"cn.hasfun"})
public class HcwLearnSpringcloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HcwLearnSpringcloudConsumerApplication.class, args);
    }

}
