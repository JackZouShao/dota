package com.alex.common.lock;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @version 1.0.0
 * @className Mutex.java
 * @author: yz
 * @date: 2021/9/7 22:05
 */
public class Mutex implements Lock, Serializable {
    private static class Sync extends AbstractQueuedSynchronizer{

        protected Sync() {
            super();
        }

        public Condition newCondition(){
            return new ConditionObject();
        }

        @Override
        protected boolean tryAcquire(int arg) {
            assert arg ==  1;
            if(compareAndSetState(0, 1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            assert  arg == 1;
            if(!isHeldExclusively()){
                throw new IllegalStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }
    }

    private Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, @NotNull TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @NotNull
    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public static void main(String[] args) throws InterruptedException {
        final  Mutex metux = new Mutex();
        new Thread(() -> {
            metux.lock();
            System.out.println(String.format("%s-thread-1获取锁成功休眠3秒...", LocalDateTime.now()));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //ignore
            }
            metux.unlock();
            System.out.println(String.format("%s-thread-1获解锁成功...", LocalDateTime.now()));
            return;
        }, "thread-1").start();
        new Thread(() -> {
            metux.lock();
            System.out.println(String.format("%s-thread-2获取锁成功...",LocalDateTime.now()));
            return;
        }, "thread-2").start();
        Thread.sleep(Integer.MAX_VALUE);


    }
}
