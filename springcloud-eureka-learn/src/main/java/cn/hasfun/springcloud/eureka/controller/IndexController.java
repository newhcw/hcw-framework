package cn.hasfun.springcloud.eureka.controller;

import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class IndexController {

    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);


    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/url")
    public Object serviceUrl() {

        ServiceInstance serviceInstance = loadBalancerClient.choose("SPRINGCLOUD-EUREKA-CLIENT-8081");
        String url = String.format("http://%s:%s/url",serviceInstance.getHost(),serviceInstance.getPort());
        LOG.info("sdsfffffffffffff");
        return url;
    }
}
