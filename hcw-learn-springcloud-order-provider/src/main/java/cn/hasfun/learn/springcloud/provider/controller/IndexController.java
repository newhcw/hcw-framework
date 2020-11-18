package cn.hasfun.learn.springcloud.provider.controller;

import cn.hasfun.learn.springcloud.provider.vo.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);


    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/goods/goodsInfo/{goodsId}")
    public Goods serviceUrl(@PathVariable("goodsId") String goodsId) {
        LOG.info("访问进来了",goodsId);
        return data.get(goodsId);
    }


    // 模拟数据库
    private static Map<String, Goods> data;

    static {
        data = new HashMap<>();
        data.put("1", new Goods("1", "华为", "华为手机"));  //表示调用8081端口的数据,实际上数据会放在数据库或缓存中
        data.put("2", new Goods("2", "苹果", "苹果"));
    }


}
