package cn.hasfun.learn.springcloud.consumer.hystrix;

import cn.hasfun.learn.springcloud.consumer.client.OrderServiceClient;
import cn.hasfun.learn.springcloud.consumer.vo.Goods;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MyHystrixClientFallbackFactory implements FallbackFactory<OrderServiceClient> {
    private static final Logger LOG = LoggerFactory.getLogger(MyHystrixClientFallbackFactory.class);

    @Override
    public OrderServiceClient create(Throwable throwable) {
        String msg = throwable == null ? "" : throwable.getMessage();
        if (!StringUtils.isEmpty(msg)) {
            LOG.error(msg);
        }
        return new OrderServiceClient() {
            @Override
            public Goods goodsInfo(String goodsId) {
                return new Goods("降级处理响应");
            }
        };
    }
}
