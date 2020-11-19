package cn.hasfun.learn.springcloud.consumer.hystrix;

import cn.hasfun.learn.springcloud.consumer.client.OrderServiceClient;
import cn.hasfun.learn.springcloud.consumer.vo.Goods;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyHystrixClientFallbackFactory implements FallbackFactory<OrderServiceClient> {
    private static final Logger log = LoggerFactory.getLogger(MyHystrixClientFallbackFactory.class);

    @Override
    public OrderServiceClient create(Throwable throwable) {
        return new OrderServiceClient() {
            @Override
            public Goods goodsInfo(String goodsId) {
                return new Goods("降级处理响应");
            }
        };
    }
}
