package com.hcw.framework.learn.jdk8;

import java.util.Collections;
import java.util.List;


public class CollectionsTest {



    String a = null;


    /**
     * 如果你想 new 一个空的 List ，而这个 List 以后也不会再添加元素（有大坑，看下面更新），
     * 注意的地方：
     * 这个空的集合是不能调用.add（），添加元素的。因为直接报异常。因为源码就是这么写的：直接抛异常。
     */
    public List testEmptyList(){
        if (null == a)  return Collections.EMPTY_LIST;
        return null;
    }

    /**
     * 这个方法主要用于只有一个元素的优化，减少内存分配，无需分配额外的内存，可以从SingletonList内部类看得出来,由于只有一个element,因此可以做到内存分配最小化，相比之下ArrayList的DEFAULT_CAPACITY=10个
     * @return
     */
    public List testSingleList(){
        if (null == a){
            String b = "";
           return Collections.singletonList(b);
        }
        return null;
    }

}
