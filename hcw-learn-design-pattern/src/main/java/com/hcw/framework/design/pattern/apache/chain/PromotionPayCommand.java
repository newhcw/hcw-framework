package com.hcw.framework.design.pattern.apache.chain;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import java.math.BigDecimal;


@Slf4j
public class PromotionPayCommand implements Command {
    @Override
    public boolean execute(Context context) throws Exception {
        OrderContext orderContext = (OrderContext) context;

        //查询客户账户下的优惠券余额,比如查询结果是10元
        var bPrice = BigDecimal.valueOf(10);
        //算出还需要支付的价格
        var remainPrice = orderContext.getTotalPrice().subtract(orderContext.getPayTotalPrice());
        //该笔订单,优先商旅卡支付全额
        if (bPrice.compareTo(remainPrice) >= 0) {
            orderContext.setPayTotalPrice(orderContext.getPayTotalPrice().add(remainPrice));
            orderContext.setBusinessCardPayPrice(remainPrice);
            if (log.isDebugEnabled()) {
                log.debug("订单orderId:{} ,订单总价:{},使用优惠券支付了：{},还需要支付:{}",orderContext.getOrderId(),orderContext.getTotalPrice(),orderContext.getBusinessCardPayPrice(),orderContext.getTotalPrice().subtract(orderContext.getPayTotalPrice()));
            }
            return true;
        }else {
            // 使用商旅卡支付部分
            orderContext.setPayTotalPrice(orderContext.getPayTotalPrice().add(bPrice));
            orderContext.setBusinessCardPayPrice(bPrice);
            if (log.isDebugEnabled()) {
                log.debug("订单orderId:{} ,订单总价:{},使用优惠券支付了：{},还需要支付:{}",orderContext.getOrderId(),orderContext.getTotalPrice(),orderContext.getBusinessCardPayPrice(),orderContext.getTotalPrice().subtract(orderContext.getPayTotalPrice()));
            }
            return false;
        }
    }
}
