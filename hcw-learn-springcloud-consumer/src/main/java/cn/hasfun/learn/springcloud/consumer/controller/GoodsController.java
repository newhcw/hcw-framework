package cn.hasfun.learn.springcloud.consumer.controller;

import cn.hasfun.learn.springcloud.consumer.client.OrderServiceClient;
import cn.hasfun.learn.springcloud.consumer.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private OrderServiceClient orderServiceClient;

    @RequestMapping("/place")
    public Result placeGoods(String goodsId) {
        Result result =  Result.success(orderServiceClient.goodsInfo(goodsId));
        return result;
    }

}
