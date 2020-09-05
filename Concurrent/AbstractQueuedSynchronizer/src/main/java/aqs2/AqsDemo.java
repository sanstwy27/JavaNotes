package aqs2;

import java.util.concurrent.TimeUnit;

/**
 * @author Sanstwy27
 * @create 9/5/2020
 */

public class AqsDemo {
    private static AqsLock sync = new AqsLock();
    private static volatile int number = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sync.lock();
                number++;
                sync.unlock();
            }).start();
        }

        while (Thread.activeCount() > 2) {
            // main thread is waiting
            Thread.yield();
        }
        System.out.println(number);
    }
}
