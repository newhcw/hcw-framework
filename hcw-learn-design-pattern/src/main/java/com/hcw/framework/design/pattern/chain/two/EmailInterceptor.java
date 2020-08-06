package com.hcw.framework.design.pattern.chain.two;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailInterceptor implements Interceptor<Context> {
    @Override
    public Context plugin(Context target, InterceptiorChain chain) {
        if (log.isDebugEnabled()) {
            log.debug("发送一个邮件");
        }
        target.setAge(target.getAge()+1);
        target.setMsg("已发邮件");
        return (Context) chain.plugin(target);
    }
}
