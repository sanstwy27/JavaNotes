import com.sanstwy27.*;

import java.util.concurrent.*;

/**
 * @author Sanstwy27
 * @create 8/17/2020
 */

public class SingletonTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Singleton1
        // Non-lazy loading
        System.out.println("=====");
        System.out.println("Singleton1 ...");
        Singleton1 s1 = Singleton1.INSTANCE;
        System.out.println(s1);

        // Singleton2
        // Non-lazy loading
        System.out.println("=====");
        System.out.println("Singleton2 ...");
        Singleton2 s2 = Singleton2.INSTANCE;
        System.out.println(s2);

        // Singleton3
        // Non-lazy loading
        System.out.println("=====");
        System.out.println("Singleton3 ...");
        Singleton3 s3 = Singleton3.INSTANCE;
        System.out.println(s3);


        // Singleton4 (not thread safe)
        // Lazy loading
        System.out.println("=====");
        System.out.println("Singleton4 ...");
        /*
        // --- single thread ---
        Singleton4 s4i1 = Singleton4.getInstance();
        Singleton4 s4i2 = Singleton4.getInstance();
        System.out.println(s4i1 == s4i2);
        System.out.println(s4i1);
        System.out.println(s4i1);
         */
        // --- multithread ---
        Callable<Singleton4> c = new Callable<Singleton4>() {
            @Override
            public Singleton4 call() throws Exception {
                return Singleton4.getInstance();
            }
        };
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton4> f1 = es.submit(c);
        Future<Singleton4> f2 = es.submit(c);
        Singleton4 s4f1 = f1.get();
        Singleton4 s4f2 = f2.get();
        System.out.println(s4f1 == s4f2);
        System.out.println(s4f1);
        System.out.println(s4f2);
        es.shutdown();

        // Singleton5 (thread safe)
        // Lazy loading
        System.out.println("=====");
        System.out.println("Singleton5 ...");
        Callable<Singleton5> s5c = new Callable<Singleton5>() {
            @Override
            public Singleton5 call() throws Exception {
                return Singleton5.getInstance();
            }
        };
        ExecutorService s5es = Executors.newFixedThreadPool(2);
        Future<Singleton5> s5f1 = s5es.submit(s5c);
        Future<Singleton5> s5f2 = s5es.submit(s5c);
        Singleton5 s51 = s5f1.get();
        Singleton5 s52 = s5f2.get();
        System.out.println(s51 == s52);
        System.out.println(s51);
        System.out.println(s52);
        s5es.shutdown();


        // Singleton6 (thread safe)
        // Lazy loading
        System.out.println("=====");
        System.out.println("Singleton6 ...");
        Callable<Singleton6> s6c = new Callable<Singleton6>() {
            @Override
            public Singleton6 call() throws Exception {
                return Singleton6.getInstance();
            }
        };
        ExecutorService s6es = Executors.newFixedThreadPool(2);
        Future<Singleton6> s6f1 = s6es.submit(s6c);
        Future<Singleton6> s6f2 = s6es.submit(s6c);
        Singleton6 s61 = s6f1.get();
        Singleton6 s62 = s6f2.get();
        System.out.println(s61 == s62);
        System.out.println(s61);
        System.out.println(s62);
        s6es.shutdown();
    }
}
