package com.hcw.framework.design.pattern.chain.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 这种责任链:是基于数组实现的,每条节点都会执行.
 * 痛点: 不能控制某个节点结束
 */
public class InterceptiorChain {

    private List<Interceptor> interceptors = new ArrayList<>();


    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }


    public void pluginAll(Object target) {
        for (int i = 0; i < interceptors.size(); i++) {
            target = interceptors.get(i).plugin(target);
        }
    }

    public static void main(String[] args) {
        InterceptiorChain interceptiorChain = new InterceptiorChain();
        interceptiorChain.addInterceptor(new EmailInterceptor());
        interceptiorChain.addInterceptor(new LogInterceptor());
        interceptiorChain.pluginAll(new Context());
    }


}
