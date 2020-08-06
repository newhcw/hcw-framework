package com.hcw.framework.design.pattern.chain.two;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EndInterceptor implements Interceptor<Context> {
    @Override
    public Context plugin(Context target, InterceptiorChain chain) {
        if (log.isDebugEnabled()) {
            log.debug("结束节点执行");
        }
        target.setAge(target.getAge()+1);
        target.setMsg("结束节点执行");
        return null;
    }
}
