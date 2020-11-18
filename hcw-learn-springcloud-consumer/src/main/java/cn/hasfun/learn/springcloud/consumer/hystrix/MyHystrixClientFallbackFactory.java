package cn.hasfun.learn.springcloud.consumer.hystrix;

import cn.hasfun.learn.springcloud.consumer.client.OrderServiceClient;
import cn.hasfun.learn.springcloud.consumer.vo.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyHystrixClientFallbackFactory implements OrderServiceClient {
    private static final Logger log = LoggerFactory.getLogger(MyHystrixClientFallbackFactory.class);

    @Override
    public Goods goodsInfo(String goodsId) {
        log.error("sddddddddddddddd");
        return null;
    }
}
