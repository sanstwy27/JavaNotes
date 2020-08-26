package com.sanstwy27.jvmquestions.oom;

/**
 * @author Sanstwy27
 * @create 8/26/2020
 */

public class UnableToCreateNewNativeThread {
    public static void main(String[] args) {
        while(true){
            new Thread(new Runnable(){
                public void run() {
                    try {
                        Thread.sleep(Integer.MAX_VALUE);
                    } catch(InterruptedException e) { }
                }
            }).start();
        }

        /**
         * Exception in thread "main" java.lang.OutOfMemoryError: unable to create native thread: possibly out of memory or process/resource limits reached
         * 	at java.base/java.lang.Thread.start0(Native Method)
         * 	at java.base/java.lang.Thread.start(Thread.java:801)
         * 	at com.sanstwy27.jvmquestions.oom.UnableToCreateNewNativeThread.main(UnableToCreateNewNativeThread.java:19)
         */
    }
}
