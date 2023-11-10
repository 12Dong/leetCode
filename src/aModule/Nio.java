package aModule;

import java.util.concurrent.CountDownLatch;

public class Nio {

    static volatile int index = 0;

    static String str = "abc";

    public static void main(String[] argv) {
        CountDownLatch latch = new CountDownLatch(3);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int count = 10;
                while(count > 0) {
                    synchronized (this) {
                        index = index == 3 ? 0 : index;
                        System.out.println(Thread.currentThread() + " " + str.charAt(index));
                        index++;
                    }
                    count--;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
