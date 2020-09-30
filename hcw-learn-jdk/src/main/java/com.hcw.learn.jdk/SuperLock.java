package com.hcw.learn.jdk;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 自定义一个公平锁
 */
interface MyLock{

    public void lock() throws Exception;

    public void tryLock(long timeout,TimeUnit unit) throws Exception;

    public void unlock() throws Exception;
}

public class SuperLock implements MyLock {

    private static final VarHandle STATE;
    private  volatile int state;
    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            STATE = l.findVarHandle(SuperLock.class, "state", int.class);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    private LinkedBlockingQueue<Thread> AQS = new LinkedBlockingQueue<Thread>();

    public  int getStatus() {
        return state;
    }
    protected final void setState(int newState) {
        state = newState;
    }

    /**
     * 公平锁
     * @throws InterruptedException
     */
    @Override
    public void lock() throws InterruptedException {
        // cas 加锁:将status塞值1
        if (STATE.compareAndSet(this,0,1)){
            return;
        } else if (state ==1){//如果有锁,则进入AQS等待
            AQS.put(Thread.currentThread());
            LockSupport.park(this);
        }

    }

    /**
     * 具有锁超时功能的锁
     * @param timeout
     * @param unit
     * @throws Exception
     */
    @Override
    public synchronized void tryLock(long timeout, TimeUnit unit) throws Exception {
        long endTime = System.currentTimeMillis() + timeout;
        long hasRemaining = timeout;

        while (getStatus() ==1){
            if (hasRemaining<0){
                throw new Exception(Thread.currentThread().getName()+"  lock timeout");
            }
            AQS.put(Thread.currentThread());
            hasRemaining = endTime - System.currentTimeMillis();
            LockSupport.parkNanos(unit.toNanos(timeout));
        }
        setState(1);
    }

    @Override
    public void unlock() {
        setState(1);
        Optional.ofNullable(AQS.poll()).ifPresent(t->{LockSupport.unpark(t);});
    }

    public static void main(String[] args) {
        SuperLock lock = new SuperLock();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    lock.tryLock(1000,TimeUnit.MILLISECONDS);
                    System.out.println(Thread.currentThread().getName() + " have the lock Monitor");
                    Thread.currentThread().sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            },"t"+i).start();
        }

        System.out.println(Thread.currentThread().getName() + " is finish");

    }


}
