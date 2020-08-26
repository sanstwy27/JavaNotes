package com.sanstwy27.jvmquestions.oom;

import java.nio.ByteBuffer;

/**
 * @author Sanstwy27
 * @create 8/26/2020
 */

public class DirectBufferMemoryDemo {
    /**
     * MaxMemory
     *   ----------------------------------------------
     *  | JVM Heap Memory    |  Direct Memory  | ... |
     *  ----------------------------------------------
     *
     */
    // -Xms10m -Xmx10m -XX:MaxDirectMemorySize=5m -Xlog:gc*
    public static void main(String[] args) {
        System.out.println("MaxMemory: " + (Runtime.getRuntime().maxMemory()) / (1024 * 1024) + "MB");
        // NIO: new I/O
        // 1. JVM Heap Memory
        // ByteBuffer.allocate();
        // 2. Direct Buffer Memory
        ByteBuffer.allocateDirect(10 * 1024 * 1024);
        /**
         * [0.049s][info][gc,heap] Heap region size: 1M
         * [0.049s][info][gc,heap,coops] Heap address: 0x00000000ff600000, size: 10 MB, Compressed Oops mode: 32-bit
         * [0.051s][info][gc           ] Using G1
         * [0.121s][info][gc           ] Periodic GC disabled
         * MaxMemory: 10MB
         * [0.451s][info][gc,task      ] GC(0) Using 1 workers of 8 for full compaction
         * [0.452s][info][gc,start     ] GC(0) Pause Full (System.gc())
         * [0.452s][info][gc,phases,start] GC(0) Phase 1: Mark live objects
         * [0.456s][info][gc,phases      ] GC(0) Phase 1: Mark live objects 4.091ms
         * [0.456s][info][gc,phases,start] GC(0) Phase 2: Prepare for compaction
         * [0.457s][info][gc,phases      ] GC(0) Phase 2: Prepare for compaction 0.843ms
         * [0.457s][info][gc,phases,start] GC(0) Phase 3: Adjust pointers
         * [0.458s][info][gc,phases      ] GC(0) Phase 3: Adjust pointers 1.647ms
         * [0.458s][info][gc,phases,start] GC(0) Phase 4: Compact heap
         * [0.461s][info][gc,phases      ] GC(0) Phase 4: Compact heap 2.016ms
         * [0.461s][info][gc,heap        ] GC(0) Eden regions: 3->0(3)
         * [0.461s][info][gc,heap        ] GC(0) Survivor regions: 0->0(0)
         * [0.461s][info][gc,heap        ] GC(0) Old regions: 0->2
         * [0.461s][info][gc,heap        ] GC(0) Archive regions: 0->0
         * [0.461s][info][gc,heap        ] GC(0) Humongous regions: 0->0
         * [0.461s][info][gc,metaspace   ] GC(0) Metaspace: 886K(4864K)->886K(4864K) NonClass: 803K(4352K)->803K(4352K) Class: 82K(512K)->82K(512K)
         * [0.461s][info][gc             ] GC(0) Pause Full (System.gc()) 2M->1M(10M) 9.360ms
         * [0.461s][info][gc,cpu         ] GC(0) User=0.02s Sys=0.00s Real=0.01s
         * Exception in thread "main" java.lang.OutOfMemoryError: Cannot reserve 10485760 bytes of direct buffer memory (allocated: 8192, limit: 5242880)
         * 	at java.base/java.nio.Bits.reserveMemory(Bits.java:178)
         * 	at java.base/java.nio.DirectByteBuffer.<init>(DirectByteBuffer.java:120)
         * 	at java.base/java.nio.ByteBuffer.allocateDirect(ByteBuffer.java:329)
         * 	at com.sanstwy27.jvmquestions.oom.DirectBufferMemoryDemo.main(DirectBufferMemoryDemo.java:24)
         * [0.995s][info][gc,heap,exit   ] Heap
         * [0.996s][info][gc,heap,exit   ]  garbage-first heap   total 10240K, used 1808K [0x00000000ff600000, 0x0000000100000000)
         * [0.996s][info][gc,heap,exit   ]   region size 1024K, 1 young (1024K), 0 survivors (0K)
         * [0.996s][info][gc,heap,exit   ]  Metaspace       used 1245K, capacity 4575K, committed 4864K, reserved 1056768K
         * [0.996s][info][gc,heap,exit   ]   class space    used 120K, capacity 417K, committed 512K, reserved 1048576K
         */
    }
}
