package com.sanstwy27.volatileconcept;

public class VolatileVisibilityDemo {

    public static void main(String[] args) {
        MyData data = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                Thread.sleep(1000);
                data.turnTo60();
                System.out.println(Thread.currentThread().getName() + "\t updated number value: " + data.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        while (data.number == 0) {

        }

        // 1. number without volatile (endless loop)
        //    the number of main memory and child thread are 60, but it's still 0 in parent thread
        // 2. number with volatile
        //    end while loop
        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}

