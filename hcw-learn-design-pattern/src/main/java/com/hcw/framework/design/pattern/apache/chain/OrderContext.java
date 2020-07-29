package com.hcw.framework.design.pattern.apache.chain;

import lombok.Data;
import org.apache.commons.chain.impl.ContextBase;

import java.math.BigDecimal;

/**
 * Context接口。它表示命令执行的上下文,在命令间实现共享信息的传递
 */
@Data
public class OrderContext extends ContextBase {

    /**
     * 订单号
     */
    private Integer orderId;
    /**
     * 订单总价
     */
    private BigDecimal totalPrice = BigDecimal.ZERO;

    /**
     * 该笔订单已经支付的总价
     */
    private BigDecimal payTotalPrice = BigDecimal.ZERO;

    /**
     * 使用商旅卡支付的金额
     */
    private BigDecimal businessCardPayPrice = BigDecimal.ZERO;
}
