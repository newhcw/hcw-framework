package com.hcw.framework.design.pattern.apache.chain;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;

import java.math.BigDecimal;

@Slf4j
public class BusinessPayCommand implements Filter {


    @Override
    public boolean execute(Context context) throws Exception {

        OrderContext orderContext = (OrderContext) context;

        //查询客户账户下的商旅卡余额,比如查询结果是12.5元
//        var bPrice = new BigDecimal(12.5); 禁止这种写法
        var bPrice = BigDecimal.valueOf(12.5);
        //算出还需要支付的价格
        var remainPrice = orderContext.getTotalPrice().subtract(orderContext.getPayTotalPrice());
        //该笔订单,优先商旅卡支付全额
        if (bPrice.compareTo(remainPrice) >= 0) {
            orderContext.setPayTotalPrice(orderContext.getPayTotalPrice().add(remainPrice));
            orderContext.setBusinessCardPayPrice(remainPrice);
            if (log.isDebugEnabled()) {
                log.debug("订单orderId:{} ,订单总价:{},使用商旅卡支付了：{},还需要支付:{}",orderContext.getOrderId(),orderContext.getTotalPrice(),orderContext.getBusinessCardPayPrice(),orderContext.getTotalPrice().subtract(orderContext.getPayTotalPrice()));
            }
            return true;
        }else {
            // 使用商旅卡支付部分
            orderContext.setPayTotalPrice(orderContext.getPayTotalPrice().add(bPrice));
            orderContext.setBusinessCardPayPrice(bPrice);
            if (log.isDebugEnabled()) {
                log.debug("订单orderId:{} ,订单总价:{},使用商旅卡支付了：{},还需要支付:{}",orderContext.getOrderId(),orderContext.getTotalPrice(),orderContext.getBusinessCardPayPrice(),orderContext.getTotalPrice().subtract(orderContext.getPayTotalPrice()));
            }
            return false;
        }
    }

    @Override
    public boolean postprocess(Context context, Exception e) {

        OrderContext orderContext = (OrderContext) context;
        var businessCardPayPrice = orderContext.getBusinessCardPayPrice();
        // 请求扣除账户下商旅卡
        //httpClient.post("/api/businessCard/reduce",businessCardPayPrice);
        return false;
    }

}
