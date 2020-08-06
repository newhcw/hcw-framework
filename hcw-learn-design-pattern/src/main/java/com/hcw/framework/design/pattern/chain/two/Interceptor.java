package com.hcw.framework.design.pattern.chain.two;


public interface Interceptor<T> {

    T plugin(T target, InterceptiorChain chain);

}
