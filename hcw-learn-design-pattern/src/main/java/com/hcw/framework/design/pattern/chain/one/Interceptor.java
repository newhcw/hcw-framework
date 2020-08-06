package com.hcw.framework.design.pattern.chain.one;

public interface Interceptor<T> {

    T plugin(T target);

}
