package cn.hasfun.learn.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HcwLearnSpringcloudOrderProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HcwLearnSpringcloudOrderProviderApplication.class, args);
    }

}
