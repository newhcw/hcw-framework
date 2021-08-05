package cn.hcw.dubbo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DubboConsumerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerBootstrap.class, args);
    }
}
