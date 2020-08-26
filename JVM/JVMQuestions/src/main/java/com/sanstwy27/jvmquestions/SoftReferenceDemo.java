package com.sanstwy27.jvmquestions;

import java.lang.ref.SoftReference;

/**
 * @author Sanstwy27
 * @create 8/26/2020
 */

public class SoftReferenceDemo {
    public static void main(String[] args) {
        //demo1();
        demo2();
    }

    // Normal
    public static void demo1() {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);

        System.out.println(o);
        System.out.println(softReference.get());
        /**
         * java.lang.Object@6f539caf
         * java.lang.Object@6f539caf
         */

        o = null;
        System.gc();

        System.out.println(o);
        System.out.println(softReference.get());
        /**
         * null
         * java.lang.Object@6f539caf
         */
    }

    // Out of Memory (OOM)
    // -Xms5m -Xmx5m -XX:+PrintGCDetails
    public static void demo2() {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);

        System.out.println(o);
        System.out.println(softReference.get());
        /**
         * [0.013s][warning][gc] -XX:+PrintGCDetails is deprecated. Will use -Xlog:gc* instead.
         * [0.044s][info   ][gc,heap] Heap region size: 1M
         * [0.044s][info   ][gc,heap,coops] Heap address: 0x00000000ffa00000, size: 6 MB, Compressed Oops mode: 32-bit
         * [0.059s][info   ][gc           ] Using G1
         * [0.108s][info   ][gc           ] Periodic GC disabled
         * [0.289s][info   ][gc,start     ] GC(0) Pause Young (Normal) (G1 Evacuation Pause)
         * [0.289s][info   ][gc,task      ] GC(0) Using 2 workers of 8 for evacuation
         * [0.292s][info   ][gc,phases    ] GC(0)   Pre Evacuate Collection Set: 0.0ms
         * [0.292s][info   ][gc,phases    ] GC(0)   Merge Heap Roots: 0.0ms
         * [0.292s][info   ][gc,phases    ] GC(0)   Evacuate Collection Set: 2.5ms
         * [0.292s][info   ][gc,phases    ] GC(0)   Post Evacuate Collection Set: 0.3ms
         * [0.292s][info   ][gc,phases    ] GC(0)   Other: 0.3ms
         * [0.292s][info   ][gc,heap      ] GC(0) Eden regions: 2->0(1)
         * [0.292s][info   ][gc,heap      ] GC(0) Survivor regions: 0->1(1)
         * [0.292s][info   ][gc,heap      ] GC(0) Old regions: 0->1
         * [0.292s][info   ][gc,heap      ] GC(0) Archive regions: 0->0
         * [0.292s][info   ][gc,heap      ] GC(0) Humongous regions: 0->0
         * [0.292s][info   ][gc,metaspace ] GC(0) Metaspace: 517K(4864K)->517K(4864K) NonClass: 471K(4352K)->471K(4352K) Class: 46K(512K)->46K(512K)
         * [0.292s][info   ][gc           ] GC(0) Pause Young (Normal) (G1 Evacuation Pause) 2M->1M(6M) 3.265ms
         * [0.292s][info   ][gc,cpu       ] GC(0) User=0.00s Sys=0.00s Real=0.00s
         * java.lang.Object@6f539caf
         * java.lang.Object@6f539caf
         */

        o = null;

        try{
            byte[] bytes = new byte[30 * 1024 * 1024];
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(o);
            System.out.println(softReference.get());
            /**
             * [0.340s][info   ][gc,start     ] GC(1) Pause Young (Concurrent Start) (G1 Humongous Allocation)
             * [0.340s][info   ][gc,task      ] GC(1) Using 2 workers of 8 for evacuation
             * [0.343s][info   ][gc,phases    ] GC(1)   Pre Evacuate Collection Set: 0.0ms
             * [0.343s][info   ][gc,phases    ] GC(1)   Merge Heap Roots: 0.0ms
             * [0.343s][info   ][gc,phases    ] GC(1)   Evacuate Collection Set: 2.3ms
             * [0.343s][info   ][gc,phases    ] GC(1)   Post Evacuate Collection Set: 0.2ms
             * [0.343s][info   ][gc,phases    ] GC(1)   Other: 0.3ms
             * [0.343s][info   ][gc,heap      ] GC(1) Eden regions: 1->0(1)
             * [0.343s][info   ][gc,heap      ] GC(1) Survivor regions: 1->1(1)
             * [0.343s][info   ][gc,heap      ] GC(1) Old regions: 1->2
             * [0.343s][info   ][gc,heap      ] GC(1) Archive regions: 0->0
             * [0.343s][info   ][gc,heap      ] GC(1) Humongous regions: 0->0
             * [0.343s][info   ][gc,metaspace ] GC(1) Metaspace: 680K(4864K)->680K(4864K) NonClass: 617K(4352K)->617K(4352K) Class: 62K(512K)->62K(512K)
             * [0.343s][info   ][gc           ] GC(1) Pause Young (Concurrent Start) (G1 Humongous Allocation) 1M->1M(6M) 3.066ms
             * [0.343s][info   ][gc,cpu       ] GC(1) User=0.02s Sys=0.03s Real=0.00s
             * [0.343s][info   ][gc           ] GC(2) Concurrent Cycle
             * [0.343s][info   ][gc,marking   ] GC(2) Concurrent Clear Claimed Marks
             * [0.343s][info   ][gc,marking   ] GC(2) Concurrent Clear Claimed Marks 0.021ms
             * [0.343s][info   ][gc,marking   ] GC(2) Concurrent Scan Root Regions
             * [0.344s][info   ][gc,marking   ] GC(2) Concurrent Scan Root Regions 0.938ms
             * [0.344s][info   ][gc,marking   ] GC(2) Concurrent Mark (0.344s)
             * [0.344s][info   ][gc,start     ] GC(3) Pause Young (Normal) (G1 Humongous Allocation)
             * [0.344s][info   ][gc,marking   ] GC(2) Concurrent Mark From Roots
             * [0.344s][info   ][gc,task      ] GC(3) Using 2 workers of 8 for evacuation
             * [0.344s][info   ][gc,task      ] GC(2) Using 2 workers of 2 for marking
             * [0.344s][info   ][gc,phases    ] GC(3)   Pre Evacuate Collection Set: 0.8ms
             * [0.345s][info   ][gc,phases    ] GC(3)   Merge Heap Roots: 0.0ms
             * [0.345s][info   ][gc,phases    ] GC(3)   Evacuate Collection Set: 0.3ms
             * [0.345s][info   ][gc,phases    ] GC(3)   Post Evacuate Collection Set: 0.2ms
             * [0.345s][info   ][gc,phases    ] GC(3)   Other: 0.1ms
             * [0.345s][info   ][gc,heap      ] GC(3) Eden regions: 0->0(1)
             * [0.345s][info   ][gc,heap      ] GC(3) Survivor regions: 1->1(1)
             * [0.345s][info   ][gc,heap      ] GC(3) Old regions: 2->2
             * [0.345s][info   ][gc,heap      ] GC(3) Archive regions: 0->0
             * [0.345s][info   ][gc,heap      ] GC(3) Humongous regions: 0->0
             * [0.345s][info   ][gc,metaspace ] GC(3) Metaspace: 680K(4864K)->680K(4864K) NonClass: 617K(4352K)->617K(4352K) Class: 62K(512K)->62K(512K)
             * [0.345s][info   ][gc           ] GC(3) Pause Young (Normal) (G1 Humongous Allocation) 1M->1M(6M) 0.803ms
             * [0.345s][info   ][gc,cpu       ] GC(3) User=0.00s Sys=0.00s Real=0.00s
             * [0.345s][info   ][gc,task      ] GC(4) Using 1 workers of 8 for full compaction
             * [0.345s][info   ][gc,start     ] GC(4) Pause Full (G1 Humongous Allocation)
             * [0.345s][info   ][gc,phases,start] GC(4) Phase 1: Mark live objects
             * [0.348s][info   ][gc,phases      ] GC(4) Phase 1: Mark live objects 2.719ms
             * [0.348s][info   ][gc,phases,start] GC(4) Phase 2: Prepare for compaction
             * [0.348s][info   ][gc,phases      ] GC(4) Phase 2: Prepare for compaction 0.602ms
             * [0.348s][info   ][gc,phases,start] GC(4) Phase 3: Adjust pointers
             * [0.349s][info   ][gc,phases      ] GC(4) Phase 3: Adjust pointers 1.171ms
             * [0.349s][info   ][gc,phases,start] GC(4) Phase 4: Compact heap
             * [0.350s][info   ][gc,phases      ] GC(4) Phase 4: Compact heap 0.873ms
             * [0.351s][info   ][gc,heap        ] GC(4) Eden regions: 0->0(1)
             * [0.351s][info   ][gc,heap        ] GC(4) Survivor regions: 1->0(1)
             * [0.351s][info   ][gc,heap        ] GC(4) Old regions: 2->2
             * [0.351s][info   ][gc,heap        ] GC(4) Archive regions: 0->0
             * [0.351s][info   ][gc,heap        ] GC(4) Humongous regions: 0->0
             * [0.351s][info   ][gc,metaspace   ] GC(4) Metaspace: 680K(4864K)->680K(4864K) NonClass: 617K(4352K)->617K(4352K) Class: 62K(512K)->62K(512K)
             * [0.351s][info   ][gc             ] GC(4) Pause Full (G1 Humongous Allocation) 1M->1M(6M) 5.979ms
             * [0.351s][info   ][gc,cpu         ] GC(4) User=0.00s Sys=0.00s Real=0.01s
             * [0.351s][info   ][gc,task        ] GC(5) Using 1 workers of 8 for full compaction
             * [0.351s][info   ][gc,start       ] GC(5) Pause Full (G1 Humongous Allocation)
             * [0.351s][info   ][gc,phases,start] GC(5) Phase 1: Mark live objects
             * [0.354s][info   ][gc,phases      ] GC(5) Phase 1: Mark live objects 2.716ms
             * [0.354s][info   ][gc,phases,start] GC(5) Phase 2: Prepare for compaction
             * [0.354s][info   ][gc,phases      ] GC(5) Phase 2: Prepare for compaction 0.661ms
             * [0.354s][info   ][gc,phases,start] GC(5) Phase 3: Adjust pointers
             * [0.356s][info   ][gc,phases      ] GC(5) Phase 3: Adjust pointers 1.193ms
             * [0.356s][info   ][gc,phases,start] GC(5) Phase 4: Compact heap
             * [0.356s][info   ][gc,phases      ] GC(5) Phase 4: Compact heap 0.597ms
             * [0.357s][info   ][gc,heap        ] GC(5) Eden regions: 0->0(1)
             * [0.357s][info   ][gc,heap        ] GC(5) Survivor regions: 0->0(1)
             * [0.357s][info   ][gc,heap        ] GC(5) Old regions: 2->2
             * [0.357s][info   ][gc,heap        ] GC(5) Archive regions: 0->0
             * [0.357s][info   ][gc,heap        ] GC(5) Humongous regions: 0->0
             * [0.357s][info   ][gc,metaspace   ] GC(5) Metaspace: 680K(4864K)->680K(4864K) NonClass: 617K(4352K)->617K(4352K) Class: 62K(512K)->62K(512K)
             * [0.357s][info   ][gc             ] GC(5) Pause Full (G1 Humongous Allocation) 1M->1M(6M) 5.806ms
             * [0.357s][info   ][gc,cpu         ] GC(5) User=0.02s Sys=0.00s Real=0.00s
             * [0.357s][info   ][gc,marking     ] GC(2) Concurrent Mark From Roots 13.033ms
             * [0.357s][info   ][gc,marking     ] GC(2) Concurrent Mark Abort
             * [0.357s][info   ][gc             ] GC(2) Concurrent Cycle 14.124ms
             * null
             * null
             * [0.359s][info   ][gc,heap,exit   ] Heap
             * [0.359s][info   ][gc,heap,exit   ]  garbage-first heap   total 6144K, used 1737K [0x00000000ffa00000, 0x0000000100000000)
             * [0.359s][info   ][gc,heap,exit   ]   region size 1024K, 1 young (1024K), 0 survivors (0K)
             * [0.359s][info   ][gc,heap,exit   ]  Metaspace       used 688K, capacity 4538K, committed 4864K, reserved 1056768K
             * [0.359s][info   ][gc,heap,exit   ]   class space    used 63K, capacity 403K, committed 512K, reserved 1048576K
             * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
             * 	at com.sanstwy27.jvmquestions.SoftReferenceDemo.demo2(SoftReferenceDemo.java:55)
             * 	at com.sanstwy27.jvmquestions.SoftReferenceDemo.main(SoftReferenceDemo.java:13)
             */
        }
    }
}
