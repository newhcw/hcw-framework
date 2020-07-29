package com.hcw.framework.design.pattern.apache.chain;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;

import java.math.BigDecimal;

@Slf4j
public class CashPayCommand implements Filter {
    @Override
    public boolean execute(Context context) throws Exception {
        OrderContext orderContext = (OrderContext) context;

        //算出还需要支付的现金
        var remainPrice = orderContext.getTotalPrice().subtract(orderContext.getPayTotalPrice());
        if (log.isDebugEnabled()) {
            log.debug("订单orderId:{} ,订单总价:{},还需要支付现金:{}",orderContext.getOrderId(),orderContext.getTotalPrice(),remainPrice);
        }
        return false;
    }

    @Override
    public boolean postprocess(Context context, Exception e) {
        log.info("打开支付开关,客户端引导跳转收银台去支付");
        return false;
    }
}
