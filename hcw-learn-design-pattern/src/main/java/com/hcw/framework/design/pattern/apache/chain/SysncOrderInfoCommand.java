package com.hcw.framework.design.pattern.apache.chain;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

@Slf4j
public class SysncOrderInfoCommand implements Command {
    @Override
    public boolean execute(Context context) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("同步子系统订单信息到公共订单系统");
        }
        return false;
    }
}
