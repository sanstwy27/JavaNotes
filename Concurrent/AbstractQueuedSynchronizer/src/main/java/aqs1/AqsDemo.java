package aqs1;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Sanstwy27
 * @create 9/5/2020
 */

public class AqsDemo {
    private static int resource = 0;
    private static Sync sync = new Sync();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,500, 4, TimeUnit.SECONDS,new LinkedBlockingDeque<>(500)
                , Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy()
        );
        try
        {
            for(int i = 0 ; i < 10000; ++i)
            {
                threadPoolExecutor.execute(()->{
                    sync.lock();
                    resource++;
                    sync.unlock();
                });
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            threadPoolExecutor.shutdown();
        }

        while (Thread.activeCount() > 2) {
            // main thread is waiting
            Thread.yield();
        }

        System.out.println("resource final value = " + resource);
    }
}
