package com.hcw.framework.design.pattern.chain.two;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogInterceptor implements Interceptor<Context> {
    @Override
    public Context plugin(Context target, InterceptiorChain chain) {
        if (log.isDebugEnabled()) {
            log.debug(String.format("待处理数据对象:%S",target.toString()));
        }
        target.setAge(target.getAge()+1);
        target.setMsg("已打印日志");
        return (Context) chain.plugin(target);
    }
}
