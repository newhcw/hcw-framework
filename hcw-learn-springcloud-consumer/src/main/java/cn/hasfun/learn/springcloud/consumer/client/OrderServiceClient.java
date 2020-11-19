package cn.hasfun.learn.springcloud.consumer.client;

import cn.hasfun.learn.springcloud.consumer.hystrix.MyHystrixClientFallbackFactory;
import cn.hasfun.learn.springcloud.consumer.vo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "order-provider" , fallback  = MyHystrixClientFallbackFactory.class)
public interface OrderServiceClient {

    @RequestMapping("/goods/goodsInfo/{goodsId}")
    Goods goodsInfo(@PathVariable("goodsId") String goodsId);
}
