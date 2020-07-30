package com.hcw.framework.jdk8;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    /**
     * 如果持有锁,则返回true
     */
    @Test
    public void testisHeldByCurrentThread() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        Assertions.assertEquals(true,lock.isHeldByCurrentThread());

        lock.unlock();
        Assertions.assertEquals(false,lock.isHeldByCurrentThread());
    }
}
