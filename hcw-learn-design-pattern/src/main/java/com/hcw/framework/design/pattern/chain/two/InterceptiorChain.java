package com.hcw.framework.design.pattern.chain.two;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 这种责任链:是基于链表实现的,控制某个节点结束
 */
public class InterceptiorChain {

    private List<Interceptor> interceptors = new ArrayList<>();


    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }


    Iterator<Interceptor> iterator = null;


    public Object plugin(Object target) {
        if (iterator == null) {
            iterator = interceptors.iterator();
        }

        if (iterator.hasNext()) {
            Interceptor next = iterator.next();
            next.plugin(target, this);
        }
        return target;
    }

    public static void main(String[] args) {
        InterceptiorChain interceptiorChain = new InterceptiorChain();
        interceptiorChain.addInterceptor(new EmailInterceptor());
        interceptiorChain.addInterceptor(new EndInterceptor());// 不会执行下面LogInterceptor节点
        interceptiorChain.addInterceptor(new LogInterceptor());
        interceptiorChain.plugin(new Context());
    }


}
