package com.hcw.framework.design.pattern.apache.chain;

import org.apache.commons.chain.impl.ChainBase;

import java.math.BigDecimal;

/**
 * 这是变异后的责任链和命令模式
 *
 * 它表示“命令链”，要在其中执行的命令，需要先添加到Chain中
 */
public class OrderPayChain extends ChainBase {

    public void init() {

        //第一步: 扣优惠券
        this.addCommand(new PromotionPayCommand());
        //第二步:优先商旅卡
        this.addCommand(new BusinessPayCommand());
        //第三步: 扣现金
        this.addCommand(new CashPayCommand());
        // 同步订单信息
        this.addCommand(new SysncOrderInfoCommand());
    }


    public static void main(String[] args) throws Exception {
        var refundTicketChain = new OrderPayChain();
        refundTicketChain.init();
        var context = new OrderContext();
        context.setOrderId(1621940242);
        context.setTotalPrice(BigDecimal.valueOf(100));
        refundTicketChain.execute(context);
    }
}
