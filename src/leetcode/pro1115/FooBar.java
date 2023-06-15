package leetcode.pro1115;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    ReentrantLock lock = new ReentrantLock(true);

    private static ConcurrentHashMap<String, Thread> map = new ConcurrentHashMap();

    private static AtomicBoolean sign = new AtomicBoolean(true);

    public void foo(Runnable printFoo) throws InterruptedException {
        map.put("foo", Thread.currentThread());
        for(int i = 0; i < n; i++) {
            while(!sign.get()) {
                LockSupport.park();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            sign.set(false);
            LockSupport.unpark(map.get("bar"));

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        map.put("bar", Thread.currentThread());
        for (int i = 0; i < n; i++) {
            while(sign.get()) {
                LockSupport.park();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            sign.set(true);
            LockSupport.unpark(map.get("foo"));
        }
    }


}
