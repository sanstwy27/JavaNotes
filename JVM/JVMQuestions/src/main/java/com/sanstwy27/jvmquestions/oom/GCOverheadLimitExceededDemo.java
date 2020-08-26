package com.sanstwy27.jvmquestions.oom;

import java.util.Map;
import java.util.Random;

/**
 * @author Sanstwy27
 * @create 8/26/2020
 */

public class GCOverheadLimitExceededDemo {
    // -Xmx3m -XX:+UseParallelGC -Xlog:gc*
    public static void main(String[] args) {
        int i = 0;
        Map map = System.getProperties();
        Random r = new Random();
        while (true) {
            map.put(r.nextInt(), String.valueOf(++i).intern());
        }

        /**
         * [0.039s][info][gc,heap,coops] Heap address: 0x00000000ffc00000, size: 4 MB, Compressed Oops mode: 32-bit
         * [0.040s][info][gc           ] Using Parallel
         * [0.125s][info][gc,start     ] GC(0) Pause Young (Allocation Failure)
         * [0.129s][info][gc,heap      ] GC(0) PSYoungGen: 512K(1024K)->509K(1024K) Eden: 512K(512K)->0K(512K) From: 0K(512K)->509K(512K)
         * [0.129s][info][gc,heap      ] GC(0) ParOldGen: 0K(2560K)->8K(2560K)
         * [0.129s][info][gc,metaspace ] GC(0) Metaspace: 96K(4480K)->96K(4480K) NonClass: 90K(4096K)->90K(4096K) Class: 6K(384K)->6K(384K)
         * [0.129s][info][gc           ] GC(0) Pause Young (Allocation Failure) 0M->0M(3M) 3.883ms
         * [0.129s][info][gc,cpu       ] GC(0) User=0.03s Sys=0.00s Real=0.00s
         * [0.220s][info][gc,start     ] GC(1) Pause Young (Allocation Failure)
         * [0.221s][info][gc,heap      ] GC(1) PSYoungGen: 1021K(1024K)->480K(1024K) Eden: 512K(512K)->0K(512K) From: 509K(512K)->480K(512K)
         * [0.221s][info][gc,heap      ] GC(1) ParOldGen: 8K(2560K)->261K(2560K)
         * [0.221s][info][gc,metaspace ] GC(1) Metaspace: 365K(4864K)->365K(4864K) NonClass: 329K(4352K)->329K(4352K) Class: 35K(512K)->35K(512K)
         * [0.221s][info][gc           ] GC(1) Pause Young (Allocation Failure) 1M->0M(3M) 1.574ms
         * [0.221s][info][gc,cpu       ] GC(1) User=0.02s Sys=0.00s Real=0.00s
         * [0.245s][info][gc,start     ] GC(2) Pause Young (Allocation Failure)
         * [0.246s][info][gc,heap      ] GC(2) PSYoungGen: 992K(1024K)->512K(1024K) Eden: 512K(512K)->0K(512K) From: 480K(512K)->512K(512K)
         * [0.246s][info][gc,heap      ] GC(2) ParOldGen: 261K(2560K)->373K(2560K)
         * [0.246s][info][gc,metaspace ] GC(2) Metaspace: 396K(4864K)->396K(4864K) NonClass: 361K(4352K)->361K(4352K) Class: 35K(512K)->35K(512K)
         * [0.246s][info][gc           ] GC(2) Pause Young (Allocation Failure) 1M->0M(3M) 1.365ms
         * [0.246s][info][gc,cpu       ] GC(2) User=0.00s Sys=0.00s Real=0.00s
         * [0.306s][info][gc,start     ] GC(3) Pause Young (Allocation Failure)
         * [0.307s][info][gc,heap      ] GC(3) PSYoungGen: 1015K(1024K)->503K(1024K) Eden: 503K(512K)->0K(512K) From: 512K(512K)->503K(512K)
         * [0.307s][info][gc,heap      ] GC(3) ParOldGen: 373K(2560K)->781K(2560K)
         * [0.307s][info][gc,metaspace ] GC(3) Metaspace: 520K(4864K)->520K(4864K) NonClass: 474K(4352K)->474K(4352K) Class: 46K(512K)->46K(512K)
         * [0.307s][info][gc           ] GC(3) Pause Young (Allocation Failure) 1M->1M(3M) 1.572ms
         * [0.307s][info][gc,cpu       ] GC(3) User=0.00s Sys=0.00s Real=0.00s
         * [0.331s][info][gc,start     ] GC(4) Pause Young (Allocation Failure)
         * [0.332s][info][gc,heap      ] GC(4) PSYoungGen: 942K(1024K)->501K(1024K) Eden: 439K(512K)->0K(512K) From: 503K(512K)->501K(512K)
         * [0.332s][info][gc,heap      ] GC(4) ParOldGen: 781K(2560K)->1122K(2560K)
         * [0.332s][info][gc,metaspace ] GC(4) Metaspace: 526K(4864K)->526K(4864K) NonClass: 479K(4352K)->479K(4352K) Class: 46K(512K)->46K(512K)
         * [0.332s][info][gc           ] GC(4) Pause Young (Allocation Failure) 1M->1M(3M) 0.986ms
         * [0.332s][info][gc,cpu       ] GC(4) User=0.02s Sys=0.02s Real=0.00s
         * [0.382s][info][gc,start     ] GC(5) Pause Young (Allocation Failure)
         * [0.383s][info][gc,heap      ] GC(5) PSYoungGen: 1012K(1024K)->505K(1024K) Eden: 511K(512K)->0K(512K) From: 501K(512K)->505K(512K)
         * [0.383s][info][gc,heap      ] GC(5) ParOldGen: 1122K(2560K)->1482K(2560K)
         * [0.383s][info][gc,metaspace ] GC(5) Metaspace: 741K(4864K)->741K(4864K) NonClass: 675K(4352K)->675K(4352K) Class: 66K(512K)->66K(512K)
         * [0.383s][info][gc           ] GC(5) Pause Young (Allocation Failure) 2M->1M(3M) 1.761ms
         * [0.383s][info][gc,cpu       ] GC(5) User=0.00s Sys=0.00s Real=0.00s
         * [0.398s][info][gc,start     ] GC(6) Pause Young (Allocation Failure)
         * [0.401s][info][gc,heap      ] GC(6) PSYoungGen: 1017K(1024K)->505K(1024K) Eden: 512K(512K)->0K(512K) From: 505K(512K)->505K(512K)
         * [0.401s][info][gc,heap      ] GC(6) ParOldGen: 1482K(2560K)->1954K(2560K)
         * [0.401s][info][gc,metaspace ] GC(6) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.401s][info][gc           ] GC(6) Pause Young (Allocation Failure) 2M->2M(3M) 2.624ms
         * [0.401s][info][gc,cpu       ] GC(6) User=0.00s Sys=0.00s Real=0.00s
         * [0.401s][info][gc,start     ] GC(7) Pause Full (Ergonomics)
         * [0.401s][info][gc,phases,start] GC(7) Marking Phase
         * [0.404s][info][gc,phases      ] GC(7) Marking Phase 3.022ms
         * [0.404s][info][gc,phases,start] GC(7) Summary Phase
         * [0.404s][info][gc,phases      ] GC(7) Summary Phase 0.010ms
         * [0.404s][info][gc,phases,start] GC(7) Adjust Roots
         * [0.406s][info][gc,phases      ] GC(7) Adjust Roots 1.586ms
         * [0.406s][info][gc,phases,start] GC(7) Compaction Phase
         * [0.410s][info][gc,phases      ] GC(7) Compaction Phase 4.329ms
         * [0.410s][info][gc,phases,start] GC(7) Post Compact
         * [0.410s][info][gc,phases      ] GC(7) Post Compact 0.030ms
         * [0.410s][info][gc,heap        ] GC(7) PSYoungGen: 505K(1024K)->0K(1024K) Eden: 0K(512K)->0K(512K) From: 505K(512K)->0K(512K)
         * [0.410s][info][gc,heap        ] GC(7) ParOldGen: 1954K(2560K)->2319K(2560K)
         * [0.410s][info][gc,metaspace   ] GC(7) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.410s][info][gc             ] GC(7) Pause Full (Ergonomics) 2M->2M(3M) 9.208ms
         * [0.410s][info][gc,cpu         ] GC(7) User=0.03s Sys=0.00s Real=0.01s
         * [0.426s][info][gc,start       ] GC(8) Pause Full (Ergonomics)
         * [0.426s][info][gc,phases,start] GC(8) Marking Phase
         * [0.430s][info][gc,phases      ] GC(8) Marking Phase 4.640ms
         * [0.430s][info][gc,phases,start] GC(8) Summary Phase
         * [0.430s][info][gc,phases      ] GC(8) Summary Phase 0.010ms
         * [0.430s][info][gc,phases,start] GC(8) Adjust Roots
         * [0.433s][info][gc,phases      ] GC(8) Adjust Roots 2.256ms
         * [0.433s][info][gc,phases,start] GC(8) Compaction Phase
         * [0.438s][info][gc,phases      ] GC(8) Compaction Phase 5.196ms
         * [0.438s][info][gc,phases,start] GC(8) Post Compact
         * [0.438s][info][gc,phases      ] GC(8) Post Compact 0.024ms
         * [0.438s][info][gc,heap        ] GC(8) PSYoungGen: 512K(1024K)->483K(1024K) Eden: 512K(512K)->483K(512K) From: 0K(512K)->0K(512K)
         * [0.438s][info][gc,heap        ] GC(8) ParOldGen: 2319K(2560K)->2254K(2560K)
         * [0.438s][info][gc,metaspace   ] GC(8) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.438s][info][gc             ] GC(8) Pause Full (Ergonomics) 2M->2M(3M) 12.390ms
         * [0.438s][info][gc,cpu         ] GC(8) User=0.00s Sys=0.00s Real=0.01s
         * [0.440s][info][gc,start       ] GC(9) Pause Full (Ergonomics)
         * [0.440s][info][gc,phases,start] GC(9) Marking Phase
         * [0.445s][info][gc,phases      ] GC(9) Marking Phase 5.154ms
         * [0.445s][info][gc,phases,start] GC(9) Summary Phase
         * [0.445s][info][gc,phases      ] GC(9) Summary Phase 0.014ms
         * [0.445s][info][gc,phases,start] GC(9) Adjust Roots
         * [0.446s][info][gc,phases      ] GC(9) Adjust Roots 1.045ms
         * [0.446s][info][gc,phases,start] GC(9) Compaction Phase
         * [0.450s][info][gc,phases      ] GC(9) Compaction Phase 3.980ms
         * [0.450s][info][gc,phases,start] GC(9) Post Compact
         * [0.450s][info][gc,phases      ] GC(9) Post Compact 0.028ms
         * [0.450s][info][gc,heap        ] GC(9) PSYoungGen: 511K(1024K)->510K(1024K) Eden: 511K(512K)->510K(512K) From: 0K(512K)->0K(512K)
         * [0.450s][info][gc,heap        ] GC(9) ParOldGen: 2254K(2560K)->2254K(2560K)
         * [0.450s][info][gc,metaspace   ] GC(9) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.450s][info][gc             ] GC(9) Pause Full (Ergonomics) 2M->2M(3M) 10.484ms
         * [0.450s][info][gc,cpu         ] GC(9) User=0.03s Sys=0.00s Real=0.01s
         * [0.457s][info][gc,start       ] GC(10) Pause Full (Ergonomics)
         * [0.457s][info][gc,phases,start] GC(10) Marking Phase
         * [0.462s][info][gc,phases      ] GC(10) Marking Phase 5.420ms
         * [0.462s][info][gc,phases,start] GC(10) Summary Phase
         * [0.462s][info][gc,phases      ] GC(10) Summary Phase 0.015ms
         * [0.462s][info][gc,phases,start] GC(10) Adjust Roots
         * [0.463s][info][gc,phases      ] GC(10) Adjust Roots 0.618ms
         * [0.463s][info][gc,phases,start] GC(10) Compaction Phase
         * [0.465s][info][gc,phases      ] GC(10) Compaction Phase 2.110ms
         * [0.465s][info][gc,phases,start] GC(10) Post Compact
         * [0.465s][info][gc,phases      ] GC(10) Post Compact 0.028ms
         * [0.465s][info][gc,heap        ] GC(10) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.465s][info][gc,heap        ] GC(10) ParOldGen: 2254K(2560K)->2254K(2560K)
         * [0.465s][info][gc,metaspace   ] GC(10) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.465s][info][gc             ] GC(10) Pause Full (Ergonomics) 2M->2M(3M) 8.483ms
         * [0.465s][info][gc,cpu         ] GC(10) User=0.00s Sys=0.00s Real=0.01s
         * [0.468s][info][gc,start       ] GC(11) Pause Full (Ergonomics)
         * [0.468s][info][gc,phases,start] GC(11) Marking Phase
         * [0.473s][info][gc,phases      ] GC(11) Marking Phase 5.132ms
         * [0.473s][info][gc,phases,start] GC(11) Summary Phase
         * [0.473s][info][gc,phases      ] GC(11) Summary Phase 0.018ms
         * [0.473s][info][gc,phases,start] GC(11) Adjust Roots
         * [0.474s][info][gc,phases      ] GC(11) Adjust Roots 0.625ms
         * [0.474s][info][gc,phases,start] GC(11) Compaction Phase
         * [0.476s][info][gc,phases      ] GC(11) Compaction Phase 1.741ms
         * [0.476s][info][gc,phases,start] GC(11) Post Compact
         * [0.476s][info][gc,phases      ] GC(11) Post Compact 0.022ms
         * [0.476s][info][gc,heap        ] GC(11) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.476s][info][gc,heap        ] GC(11) ParOldGen: 2256K(2560K)->2256K(2560K)
         * [0.476s][info][gc,metaspace   ] GC(11) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.476s][info][gc             ] GC(11) Pause Full (Ergonomics) 2M->2M(3M) 7.824ms
         * [0.476s][info][gc,cpu         ] GC(11) User=0.05s Sys=0.00s Real=0.01s
         * [0.476s][info][gc,start       ] GC(12) Pause Full (Ergonomics)
         * [0.476s][info][gc,phases,start] GC(12) Marking Phase
         * [0.481s][info][gc,phases      ] GC(12) Marking Phase 4.613ms
         * [0.481s][info][gc,phases,start] GC(12) Summary Phase
         * [0.481s][info][gc,phases      ] GC(12) Summary Phase 0.020ms
         * [0.481s][info][gc,phases,start] GC(12) Adjust Roots
         * [0.482s][info][gc,phases      ] GC(12) Adjust Roots 0.865ms
         * [0.482s][info][gc,phases,start] GC(12) Compaction Phase
         * [0.484s][info][gc,phases      ] GC(12) Compaction Phase 2.002ms
         * [0.484s][info][gc,phases,start] GC(12) Post Compact
         * [0.484s][info][gc,phases      ] GC(12) Post Compact 0.025ms
         * [0.484s][info][gc,heap        ] GC(12) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.484s][info][gc,heap        ] GC(12) ParOldGen: 2257K(2560K)->2257K(2560K)
         * [0.484s][info][gc,metaspace   ] GC(12) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.484s][info][gc             ] GC(12) Pause Full (Ergonomics) 2M->2M(3M) 7.807ms
         * [0.484s][info][gc,cpu         ] GC(12) User=0.00s Sys=0.00s Real=0.01s
         * [0.484s][info][gc,start       ] GC(13) Pause Full (Ergonomics)
         * [0.484s][info][gc,phases,start] GC(13) Marking Phase
         * [0.489s][info][gc,phases      ] GC(13) Marking Phase 4.786ms
         * [0.489s][info][gc,phases,start] GC(13) Summary Phase
         * [0.489s][info][gc,phases      ] GC(13) Summary Phase 0.015ms
         * [0.489s][info][gc,phases,start] GC(13) Adjust Roots
         * [0.490s][info][gc,phases      ] GC(13) Adjust Roots 0.624ms
         * [0.490s][info][gc,phases,start] GC(13) Compaction Phase
         * [0.492s][info][gc,phases      ] GC(13) Compaction Phase 2.082ms
         * [0.492s][info][gc,phases,start] GC(13) Post Compact
         * [0.492s][info][gc,phases      ] GC(13) Post Compact 0.028ms
         * [0.492s][info][gc,heap        ] GC(13) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.492s][info][gc,heap        ] GC(13) ParOldGen: 2259K(2560K)->2259K(2560K)
         * [0.492s][info][gc,metaspace   ] GC(13) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.492s][info][gc             ] GC(13) Pause Full (Ergonomics) 2M->2M(3M) 7.780ms
         * [0.492s][info][gc,cpu         ] GC(13) User=0.03s Sys=0.00s Real=0.01s
         * [0.493s][info][gc,start       ] GC(14) Pause Full (Ergonomics)
         * [0.493s][info][gc,phases,start] GC(14) Marking Phase
         * [0.498s][info][gc,phases      ] GC(14) Marking Phase 4.971ms
         * [0.498s][info][gc,phases,start] GC(14) Summary Phase
         * [0.498s][info][gc,phases      ] GC(14) Summary Phase 0.016ms
         * [0.498s][info][gc,phases,start] GC(14) Adjust Roots
         * [0.499s][info][gc,phases      ] GC(14) Adjust Roots 0.628ms
         * [0.499s][info][gc,phases,start] GC(14) Compaction Phase
         * [0.501s][info][gc,phases      ] GC(14) Compaction Phase 2.293ms
         * [0.501s][info][gc,phases,start] GC(14) Post Compact
         * [0.501s][info][gc,phases      ] GC(14) Post Compact 0.027ms
         * [0.501s][info][gc,heap        ] GC(14) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.501s][info][gc,heap        ] GC(14) ParOldGen: 2260K(2560K)->2260K(2560K)
         * [0.501s][info][gc,metaspace   ] GC(14) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.501s][info][gc             ] GC(14) Pause Full (Ergonomics) 2M->2M(3M) 8.207ms
         * [0.501s][info][gc,cpu         ] GC(14) User=0.00s Sys=0.00s Real=0.01s
         * [0.502s][info][gc,start       ] GC(15) Pause Full (Ergonomics)
         * [0.502s][info][gc,phases,start] GC(15) Marking Phase
         * [0.506s][info][gc,phases      ] GC(15) Marking Phase 4.509ms
         * [0.506s][info][gc,phases,start] GC(15) Summary Phase
         * [0.506s][info][gc,phases      ] GC(15) Summary Phase 0.015ms
         * [0.506s][info][gc,phases,start] GC(15) Adjust Roots
         * [0.507s][info][gc,phases      ] GC(15) Adjust Roots 0.639ms
         * [0.507s][info][gc,phases,start] GC(15) Compaction Phase
         * [0.509s][info][gc,phases      ] GC(15) Compaction Phase 1.892ms
         * [0.509s][info][gc,phases,start] GC(15) Post Compact
         * [0.509s][info][gc,phases      ] GC(15) Post Compact 0.024ms
         * [0.509s][info][gc,heap        ] GC(15) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.509s][info][gc,heap        ] GC(15) ParOldGen: 2262K(2560K)->2262K(2560K)
         * [0.509s][info][gc,metaspace   ] GC(15) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.509s][info][gc             ] GC(15) Pause Full (Ergonomics) 2M->2M(3M) 7.308ms
         * [0.509s][info][gc,cpu         ] GC(15) User=0.03s Sys=0.00s Real=0.01s
         * [0.509s][info][gc,start       ] GC(16) Pause Full (Ergonomics)
         * [0.509s][info][gc,phases,start] GC(16) Marking Phase
         * [0.514s][info][gc,phases      ] GC(16) Marking Phase 4.550ms
         * [0.514s][info][gc,phases,start] GC(16) Summary Phase
         * [0.514s][info][gc,phases      ] GC(16) Summary Phase 0.018ms
         * [0.514s][info][gc,phases,start] GC(16) Adjust Roots
         * [0.515s][info][gc,phases      ] GC(16) Adjust Roots 0.663ms
         * [0.515s][info][gc,phases,start] GC(16) Compaction Phase
         * [0.517s][info][gc,phases      ] GC(16) Compaction Phase 2.324ms
         * [0.517s][info][gc,phases,start] GC(16) Post Compact
         * [0.517s][info][gc,phases      ] GC(16) Post Compact 0.027ms
         * [0.517s][info][gc,heap        ] GC(16) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.517s][info][gc,heap        ] GC(16) ParOldGen: 2263K(2560K)->2263K(2560K)
         * [0.517s][info][gc,metaspace   ] GC(16) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.517s][info][gc             ] GC(16) Pause Full (Ergonomics) 2M->2M(3M) 7.842ms
         * [0.517s][info][gc,cpu         ] GC(16) User=0.00s Sys=0.00s Real=0.01s
         * [0.518s][info][gc,start       ] GC(17) Pause Full (Ergonomics)
         * [0.518s][info][gc,phases,start] GC(17) Marking Phase
         * [0.523s][info][gc,phases      ] GC(17) Marking Phase 5.179ms
         * [0.523s][info][gc,phases,start] GC(17) Summary Phase
         * [0.523s][info][gc,phases      ] GC(17) Summary Phase 0.017ms
         * [0.523s][info][gc,phases,start] GC(17) Adjust Roots
         * [0.524s][info][gc,phases      ] GC(17) Adjust Roots 0.621ms
         * [0.524s][info][gc,phases,start] GC(17) Compaction Phase
         * [0.526s][info][gc,phases      ] GC(17) Compaction Phase 1.877ms
         * [0.526s][info][gc,phases,start] GC(17) Post Compact
         * [0.526s][info][gc,phases      ] GC(17) Post Compact 0.028ms
         * [0.526s][info][gc,heap        ] GC(17) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.526s][info][gc,heap        ] GC(17) ParOldGen: 2265K(2560K)->2265K(2560K)
         * [0.526s][info][gc,metaspace   ] GC(17) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.526s][info][gc             ] GC(17) Pause Full (Ergonomics) 2M->2M(3M) 7.979ms
         * [0.526s][info][gc,cpu         ] GC(17) User=0.03s Sys=0.00s Real=0.01s
         * [0.526s][info][gc,start       ] GC(18) Pause Full (Ergonomics)
         * [0.526s][info][gc,phases,start] GC(18) Marking Phase
         * [0.531s][info][gc,phases      ] GC(18) Marking Phase 4.482ms
         * [0.531s][info][gc,phases,start] GC(18) Summary Phase
         * [0.531s][info][gc,phases      ] GC(18) Summary Phase 0.018ms
         * [0.531s][info][gc,phases,start] GC(18) Adjust Roots
         * [0.531s][info][gc,phases      ] GC(18) Adjust Roots 0.620ms
         * [0.531s][info][gc,phases,start] GC(18) Compaction Phase
         * [0.533s][info][gc,phases      ] GC(18) Compaction Phase 1.836ms
         * [0.533s][info][gc,phases,start] GC(18) Post Compact
         * [0.533s][info][gc,phases      ] GC(18) Post Compact 0.026ms
         * [0.533s][info][gc,heap        ] GC(18) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.533s][info][gc,heap        ] GC(18) ParOldGen: 2266K(2560K)->2266K(2560K)
         * [0.533s][info][gc,metaspace   ] GC(18) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.533s][info][gc             ] GC(18) Pause Full (Ergonomics) 2M->2M(3M) 7.228ms
         * [0.533s][info][gc,cpu         ] GC(18) User=0.00s Sys=0.00s Real=0.01s
         * [0.534s][info][gc,start       ] GC(19) Pause Full (Ergonomics)
         * [0.534s][info][gc,phases,start] GC(19) Marking Phase
         * [0.538s][info][gc,phases      ] GC(19) Marking Phase 4.592ms
         * [0.538s][info][gc,phases,start] GC(19) Summary Phase
         * [0.538s][info][gc,phases      ] GC(19) Summary Phase 0.016ms
         * [0.538s][info][gc,phases,start] GC(19) Adjust Roots
         * [0.539s][info][gc,phases      ] GC(19) Adjust Roots 1.019ms
         * [0.539s][info][gc,phases,start] GC(19) Compaction Phase
         * [0.541s][info][gc,phases      ] GC(19) Compaction Phase 1.839ms
         * [0.541s][info][gc,phases,start] GC(19) Post Compact
         * [0.541s][info][gc,phases      ] GC(19) Post Compact 0.032ms
         * [0.541s][info][gc,heap        ] GC(19) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.541s][info][gc,heap        ] GC(19) ParOldGen: 2268K(2560K)->2268K(2560K)
         * [0.541s][info][gc,metaspace   ] GC(19) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.541s][info][gc             ] GC(19) Pause Full (Ergonomics) 2M->2M(3M) 7.781ms
         * [0.541s][info][gc,cpu         ] GC(19) User=0.03s Sys=0.00s Real=0.01s
         * [0.542s][info][gc,start       ] GC(20) Pause Full (Ergonomics)
         * [0.542s][info][gc,phases,start] GC(20) Marking Phase
         * [0.548s][info][gc,phases      ] GC(20) Marking Phase 5.370ms
         * [0.548s][info][gc,phases,start] GC(20) Summary Phase
         * [0.548s][info][gc,phases      ] GC(20) Summary Phase 0.018ms
         * [0.548s][info][gc,phases,start] GC(20) Adjust Roots
         * [0.548s][info][gc,phases      ] GC(20) Adjust Roots 0.656ms
         * [0.548s][info][gc,phases,start] GC(20) Compaction Phase
         * [0.551s][info][gc,phases      ] GC(20) Compaction Phase 2.161ms
         * [0.551s][info][gc,phases,start] GC(20) Post Compact
         * [0.551s][info][gc,phases      ] GC(20) Post Compact 0.028ms
         * [0.551s][info][gc,heap        ] GC(20) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.551s][info][gc,heap        ] GC(20) ParOldGen: 2269K(2560K)->2269K(2560K)
         * [0.551s][info][gc,metaspace   ] GC(20) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.551s][info][gc             ] GC(20) Pause Full (Ergonomics) 2M->2M(3M) 8.485ms
         * [0.551s][info][gc,cpu         ] GC(20) User=0.02s Sys=0.00s Real=0.01s
         * [0.551s][info][gc,start       ] GC(21) Pause Full (Ergonomics)
         * [0.551s][info][gc,phases,start] GC(21) Marking Phase
         * [0.557s][info][gc,phases      ] GC(21) Marking Phase 5.539ms
         * [0.557s][info][gc,phases,start] GC(21) Summary Phase
         * [0.557s][info][gc,phases      ] GC(21) Summary Phase 0.016ms
         * [0.557s][info][gc,phases,start] GC(21) Adjust Roots
         * [0.558s][info][gc,phases      ] GC(21) Adjust Roots 0.666ms
         * [0.558s][info][gc,phases,start] GC(21) Compaction Phase
         * [0.559s][info][gc,phases      ] GC(21) Compaction Phase 1.796ms
         * [0.559s][info][gc,phases,start] GC(21) Post Compact
         * [0.560s][info][gc,phases      ] GC(21) Post Compact 0.027ms
         * [0.560s][info][gc,heap        ] GC(21) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.560s][info][gc,heap        ] GC(21) ParOldGen: 2271K(2560K)->2271K(2560K)
         * [0.560s][info][gc,metaspace   ] GC(21) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.560s][info][gc             ] GC(21) Pause Full (Ergonomics) 2M->2M(3M) 8.280ms
         * [0.560s][info][gc,cpu         ] GC(21) User=0.00s Sys=0.00s Real=0.01s
         * [0.560s][info][gc,start       ] GC(22) Pause Full (Ergonomics)
         * [0.560s][info][gc,phases,start] GC(22) Marking Phase
         * [0.565s][info][gc,phases      ] GC(22) Marking Phase 5.132ms
         * [0.565s][info][gc,phases,start] GC(22) Summary Phase
         * [0.565s][info][gc,phases      ] GC(22) Summary Phase 0.017ms
         * [0.565s][info][gc,phases,start] GC(22) Adjust Roots
         * [0.566s][info][gc,phases      ] GC(22) Adjust Roots 0.981ms
         * [0.566s][info][gc,phases,start] GC(22) Compaction Phase
         * [0.568s][info][gc,phases      ] GC(22) Compaction Phase 1.991ms
         * [0.568s][info][gc,phases,start] GC(22) Post Compact
         * [0.568s][info][gc,phases      ] GC(22) Post Compact 0.026ms
         * [0.568s][info][gc,heap        ] GC(22) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.568s][info][gc,heap        ] GC(22) ParOldGen: 2272K(2560K)->2272K(2560K)
         * [0.568s][info][gc,metaspace   ] GC(22) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.568s][info][gc             ] GC(22) Pause Full (Ergonomics) 2M->2M(3M) 8.443ms
         * [0.568s][info][gc,cpu         ] GC(22) User=0.02s Sys=0.00s Real=0.01s
         * [0.569s][info][gc,start       ] GC(23) Pause Full (Ergonomics)
         * [0.569s][info][gc,phases,start] GC(23) Marking Phase
         * [0.573s][info][gc,phases      ] GC(23) Marking Phase 4.385ms
         * [0.573s][info][gc,phases,start] GC(23) Summary Phase
         * [0.573s][info][gc,phases      ] GC(23) Summary Phase 0.017ms
         * [0.573s][info][gc,phases,start] GC(23) Adjust Roots
         * [0.574s][info][gc,phases      ] GC(23) Adjust Roots 0.471ms
         * [0.574s][info][gc,phases,start] GC(23) Compaction Phase
         * [0.575s][info][gc,phases      ] GC(23) Compaction Phase 1.917ms
         * [0.576s][info][gc,phases,start] GC(23) Post Compact
         * [0.576s][info][gc,phases      ] GC(23) Post Compact 0.026ms
         * [0.576s][info][gc,heap        ] GC(23) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.576s][info][gc,heap        ] GC(23) ParOldGen: 2274K(2560K)->2274K(2560K)
         * [0.576s][info][gc,metaspace   ] GC(23) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.576s][info][gc             ] GC(23) Pause Full (Ergonomics) 2M->2M(3M) 7.026ms
         * [0.576s][info][gc,cpu         ] GC(23) User=0.00s Sys=0.00s Real=0.01s
         * [0.576s][info][gc,start       ] GC(24) Pause Full (Ergonomics)
         * [0.576s][info][gc,phases,start] GC(24) Marking Phase
         * [0.582s][info][gc,phases      ] GC(24) Marking Phase 5.697ms
         * [0.582s][info][gc,phases,start] GC(24) Summary Phase
         * [0.582s][info][gc,phases      ] GC(24) Summary Phase 0.020ms
         * [0.582s][info][gc,phases,start] GC(24) Adjust Roots
         * [0.583s][info][gc,phases      ] GC(24) Adjust Roots 1.064ms
         * [0.583s][info][gc,phases,start] GC(24) Compaction Phase
         * [0.585s][info][gc,phases      ] GC(24) Compaction Phase 1.794ms
         * [0.585s][info][gc,phases,start] GC(24) Post Compact
         * [0.585s][info][gc,phases      ] GC(24) Post Compact 0.033ms
         * [0.585s][info][gc,heap        ] GC(24) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.585s][info][gc,heap        ] GC(24) ParOldGen: 2275K(2560K)->2275K(2560K)
         * [0.585s][info][gc,metaspace   ] GC(24) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.585s][info][gc             ] GC(24) Pause Full (Ergonomics) 2M->2M(3M) 8.879ms
         * [0.585s][info][gc,cpu         ] GC(24) User=0.02s Sys=0.00s Real=0.01s
         * [0.585s][info][gc,start       ] GC(25) Pause Full (Ergonomics)
         * [0.585s][info][gc,phases,start] GC(25) Marking Phase
         * [0.590s][info][gc,phases      ] GC(25) Marking Phase 4.460ms
         * [0.590s][info][gc,phases,start] GC(25) Summary Phase
         * [0.590s][info][gc,phases      ] GC(25) Summary Phase 0.018ms
         * [0.590s][info][gc,phases,start] GC(25) Adjust Roots
         * [0.590s][info][gc,phases      ] GC(25) Adjust Roots 0.684ms
         * [0.590s][info][gc,phases,start] GC(25) Compaction Phase
         * [0.592s][info][gc,phases      ] GC(25) Compaction Phase 1.960ms
         * [0.592s][info][gc,phases,start] GC(25) Post Compact
         * [0.592s][info][gc,phases      ] GC(25) Post Compact 0.037ms
         * [0.593s][info][gc,heap        ] GC(25) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.593s][info][gc,heap        ] GC(25) ParOldGen: 2277K(2560K)->2277K(2560K)
         * [0.593s][info][gc,metaspace   ] GC(25) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.593s][info][gc             ] GC(25) Pause Full (Ergonomics) 2M->2M(3M) 7.455ms
         * [0.593s][info][gc,cpu         ] GC(25) User=0.00s Sys=0.00s Real=0.01s
         * [0.593s][info][gc,start       ] GC(26) Pause Full (Ergonomics)
         * [0.593s][info][gc,phases,start] GC(26) Marking Phase
         * [0.599s][info][gc,phases      ] GC(26) Marking Phase 5.788ms
         * [0.599s][info][gc,phases,start] GC(26) Summary Phase
         * [0.599s][info][gc,phases      ] GC(26) Summary Phase 0.027ms
         * [0.599s][info][gc,phases,start] GC(26) Adjust Roots
         * [0.600s][info][gc,phases      ] GC(26) Adjust Roots 0.728ms
         * [0.600s][info][gc,phases,start] GC(26) Compaction Phase
         * [0.601s][info][gc,phases      ] GC(26) Compaction Phase 1.815ms
         * [0.602s][info][gc,phases,start] GC(26) Post Compact
         * [0.602s][info][gc,phases      ] GC(26) Post Compact 0.019ms
         * [0.602s][info][gc,heap        ] GC(26) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.602s][info][gc,heap        ] GC(26) ParOldGen: 2278K(2560K)->2278K(2560K)
         * [0.602s][info][gc,metaspace   ] GC(26) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.602s][info][gc             ] GC(26) Pause Full (Ergonomics) 2M->2M(3M) 8.656ms
         * [0.602s][info][gc,cpu         ] GC(26) User=0.03s Sys=0.00s Real=0.01s
         * [0.602s][info][gc,start       ] GC(27) Pause Full (Ergonomics)
         * [0.602s][info][gc,phases,start] GC(27) Marking Phase
         * [0.606s][info][gc,phases      ] GC(27) Marking Phase 4.337ms
         * [0.606s][info][gc,phases,start] GC(27) Summary Phase
         * [0.606s][info][gc,phases      ] GC(27) Summary Phase 0.017ms
         * [0.606s][info][gc,phases,start] GC(27) Adjust Roots
         * [0.607s][info][gc,phases      ] GC(27) Adjust Roots 0.558ms
         * [0.607s][info][gc,phases,start] GC(27) Compaction Phase
         * [0.608s][info][gc,phases      ] GC(27) Compaction Phase 1.257ms
         * [0.608s][info][gc,phases,start] GC(27) Post Compact
         * [0.608s][info][gc,phases      ] GC(27) Post Compact 0.016ms
         * [0.608s][info][gc,heap        ] GC(27) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.608s][info][gc,heap        ] GC(27) ParOldGen: 2280K(2560K)->2280K(2560K)
         * [0.608s][info][gc,metaspace   ] GC(27) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.608s][info][gc             ] GC(27) Pause Full (Ergonomics) 2M->2M(3M) 6.346ms
         * [0.608s][info][gc,cpu         ] GC(27) User=0.00s Sys=0.00s Real=0.01s
         * [0.608s][info][gc,start       ] GC(28) Pause Full (Ergonomics)
         * [0.608s][info][gc,phases,start] GC(28) Marking Phase
         * [0.612s][info][gc,phases      ] GC(28) Marking Phase 3.845ms
         * [0.612s][info][gc,phases,start] GC(28) Summary Phase
         * [0.612s][info][gc,phases      ] GC(28) Summary Phase 0.017ms
         * [0.612s][info][gc,phases,start] GC(28) Adjust Roots
         * [0.613s][info][gc,phases      ] GC(28) Adjust Roots 0.624ms
         * [0.613s][info][gc,phases,start] GC(28) Compaction Phase
         * [0.615s][info][gc,phases      ] GC(28) Compaction Phase 1.819ms
         * [0.615s][info][gc,phases,start] GC(28) Post Compact
         * [0.615s][info][gc,phases      ] GC(28) Post Compact 0.017ms
         * [0.615s][info][gc,heap        ] GC(28) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.615s][info][gc,heap        ] GC(28) ParOldGen: 2281K(2560K)->2281K(2560K)
         * [0.615s][info][gc,metaspace   ] GC(28) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.615s][info][gc             ] GC(28) Pause Full (Ergonomics) 2M->2M(3M) 6.499ms
         * [0.615s][info][gc,cpu         ] GC(28) User=0.02s Sys=0.00s Real=0.01s
         * [0.615s][info][gc,start       ] GC(29) Pause Full (Ergonomics)
         * [0.615s][info][gc,phases,start] GC(29) Marking Phase
         * [0.618s][info][gc,phases      ] GC(29) Marking Phase 3.389ms
         * [0.618s][info][gc,phases,start] GC(29) Summary Phase
         * [0.619s][info][gc,phases      ] GC(29) Summary Phase 0.013ms
         * [0.619s][info][gc,phases,start] GC(29) Adjust Roots
         * [0.619s][info][gc,phases      ] GC(29) Adjust Roots 0.623ms
         * [0.619s][info][gc,phases,start] GC(29) Compaction Phase
         * [0.621s][info][gc,phases      ] GC(29) Compaction Phase 1.503ms
         * [0.621s][info][gc,phases,start] GC(29) Post Compact
         * [0.621s][info][gc,phases      ] GC(29) Post Compact 0.018ms
         * [0.621s][info][gc,heap        ] GC(29) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.621s][info][gc,heap        ] GC(29) ParOldGen: 2283K(2560K)->2283K(2560K)
         * [0.621s][info][gc,metaspace   ] GC(29) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.621s][info][gc             ] GC(29) Pause Full (Ergonomics) 2M->2M(3M) 5.705ms
         * [0.621s][info][gc,cpu         ] GC(29) User=0.00s Sys=0.00s Real=0.01s
         * [0.621s][info][gc,start       ] GC(30) Pause Full (Ergonomics)
         * [0.621s][info][gc,phases,start] GC(30) Marking Phase
         * [0.624s][info][gc,phases      ] GC(30) Marking Phase 3.284ms
         * [0.624s][info][gc,phases,start] GC(30) Summary Phase
         * [0.624s][info][gc,phases      ] GC(30) Summary Phase 0.008ms
         * [0.624s][info][gc,phases,start] GC(30) Adjust Roots
         * [0.625s][info][gc,phases      ] GC(30) Adjust Roots 0.416ms
         * [0.625s][info][gc,phases,start] GC(30) Compaction Phase
         * [0.626s][info][gc,phases      ] GC(30) Compaction Phase 1.210ms
         * [0.626s][info][gc,phases,start] GC(30) Post Compact
         * [0.626s][info][gc,phases      ] GC(30) Post Compact 0.015ms
         * [0.626s][info][gc,heap        ] GC(30) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.626s][info][gc,heap        ] GC(30) ParOldGen: 2284K(2560K)->2284K(2560K)
         * [0.626s][info][gc,metaspace   ] GC(30) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.626s][info][gc             ] GC(30) Pause Full (Ergonomics) 2M->2M(3M) 5.062ms
         * [0.626s][info][gc,cpu         ] GC(30) User=0.00s Sys=0.00s Real=0.00s
         * [0.626s][info][gc,start       ] GC(31) Pause Full (Ergonomics)
         * [0.626s][info][gc,phases,start] GC(31) Marking Phase
         * [0.630s][info][gc,phases      ] GC(31) Marking Phase 4.179ms
         * [0.630s][info][gc,phases,start] GC(31) Summary Phase
         * [0.630s][info][gc,phases      ] GC(31) Summary Phase 0.015ms
         * [0.630s][info][gc,phases,start] GC(31) Adjust Roots
         * [0.631s][info][gc,phases      ] GC(31) Adjust Roots 0.714ms
         * [0.631s][info][gc,phases,start] GC(31) Compaction Phase
         * [0.633s][info][gc,phases      ] GC(31) Compaction Phase 2.152ms
         * [0.633s][info][gc,phases,start] GC(31) Post Compact
         * [0.633s][info][gc,phases      ] GC(31) Post Compact 0.030ms
         * [0.633s][info][gc,heap        ] GC(31) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.633s][info][gc,heap        ] GC(31) ParOldGen: 2286K(2560K)->2286K(2560K)
         * [0.633s][info][gc,metaspace   ] GC(31) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.634s][info][gc             ] GC(31) Pause Full (Ergonomics) 2M->2M(3M) 7.344ms
         * [0.634s][info][gc,cpu         ] GC(31) User=0.03s Sys=0.00s Real=0.01s
         * [0.634s][info][gc,start       ] GC(32) Pause Full (Ergonomics)
         * [0.634s][info][gc,phases,start] GC(32) Marking Phase
         * [0.638s][info][gc,phases      ] GC(32) Marking Phase 3.883ms
         * [0.638s][info][gc,phases,start] GC(32) Summary Phase
         * [0.638s][info][gc,phases      ] GC(32) Summary Phase 0.009ms
         * [0.638s][info][gc,phases,start] GC(32) Adjust Roots
         * [0.638s][info][gc,phases      ] GC(32) Adjust Roots 0.436ms
         * [0.638s][info][gc,phases,start] GC(32) Compaction Phase
         * [0.639s][info][gc,phases      ] GC(32) Compaction Phase 1.228ms
         * [0.639s][info][gc,phases,start] GC(32) Post Compact
         * [0.639s][info][gc,phases      ] GC(32) Post Compact 0.017ms
         * [0.639s][info][gc,heap        ] GC(32) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.639s][info][gc,heap        ] GC(32) ParOldGen: 2287K(2560K)->2287K(2560K)
         * [0.639s][info][gc,metaspace   ] GC(32) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.639s][info][gc             ] GC(32) Pause Full (Ergonomics) 2M->2M(3M) 5.717ms
         * [0.639s][info][gc,cpu         ] GC(32) User=0.00s Sys=0.00s Real=0.01s
         * [0.640s][info][gc,start       ] GC(33) Pause Full (Ergonomics)
         * [0.640s][info][gc,phases,start] GC(33) Marking Phase
         * [0.644s][info][gc,phases      ] GC(33) Marking Phase 3.847ms
         * [0.644s][info][gc,phases,start] GC(33) Summary Phase
         * [0.644s][info][gc,phases      ] GC(33) Summary Phase 0.017ms
         * [0.644s][info][gc,phases,start] GC(33) Adjust Roots
         * [0.644s][info][gc,phases      ] GC(33) Adjust Roots 0.464ms
         * [0.644s][info][gc,phases,start] GC(33) Compaction Phase
         * [0.646s][info][gc,phases      ] GC(33) Compaction Phase 2.267ms
         * [0.646s][info][gc,phases,start] GC(33) Post Compact
         * [0.646s][info][gc,phases      ] GC(33) Post Compact 0.028ms
         * [0.646s][info][gc,heap        ] GC(33) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.646s][info][gc,heap        ] GC(33) ParOldGen: 2289K(2560K)->2289K(2560K)
         * [0.646s][info][gc,metaspace   ] GC(33) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.646s][info][gc             ] GC(33) Pause Full (Ergonomics) 2M->2M(3M) 6.820ms
         * [0.646s][info][gc,cpu         ] GC(33) User=0.02s Sys=0.00s Real=0.01s
         * [0.647s][info][gc,start       ] GC(34) Pause Full (Ergonomics)
         * [0.647s][info][gc,phases,start] GC(34) Marking Phase
         * [0.652s][info][gc,phases      ] GC(34) Marking Phase 5.352ms
         * [0.652s][info][gc,phases,start] GC(34) Summary Phase
         * [0.652s][info][gc,phases      ] GC(34) Summary Phase 0.015ms
         * [0.652s][info][gc,phases,start] GC(34) Adjust Roots
         * [0.653s][info][gc,phases      ] GC(34) Adjust Roots 0.688ms
         * [0.653s][info][gc,phases,start] GC(34) Compaction Phase
         * [0.655s][info][gc,phases      ] GC(34) Compaction Phase 1.752ms
         * [0.655s][info][gc,phases,start] GC(34) Post Compact
         * [0.655s][info][gc,phases      ] GC(34) Post Compact 0.028ms
         * [0.655s][info][gc,heap        ] GC(34) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.655s][info][gc,heap        ] GC(34) ParOldGen: 2290K(2560K)->2290K(2560K)
         * [0.655s][info][gc,metaspace   ] GC(34) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.655s][info][gc             ] GC(34) Pause Full (Ergonomics) 2M->2M(3M) 8.054ms
         * [0.655s][info][gc,cpu         ] GC(34) User=0.00s Sys=0.00s Real=0.01s
         * [0.655s][info][gc,start       ] GC(35) Pause Full (Ergonomics)
         * [0.655s][info][gc,phases,start] GC(35) Marking Phase
         * [0.660s][info][gc,phases      ] GC(35) Marking Phase 5.402ms
         * [0.661s][info][gc,phases,start] GC(35) Summary Phase
         * [0.661s][info][gc,phases      ] GC(35) Summary Phase 0.016ms
         * [0.661s][info][gc,phases,start] GC(35) Adjust Roots
         * [0.661s][info][gc,phases      ] GC(35) Adjust Roots 0.658ms
         * [0.661s][info][gc,phases,start] GC(35) Compaction Phase
         * [0.663s][info][gc,phases      ] GC(35) Compaction Phase 2.086ms
         * [0.663s][info][gc,phases,start] GC(35) Post Compact
         * [0.663s][info][gc,phases      ] GC(35) Post Compact 0.028ms
         * [0.663s][info][gc,heap        ] GC(35) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.663s][info][gc,heap        ] GC(35) ParOldGen: 2292K(2560K)->2292K(2560K)
         * [0.663s][info][gc,metaspace   ] GC(35) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.663s][info][gc             ] GC(35) Pause Full (Ergonomics) 2M->2M(3M) 8.429ms
         * [0.664s][info][gc,cpu         ] GC(35) User=0.03s Sys=0.00s Real=0.01s
         * [0.664s][info][gc,start       ] GC(36) Pause Full (Ergonomics)
         * [0.664s][info][gc,phases,start] GC(36) Marking Phase
         * [0.669s][info][gc,phases      ] GC(36) Marking Phase 4.913ms
         * [0.669s][info][gc,phases,start] GC(36) Summary Phase
         * [0.669s][info][gc,phases      ] GC(36) Summary Phase 0.016ms
         * [0.669s][info][gc,phases,start] GC(36) Adjust Roots
         * [0.670s][info][gc,phases      ] GC(36) Adjust Roots 0.727ms
         * [0.670s][info][gc,phases,start] GC(36) Compaction Phase
         * [0.672s][info][gc,phases      ] GC(36) Compaction Phase 2.196ms
         * [0.672s][info][gc,phases,start] GC(36) Post Compact
         * [0.672s][info][gc,phases      ] GC(36) Post Compact 0.024ms
         * [0.672s][info][gc,heap        ] GC(36) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.672s][info][gc,heap        ] GC(36) ParOldGen: 2293K(2560K)->2293K(2560K)
         * [0.672s][info][gc,metaspace   ] GC(36) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.672s][info][gc             ] GC(36) Pause Full (Ergonomics) 2M->2M(3M) 8.158ms
         * [0.672s][info][gc,cpu         ] GC(36) User=0.00s Sys=0.00s Real=0.01s
         * [0.673s][info][gc,start       ] GC(37) Pause Full (Ergonomics)
         * [0.673s][info][gc,phases,start] GC(37) Marking Phase
         * [0.678s][info][gc,phases      ] GC(37) Marking Phase 4.698ms
         * [0.678s][info][gc,phases,start] GC(37) Summary Phase
         * [0.678s][info][gc,phases      ] GC(37) Summary Phase 0.019ms
         * [0.678s][info][gc,phases,start] GC(37) Adjust Roots
         * [0.678s][info][gc,phases      ] GC(37) Adjust Roots 0.715ms
         * [0.678s][info][gc,phases,start] GC(37) Compaction Phase
         * [0.681s][info][gc,phases      ] GC(37) Compaction Phase 2.775ms
         * [0.681s][info][gc,phases,start] GC(37) Post Compact
         * [0.681s][info][gc,phases      ] GC(37) Post Compact 0.033ms
         * [0.681s][info][gc,heap        ] GC(37) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.681s][info][gc,heap        ] GC(37) ParOldGen: 2295K(2560K)->2295K(2560K)
         * [0.681s][info][gc,metaspace   ] GC(37) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.681s][info][gc             ] GC(37) Pause Full (Ergonomics) 2M->2M(3M) 8.519ms
         * [0.681s][info][gc,cpu         ] GC(37) User=0.03s Sys=0.00s Real=0.01s
         * [0.682s][info][gc,start       ] GC(38) Pause Full (Ergonomics)
         * [0.682s][info][gc,phases,start] GC(38) Marking Phase
         * [0.686s][info][gc,phases      ] GC(38) Marking Phase 4.419ms
         * [0.686s][info][gc,phases,start] GC(38) Summary Phase
         * [0.686s][info][gc,phases      ] GC(38) Summary Phase 0.013ms
         * [0.686s][info][gc,phases,start] GC(38) Adjust Roots
         * [0.687s][info][gc,phases      ] GC(38) Adjust Roots 0.641ms
         * [0.687s][info][gc,phases,start] GC(38) Compaction Phase
         * [0.689s][info][gc,phases      ] GC(38) Compaction Phase 1.976ms
         * [0.689s][info][gc,phases,start] GC(38) Post Compact
         * [0.689s][info][gc,phases      ] GC(38) Post Compact 0.029ms
         * [0.689s][info][gc,heap        ] GC(38) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.689s][info][gc,heap        ] GC(38) ParOldGen: 2296K(2560K)->2296K(2560K)
         * [0.689s][info][gc,metaspace   ] GC(38) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.689s][info][gc             ] GC(38) Pause Full (Ergonomics) 2M->2M(3M) 7.333ms
         * [0.689s][info][gc,cpu         ] GC(38) User=0.00s Sys=0.00s Real=0.01s
         * [0.689s][info][gc,start       ] GC(39) Pause Full (Ergonomics)
         * [0.689s][info][gc,phases,start] GC(39) Marking Phase
         * [0.694s][info][gc,phases      ] GC(39) Marking Phase 4.832ms
         * [0.694s][info][gc,phases,start] GC(39) Summary Phase
         * [0.694s][info][gc,phases      ] GC(39) Summary Phase 0.017ms
         * [0.694s][info][gc,phases,start] GC(39) Adjust Roots
         * [0.695s][info][gc,phases      ] GC(39) Adjust Roots 0.662ms
         * [0.695s][info][gc,phases,start] GC(39) Compaction Phase
         * [0.697s][info][gc,phases      ] GC(39) Compaction Phase 2.089ms
         * [0.697s][info][gc,phases,start] GC(39) Post Compact
         * [0.697s][info][gc,phases      ] GC(39) Post Compact 0.028ms
         * [0.697s][info][gc,heap        ] GC(39) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.697s][info][gc,heap        ] GC(39) ParOldGen: 2298K(2560K)->2298K(2560K)
         * [0.697s][info][gc,metaspace   ] GC(39) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.697s][info][gc             ] GC(39) Pause Full (Ergonomics) 2M->2M(3M) 7.871ms
         * [0.697s][info][gc,cpu         ] GC(39) User=0.03s Sys=0.00s Real=0.01s
         * [0.697s][info][gc,start       ] GC(40) Pause Full (Ergonomics)
         * [0.697s][info][gc,phases,start] GC(40) Marking Phase
         * [0.702s][info][gc,phases      ] GC(40) Marking Phase 4.030ms
         * [0.702s][info][gc,phases,start] GC(40) Summary Phase
         * [0.702s][info][gc,phases      ] GC(40) Summary Phase 0.018ms
         * [0.702s][info][gc,phases,start] GC(40) Adjust Roots
         * [0.702s][info][gc,phases      ] GC(40) Adjust Roots 0.703ms
         * [0.702s][info][gc,phases,start] GC(40) Compaction Phase
         * [0.704s][info][gc,phases      ] GC(40) Compaction Phase 1.900ms
         * [0.704s][info][gc,phases,start] GC(40) Post Compact
         * [0.704s][info][gc,phases      ] GC(40) Post Compact 0.026ms
         * [0.704s][info][gc,heap        ] GC(40) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.704s][info][gc,heap        ] GC(40) ParOldGen: 2299K(2560K)->2299K(2560K)
         * [0.704s][info][gc,metaspace   ] GC(40) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.704s][info][gc             ] GC(40) Pause Full (Ergonomics) 2M->2M(3M) 6.920ms
         * [0.704s][info][gc,cpu         ] GC(40) User=0.00s Sys=0.00s Real=0.01s
         * [0.705s][info][gc,start       ] GC(41) Pause Full (Ergonomics)
         * [0.705s][info][gc,phases,start] GC(41) Marking Phase
         * [0.709s][info][gc,phases      ] GC(41) Marking Phase 4.796ms
         * [0.710s][info][gc,phases,start] GC(41) Summary Phase
         * [0.710s][info][gc,phases      ] GC(41) Summary Phase 0.015ms
         * [0.710s][info][gc,phases,start] GC(41) Adjust Roots
         * [0.710s][info][gc,phases      ] GC(41) Adjust Roots 0.671ms
         * [0.710s][info][gc,phases,start] GC(41) Compaction Phase
         * [0.712s][info][gc,phases      ] GC(41) Compaction Phase 1.799ms
         * [0.712s][info][gc,phases,start] GC(41) Post Compact
         * [0.712s][info][gc,phases      ] GC(41) Post Compact 0.025ms
         * [0.712s][info][gc,heap        ] GC(41) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.712s][info][gc,heap        ] GC(41) ParOldGen: 2301K(2560K)->2301K(2560K)
         * [0.712s][info][gc,metaspace   ] GC(41) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.712s][info][gc             ] GC(41) Pause Full (Ergonomics) 2M->2M(3M) 7.560ms
         * [0.712s][info][gc,cpu         ] GC(41) User=0.03s Sys=0.00s Real=0.01s
         * [0.713s][info][gc,start       ] GC(42) Pause Full (Ergonomics)
         * [0.713s][info][gc,phases,start] GC(42) Marking Phase
         * [0.719s][info][gc,phases      ] GC(42) Marking Phase 6.279ms
         * [0.719s][info][gc,phases,start] GC(42) Summary Phase
         * [0.719s][info][gc,phases      ] GC(42) Summary Phase 0.016ms
         * [0.719s][info][gc,phases,start] GC(42) Adjust Roots
         * [0.720s][info][gc,phases      ] GC(42) Adjust Roots 0.696ms
         * [0.720s][info][gc,phases,start] GC(42) Compaction Phase
         * [0.722s][info][gc,phases      ] GC(42) Compaction Phase 1.992ms
         * [0.722s][info][gc,phases,start] GC(42) Post Compact
         * [0.722s][info][gc,phases      ] GC(42) Post Compact 0.029ms
         * [0.722s][info][gc,heap        ] GC(42) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.722s][info][gc,heap        ] GC(42) ParOldGen: 2302K(2560K)->2302K(2560K)
         * [0.722s][info][gc,metaspace   ] GC(42) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.722s][info][gc             ] GC(42) Pause Full (Ergonomics) 2M->2M(3M) 9.254ms
         * [0.722s][info][gc,cpu         ] GC(42) User=0.02s Sys=0.00s Real=0.01s
         * [0.723s][info][gc,start       ] GC(43) Pause Full (Ergonomics)
         * [0.723s][info][gc,phases,start] GC(43) Marking Phase
         * [0.727s][info][gc,phases      ] GC(43) Marking Phase 4.816ms
         * [0.727s][info][gc,phases,start] GC(43) Summary Phase
         * [0.727s][info][gc,phases      ] GC(43) Summary Phase 0.019ms
         * [0.727s][info][gc,phases,start] GC(43) Adjust Roots
         * [0.728s][info][gc,phases      ] GC(43) Adjust Roots 0.730ms
         * [0.728s][info][gc,phases,start] GC(43) Compaction Phase
         * [0.730s][info][gc,phases      ] GC(43) Compaction Phase 2.016ms
         * [0.730s][info][gc,phases,start] GC(43) Post Compact
         * [0.730s][info][gc,phases      ] GC(43) Post Compact 0.027ms
         * [0.730s][info][gc,heap        ] GC(43) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.730s][info][gc,heap        ] GC(43) ParOldGen: 2304K(2560K)->2304K(2560K)
         * [0.730s][info][gc,metaspace   ] GC(43) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.730s][info][gc             ] GC(43) Pause Full (Ergonomics) 2M->2M(3M) 7.889ms
         * [0.730s][info][gc,cpu         ] GC(43) User=0.00s Sys=0.00s Real=0.01s
         * [0.731s][info][gc,start       ] GC(44) Pause Full (Ergonomics)
         * [0.731s][info][gc,phases,start] GC(44) Marking Phase
         * [0.736s][info][gc,phases      ] GC(44) Marking Phase 5.154ms
         * [0.736s][info][gc,phases,start] GC(44) Summary Phase
         * [0.736s][info][gc,phases      ] GC(44) Summary Phase 0.015ms
         * [0.736s][info][gc,phases,start] GC(44) Adjust Roots
         * [0.737s][info][gc,phases      ] GC(44) Adjust Roots 0.686ms
         * [0.737s][info][gc,phases,start] GC(44) Compaction Phase
         * [0.739s][info][gc,phases      ] GC(44) Compaction Phase 1.885ms
         * [0.739s][info][gc,phases,start] GC(44) Post Compact
         * [0.739s][info][gc,phases      ] GC(44) Post Compact 0.024ms
         * [0.739s][info][gc,heap        ] GC(44) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.739s][info][gc,heap        ] GC(44) ParOldGen: 2305K(2560K)->2305K(2560K)
         * [0.739s][info][gc,metaspace   ] GC(44) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.739s][info][gc             ] GC(44) Pause Full (Ergonomics) 2M->2M(3M) 7.997ms
         * [0.739s][info][gc,cpu         ] GC(44) User=0.03s Sys=0.00s Real=0.01s
         * [0.739s][info][gc,start       ] GC(45) Pause Full (Ergonomics)
         * [0.739s][info][gc,phases,start] GC(45) Marking Phase
         * [0.744s][info][gc,phases      ] GC(45) Marking Phase 4.705ms
         * [0.744s][info][gc,phases,start] GC(45) Summary Phase
         * [0.744s][info][gc,phases      ] GC(45) Summary Phase 0.017ms
         * [0.744s][info][gc,phases,start] GC(45) Adjust Roots
         * [0.745s][info][gc,phases      ] GC(45) Adjust Roots 0.712ms
         * [0.745s][info][gc,phases,start] GC(45) Compaction Phase
         * [0.750s][info][gc,phases      ] GC(45) Compaction Phase 5.617ms
         * [0.750s][info][gc,phases,start] GC(45) Post Compact
         * [0.750s][info][gc,phases      ] GC(45) Post Compact 0.035ms
         * [0.750s][info][gc,heap        ] GC(45) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.750s][info][gc,heap        ] GC(45) ParOldGen: 2307K(2560K)->2307K(2560K)
         * [0.750s][info][gc,metaspace   ] GC(45) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.750s][info][gc             ] GC(45) Pause Full (Ergonomics) 2M->2M(3M) 11.354ms
         * [0.751s][info][gc,cpu         ] GC(45) User=0.00s Sys=0.00s Real=0.01s
         * [0.752s][info][gc,start       ] GC(46) Pause Full (Ergonomics)
         * [0.752s][info][gc,phases,start] GC(46) Marking Phase
         * [0.757s][info][gc,phases      ] GC(46) Marking Phase 4.938ms
         * [0.757s][info][gc,phases,start] GC(46) Summary Phase
         * [0.757s][info][gc,phases      ] GC(46) Summary Phase 0.017ms
         * [0.757s][info][gc,phases,start] GC(46) Adjust Roots
         * [0.758s][info][gc,phases      ] GC(46) Adjust Roots 0.758ms
         * [0.758s][info][gc,phases,start] GC(46) Compaction Phase
         * [0.760s][info][gc,phases      ] GC(46) Compaction Phase 1.969ms
         * [0.760s][info][gc,phases,start] GC(46) Post Compact
         * [0.760s][info][gc,phases      ] GC(46) Post Compact 0.027ms
         * [0.760s][info][gc,heap        ] GC(46) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.760s][info][gc,heap        ] GC(46) ParOldGen: 2308K(2560K)->2308K(2560K)
         * [0.760s][info][gc,metaspace   ] GC(46) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.760s][info][gc             ] GC(46) Pause Full (Ergonomics) 2M->2M(3M) 7.979ms
         * [0.760s][info][gc,cpu         ] GC(46) User=0.03s Sys=0.00s Real=0.01s
         * [0.761s][info][gc,start       ] GC(47) Pause Full (Ergonomics)
         * [0.761s][info][gc,phases,start] GC(47) Marking Phase
         * [0.767s][info][gc,phases      ] GC(47) Marking Phase 5.583ms
         * [0.767s][info][gc,phases,start] GC(47) Summary Phase
         * [0.767s][info][gc,phases      ] GC(47) Summary Phase 0.013ms
         * [0.767s][info][gc,phases,start] GC(47) Adjust Roots
         * [0.767s][info][gc,phases      ] GC(47) Adjust Roots 0.692ms
         * [0.767s][info][gc,phases,start] GC(47) Compaction Phase
         * [0.769s][info][gc,phases      ] GC(47) Compaction Phase 1.935ms
         * [0.769s][info][gc,phases,start] GC(47) Post Compact
         * [0.769s][info][gc,phases      ] GC(47) Post Compact 0.029ms
         * [0.769s][info][gc,heap        ] GC(47) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.769s][info][gc,heap        ] GC(47) ParOldGen: 2310K(2560K)->2310K(2560K)
         * [0.769s][info][gc,metaspace   ] GC(47) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.769s][info][gc             ] GC(47) Pause Full (Ergonomics) 2M->2M(3M) 8.514ms
         * [0.769s][info][gc,cpu         ] GC(47) User=0.03s Sys=0.00s Real=0.01s
         * [0.770s][info][gc,start       ] GC(48) Pause Full (Ergonomics)
         * [0.770s][info][gc,phases,start] GC(48) Marking Phase
         * [0.774s][info][gc,phases      ] GC(48) Marking Phase 4.695ms
         * [0.774s][info][gc,phases,start] GC(48) Summary Phase
         * [0.774s][info][gc,phases      ] GC(48) Summary Phase 0.016ms
         * [0.774s][info][gc,phases,start] GC(48) Adjust Roots
         * [0.775s][info][gc,phases      ] GC(48) Adjust Roots 0.713ms
         * [0.775s][info][gc,phases,start] GC(48) Compaction Phase
         * [0.777s][info][gc,phases      ] GC(48) Compaction Phase 1.897ms
         * [0.777s][info][gc,phases,start] GC(48) Post Compact
         * [0.777s][info][gc,phases      ] GC(48) Post Compact 0.030ms
         * [0.777s][info][gc,heap        ] GC(48) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.777s][info][gc,heap        ] GC(48) ParOldGen: 2311K(2560K)->2311K(2560K)
         * [0.777s][info][gc,metaspace   ] GC(48) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.777s][info][gc             ] GC(48) Pause Full (Ergonomics) 2M->2M(3M) 7.589ms
         * [0.777s][info][gc,cpu         ] GC(48) User=0.00s Sys=0.00s Real=0.01s
         * [0.777s][info][gc,start       ] GC(49) Pause Full (Ergonomics)
         * [0.777s][info][gc,phases,start] GC(49) Marking Phase
         * [0.782s][info][gc,phases      ] GC(49) Marking Phase 4.518ms
         * [0.782s][info][gc,phases,start] GC(49) Summary Phase
         * [0.782s][info][gc,phases      ] GC(49) Summary Phase 0.016ms
         * [0.782s][info][gc,phases,start] GC(49) Adjust Roots
         * [0.783s][info][gc,phases      ] GC(49) Adjust Roots 0.707ms
         * [0.783s][info][gc,phases,start] GC(49) Compaction Phase
         * [0.785s][info][gc,phases      ] GC(49) Compaction Phase 2.033ms
         * [0.785s][info][gc,phases,start] GC(49) Post Compact
         * [0.785s][info][gc,phases      ] GC(49) Post Compact 0.025ms
         * [0.785s][info][gc,heap        ] GC(49) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.785s][info][gc,heap        ] GC(49) ParOldGen: 2313K(2560K)->2313K(2560K)
         * [0.785s][info][gc,metaspace   ] GC(49) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.785s][info][gc             ] GC(49) Pause Full (Ergonomics) 2M->2M(3M) 7.519ms
         * [0.785s][info][gc,cpu         ] GC(49) User=0.02s Sys=0.02s Real=0.01s
         * [0.785s][info][gc,start       ] GC(50) Pause Full (Ergonomics)
         * [0.785s][info][gc,phases,start] GC(50) Marking Phase
         * [0.790s][info][gc,phases      ] GC(50) Marking Phase 4.895ms
         * [0.790s][info][gc,phases,start] GC(50) Summary Phase
         * [0.790s][info][gc,phases      ] GC(50) Summary Phase 0.015ms
         * [0.790s][info][gc,phases,start] GC(50) Adjust Roots
         * [0.791s][info][gc,phases      ] GC(50) Adjust Roots 0.777ms
         * [0.791s][info][gc,phases,start] GC(50) Compaction Phase
         * [0.794s][info][gc,phases      ] GC(50) Compaction Phase 2.957ms
         * [0.794s][info][gc,phases,start] GC(50) Post Compact
         * [0.794s][info][gc,phases      ] GC(50) Post Compact 0.030ms
         * [0.794s][info][gc,heap        ] GC(50) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.794s][info][gc,heap        ] GC(50) ParOldGen: 2314K(2560K)->2314K(2560K)
         * [0.794s][info][gc,metaspace   ] GC(50) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.794s][info][gc             ] GC(50) Pause Full (Ergonomics) 2M->2M(3M) 8.976ms
         * [0.794s][info][gc,cpu         ] GC(50) User=0.00s Sys=0.00s Real=0.01s
         * [0.795s][info][gc,start       ] GC(51) Pause Full (Ergonomics)
         * [0.795s][info][gc,phases,start] GC(51) Marking Phase
         * [0.800s][info][gc,phases      ] GC(51) Marking Phase 5.296ms
         * [0.800s][info][gc,phases,start] GC(51) Summary Phase
         * [0.800s][info][gc,phases      ] GC(51) Summary Phase 0.016ms
         * [0.800s][info][gc,phases,start] GC(51) Adjust Roots
         * [0.801s][info][gc,phases      ] GC(51) Adjust Roots 0.719ms
         * [0.801s][info][gc,phases,start] GC(51) Compaction Phase
         * [0.803s][info][gc,phases      ] GC(51) Compaction Phase 2.014ms
         * [0.803s][info][gc,phases,start] GC(51) Post Compact
         * [0.803s][info][gc,phases      ] GC(51) Post Compact 0.028ms
         * [0.803s][info][gc,heap        ] GC(51) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.803s][info][gc,heap        ] GC(51) ParOldGen: 2316K(2560K)->2316K(2560K)
         * [0.803s][info][gc,metaspace   ] GC(51) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.803s][info][gc             ] GC(51) Pause Full (Ergonomics) 2M->2M(3M) 8.317ms
         * [0.803s][info][gc,cpu         ] GC(51) User=0.03s Sys=0.00s Real=0.01s
         * [0.804s][info][gc,start       ] GC(52) Pause Full (Ergonomics)
         * [0.804s][info][gc,phases,start] GC(52) Marking Phase
         * [0.809s][info][gc,phases      ] GC(52) Marking Phase 5.016ms
         * [0.809s][info][gc,phases,start] GC(52) Summary Phase
         * [0.809s][info][gc,phases      ] GC(52) Summary Phase 0.015ms
         * [0.809s][info][gc,phases,start] GC(52) Adjust Roots
         * [0.809s][info][gc,phases      ] GC(52) Adjust Roots 0.686ms
         * [0.809s][info][gc,phases,start] GC(52) Compaction Phase
         * [0.811s][info][gc,phases      ] GC(52) Compaction Phase 2.050ms
         * [0.811s][info][gc,phases,start] GC(52) Post Compact
         * [0.812s][info][gc,phases      ] GC(52) Post Compact 0.025ms
         * [0.812s][info][gc,heap        ] GC(52) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.812s][info][gc,heap        ] GC(52) ParOldGen: 2317K(2560K)->2317K(2560K)
         * [0.812s][info][gc,metaspace   ] GC(52) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.812s][info][gc             ] GC(52) Pause Full (Ergonomics) 2M->2M(3M) 8.019ms
         * [0.812s][info][gc,cpu         ] GC(52) User=0.00s Sys=0.00s Real=0.01s
         * [0.812s][info][gc,start       ] GC(53) Pause Full (Ergonomics)
         * [0.812s][info][gc,phases,start] GC(53) Marking Phase
         * [0.817s][info][gc,phases      ] GC(53) Marking Phase 4.729ms
         * [0.817s][info][gc,phases,start] GC(53) Summary Phase
         * [0.817s][info][gc,phases      ] GC(53) Summary Phase 0.017ms
         * [0.817s][info][gc,phases,start] GC(53) Adjust Roots
         * [0.817s][info][gc,phases      ] GC(53) Adjust Roots 0.660ms
         * [0.817s][info][gc,phases,start] GC(53) Compaction Phase
         * [0.819s][info][gc,phases      ] GC(53) Compaction Phase 2.011ms
         * [0.819s][info][gc,phases,start] GC(53) Post Compact
         * [0.819s][info][gc,phases      ] GC(53) Post Compact 0.031ms
         * [0.820s][info][gc,heap        ] GC(53) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.820s][info][gc,heap        ] GC(53) ParOldGen: 2319K(2560K)->2319K(2560K)
         * [0.820s][info][gc,metaspace   ] GC(53) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.820s][info][gc             ] GC(53) Pause Full (Ergonomics) 2M->2M(3M) 7.691ms
         * [0.820s][info][gc,cpu         ] GC(53) User=0.03s Sys=0.00s Real=0.01s
         * [0.820s][info][gc,start       ] GC(54) Pause Full (Ergonomics)
         * [0.820s][info][gc,phases,start] GC(54) Marking Phase
         * [0.824s][info][gc,phases      ] GC(54) Marking Phase 4.242ms
         * [0.824s][info][gc,phases,start] GC(54) Summary Phase
         * [0.824s][info][gc,phases      ] GC(54) Summary Phase 0.015ms
         * [0.824s][info][gc,phases,start] GC(54) Adjust Roots
         * [0.825s][info][gc,phases      ] GC(54) Adjust Roots 0.745ms
         * [0.825s][info][gc,phases,start] GC(54) Compaction Phase
         * [0.827s][info][gc,phases      ] GC(54) Compaction Phase 2.068ms
         * [0.827s][info][gc,phases,start] GC(54) Post Compact
         * [0.827s][info][gc,phases      ] GC(54) Post Compact 0.029ms
         * [0.827s][info][gc,heap        ] GC(54) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.827s][info][gc,heap        ] GC(54) ParOldGen: 2320K(2560K)->2320K(2560K)
         * [0.827s][info][gc,metaspace   ] GC(54) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.827s][info][gc             ] GC(54) Pause Full (Ergonomics) 2M->2M(3M) 7.339ms
         * [0.827s][info][gc,cpu         ] GC(54) User=0.00s Sys=0.00s Real=0.01s
         * [0.827s][info][gc,start       ] GC(55) Pause Full (Ergonomics)
         * [0.827s][info][gc,phases,start] GC(55) Marking Phase
         * [0.832s][info][gc,phases      ] GC(55) Marking Phase 4.633ms
         * [0.832s][info][gc,phases,start] GC(55) Summary Phase
         * [0.832s][info][gc,phases      ] GC(55) Summary Phase 0.017ms
         * [0.832s][info][gc,phases,start] GC(55) Adjust Roots
         * [0.833s][info][gc,phases      ] GC(55) Adjust Roots 0.463ms
         * [0.833s][info][gc,phases,start] GC(55) Compaction Phase
         * [0.834s][info][gc,phases      ] GC(55) Compaction Phase 1.701ms
         * [0.834s][info][gc,phases,start] GC(55) Post Compact
         * [0.834s][info][gc,phases      ] GC(55) Post Compact 0.017ms
         * [0.834s][info][gc,heap        ] GC(55) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.834s][info][gc,heap        ] GC(55) ParOldGen: 2322K(2560K)->2322K(2560K)
         * [0.834s][info][gc,metaspace   ] GC(55) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.834s][info][gc             ] GC(55) Pause Full (Ergonomics) 2M->2M(3M) 6.991ms
         * [0.834s][info][gc,cpu         ] GC(55) User=0.03s Sys=0.00s Real=0.01s
         * [0.835s][info][gc,start       ] GC(56) Pause Full (Ergonomics)
         * [0.835s][info][gc,phases,start] GC(56) Marking Phase
         * [0.840s][info][gc,phases      ] GC(56) Marking Phase 4.910ms
         * [0.840s][info][gc,phases,start] GC(56) Summary Phase
         * [0.840s][info][gc,phases      ] GC(56) Summary Phase 0.018ms
         * [0.840s][info][gc,phases,start] GC(56) Adjust Roots
         * [0.840s][info][gc,phases      ] GC(56) Adjust Roots 0.766ms
         * [0.840s][info][gc,phases,start] GC(56) Compaction Phase
         * [0.843s][info][gc,phases      ] GC(56) Compaction Phase 2.215ms
         * [0.843s][info][gc,phases,start] GC(56) Post Compact
         * [0.843s][info][gc,phases      ] GC(56) Post Compact 0.027ms
         * [0.843s][info][gc,heap        ] GC(56) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.843s][info][gc,heap        ] GC(56) ParOldGen: 2323K(2560K)->2323K(2560K)
         * [0.843s][info][gc,metaspace   ] GC(56) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.843s][info][gc             ] GC(56) Pause Full (Ergonomics) 2M->2M(3M) 8.177ms
         * [0.843s][info][gc,cpu         ] GC(56) User=0.00s Sys=0.00s Real=0.01s
         * [0.843s][info][gc,start       ] GC(57) Pause Full (Ergonomics)
         * [0.843s][info][gc,phases,start] GC(57) Marking Phase
         * [0.849s][info][gc,phases      ] GC(57) Marking Phase 5.449ms
         * [0.849s][info][gc,phases,start] GC(57) Summary Phase
         * [0.849s][info][gc,phases      ] GC(57) Summary Phase 0.017ms
         * [0.849s][info][gc,phases,start] GC(57) Adjust Roots
         * [0.849s][info][gc,phases      ] GC(57) Adjust Roots 0.701ms
         * [0.849s][info][gc,phases,start] GC(57) Compaction Phase
         * [0.851s][info][gc,phases      ] GC(57) Compaction Phase 2.036ms
         * [0.851s][info][gc,phases,start] GC(57) Post Compact
         * [0.851s][info][gc,phases      ] GC(57) Post Compact 0.026ms
         * [0.851s][info][gc,heap        ] GC(57) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.851s][info][gc,heap        ] GC(57) ParOldGen: 2325K(2560K)->2325K(2560K)
         * [0.851s][info][gc,metaspace   ] GC(57) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.852s][info][gc             ] GC(57) Pause Full (Ergonomics) 2M->2M(3M) 8.450ms
         * [0.852s][info][gc,cpu         ] GC(57) User=0.03s Sys=0.00s Real=0.01s
         * [0.852s][info][gc,start       ] GC(58) Pause Full (Ergonomics)
         * [0.852s][info][gc,phases,start] GC(58) Marking Phase
         * [0.857s][info][gc,phases      ] GC(58) Marking Phase 4.814ms
         * [0.857s][info][gc,phases,start] GC(58) Summary Phase
         * [0.857s][info][gc,phases      ] GC(58) Summary Phase 0.014ms
         * [0.857s][info][gc,phases,start] GC(58) Adjust Roots
         * [0.857s][info][gc,phases      ] GC(58) Adjust Roots 0.673ms
         * [0.857s][info][gc,phases,start] GC(58) Compaction Phase
         * [0.860s][info][gc,phases      ] GC(58) Compaction Phase 2.264ms
         * [0.860s][info][gc,phases,start] GC(58) Post Compact
         * [0.860s][info][gc,phases      ] GC(58) Post Compact 0.024ms
         * [0.860s][info][gc,heap        ] GC(58) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.860s][info][gc,heap        ] GC(58) ParOldGen: 2326K(2560K)->2326K(2560K)
         * [0.860s][info][gc,metaspace   ] GC(58) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.860s][info][gc             ] GC(58) Pause Full (Ergonomics) 2M->2M(3M) 8.012ms
         * [0.860s][info][gc,cpu         ] GC(58) User=0.00s Sys=0.00s Real=0.01s
         * [0.860s][info][gc,start       ] GC(59) Pause Full (Ergonomics)
         * [0.860s][info][gc,phases,start] GC(59) Marking Phase
         * [0.864s][info][gc,phases      ] GC(59) Marking Phase 4.381ms
         * [0.864s][info][gc,phases,start] GC(59) Summary Phase
         * [0.865s][info][gc,phases      ] GC(59) Summary Phase 0.016ms
         * [0.865s][info][gc,phases,start] GC(59) Adjust Roots
         * [0.865s][info][gc,phases      ] GC(59) Adjust Roots 0.767ms
         * [0.865s][info][gc,phases,start] GC(59) Compaction Phase
         * [0.867s][info][gc,phases      ] GC(59) Compaction Phase 1.920ms
         * [0.867s][info][gc,phases,start] GC(59) Post Compact
         * [0.867s][info][gc,phases      ] GC(59) Post Compact 0.036ms
         * [0.867s][info][gc,heap        ] GC(59) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.867s][info][gc,heap        ] GC(59) ParOldGen: 2328K(2560K)->2328K(2560K)
         * [0.867s][info][gc,metaspace   ] GC(59) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.867s][info][gc             ] GC(59) Pause Full (Ergonomics) 2M->2M(3M) 7.432ms
         * [0.867s][info][gc,cpu         ] GC(59) User=0.03s Sys=0.00s Real=0.01s
         * [0.868s][info][gc,start       ] GC(60) Pause Full (Ergonomics)
         * [0.868s][info][gc,phases,start] GC(60) Marking Phase
         * [0.873s][info][gc,phases      ] GC(60) Marking Phase 5.421ms
         * [0.873s][info][gc,phases,start] GC(60) Summary Phase
         * [0.873s][info][gc,phases      ] GC(60) Summary Phase 0.016ms
         * [0.873s][info][gc,phases,start] GC(60) Adjust Roots
         * [0.874s][info][gc,phases      ] GC(60) Adjust Roots 0.747ms
         * [0.874s][info][gc,phases,start] GC(60) Compaction Phase
         * [0.876s][info][gc,phases      ] GC(60) Compaction Phase 1.955ms
         * [0.876s][info][gc,phases,start] GC(60) Post Compact
         * [0.876s][info][gc,phases      ] GC(60) Post Compact 0.026ms
         * [0.876s][info][gc,heap        ] GC(60) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.876s][info][gc,heap        ] GC(60) ParOldGen: 2329K(2560K)->2329K(2560K)
         * [0.876s][info][gc,metaspace   ] GC(60) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.876s][info][gc             ] GC(60) Pause Full (Ergonomics) 2M->2M(3M) 8.388ms
         * [0.876s][info][gc,cpu         ] GC(60) User=0.00s Sys=0.00s Real=0.01s
         * [0.876s][info][gc,start       ] GC(61) Pause Full (Ergonomics)
         * [0.876s][info][gc,phases,start] GC(61) Marking Phase
         * [0.882s][info][gc,phases      ] GC(61) Marking Phase 5.378ms
         * [0.882s][info][gc,phases,start] GC(61) Summary Phase
         * [0.882s][info][gc,phases      ] GC(61) Summary Phase 0.016ms
         * [0.882s][info][gc,phases,start] GC(61) Adjust Roots
         * [0.883s][info][gc,phases      ] GC(61) Adjust Roots 0.712ms
         * [0.883s][info][gc,phases,start] GC(61) Compaction Phase
         * [0.884s][info][gc,phases      ] GC(61) Compaction Phase 1.723ms
         * [0.884s][info][gc,phases,start] GC(61) Post Compact
         * [0.884s][info][gc,phases      ] GC(61) Post Compact 0.028ms
         * [0.884s][info][gc,heap        ] GC(61) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.884s][info][gc,heap        ] GC(61) ParOldGen: 2331K(2560K)->2331K(2560K)
         * [0.884s][info][gc,metaspace   ] GC(61) Metaspace: 944K(4864K)->944K(4864K) NonClass: 852K(4352K)->852K(4352K) Class: 92K(512K)->92K(512K)
         * [0.884s][info][gc             ] GC(61) Pause Full (Ergonomics) 2M->2M(3M) 8.092ms
         * [0.884s][info][gc,cpu         ] GC(61) User=0.03s Sys=0.00s Real=0.01s
         * [0.885s][info][gc,start       ] GC(62) Pause Full (Ergonomics)
         * [0.885s][info][gc,phases,start] GC(62) Marking Phase
         * [0.889s][info][gc,phases      ] GC(62) Marking Phase 4.472ms
         * [0.889s][info][gc,phases,start] GC(62) Summary Phase
         * [0.889s][info][gc,phases      ] GC(62) Summary Phase 0.012ms
         * [0.889s][info][gc,phases,start] GC(62) Adjust Roots
         * [0.890s][info][gc,phases      ] GC(62) Adjust Roots 0.461ms
         * [0.890s][info][gc,phases,start] GC(62) Compaction Phase
         * [0.892s][info][gc,phases      ] GC(62) Compaction Phase 2.064ms
         * [0.892s][info][gc,phases,start] GC(62) Post Compact
         * [0.892s][info][gc,phases      ] GC(62) Post Compact 0.028ms
         * [0.892s][info][gc,heap        ] GC(62) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.892s][info][gc,heap        ] GC(62) ParOldGen: 2332K(2560K)->2332K(2560K)
         * [0.892s][info][gc,metaspace   ] GC(62) Metaspace: 948K(4864K)->948K(4864K) NonClass: 855K(4352K)->855K(4352K) Class: 92K(512K)->92K(512K)
         * [0.892s][info][gc             ] GC(62) Pause Full (Ergonomics) 2M->2M(3M) 7.234ms
         * [0.892s][info][gc,cpu         ] GC(62) User=0.00s Sys=0.00s Real=0.01s
         * [0.892s][info][gc,start       ] GC(63) Pause Full (Ergonomics)
         * [0.892s][info][gc,phases,start] GC(63) Marking Phase
         * [0.897s][info][gc,phases      ] GC(63) Marking Phase 4.745ms
         * [0.897s][info][gc,phases,start] GC(63) Summary Phase
         * [0.897s][info][gc,phases      ] GC(63) Summary Phase 0.016ms
         * [0.897s][info][gc,phases,start] GC(63) Adjust Roots
         * [0.898s][info][gc,phases      ] GC(63) Adjust Roots 0.727ms
         * [0.898s][info][gc,phases,start] GC(63) Compaction Phase
         * [0.900s][info][gc,phases      ] GC(63) Compaction Phase 2.024ms
         * [0.900s][info][gc,phases,start] GC(63) Post Compact
         * [0.900s][info][gc,phases      ] GC(63) Post Compact 0.028ms
         * [0.900s][info][gc,heap        ] GC(63) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.900s][info][gc,heap        ] GC(63) ParOldGen: 2334K(2560K)->2334K(2560K)
         * [0.900s][info][gc,metaspace   ] GC(63) Metaspace: 949K(4864K)->949K(4864K) NonClass: 856K(4352K)->856K(4352K) Class: 92K(512K)->92K(512K)
         * [0.900s][info][gc             ] GC(63) Pause Full (Ergonomics) 2M->2M(3M) 7.785ms
         * [0.900s][info][gc,cpu         ] GC(63) User=0.03s Sys=0.00s Real=0.01s
         * [0.900s][info][gc,start       ] GC(64) Pause Full (Ergonomics)
         * [0.900s][info][gc,phases,start] GC(64) Marking Phase
         * [0.905s][info][gc,phases      ] GC(64) Marking Phase 4.619ms
         * [0.905s][info][gc,phases,start] GC(64) Summary Phase
         * [0.905s][info][gc,phases      ] GC(64) Summary Phase 0.016ms
         * [0.905s][info][gc,phases,start] GC(64) Adjust Roots
         * [0.906s][info][gc,phases      ] GC(64) Adjust Roots 0.714ms
         * [0.906s][info][gc,phases,start] GC(64) Compaction Phase
         * [0.908s][info][gc,phases      ] GC(64) Compaction Phase 1.978ms
         * [0.908s][info][gc,phases,start] GC(64) Post Compact
         * [0.908s][info][gc,phases      ] GC(64) Post Compact 0.025ms
         * [0.908s][info][gc,heap        ] GC(64) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.908s][info][gc,heap        ] GC(64) ParOldGen: 2335K(2560K)->2335K(2560K)
         * [0.908s][info][gc,metaspace   ] GC(64) Metaspace: 949K(4864K)->949K(4864K) NonClass: 856K(4352K)->856K(4352K) Class: 92K(512K)->92K(512K)
         * [0.908s][info][gc             ] GC(64) Pause Full (Ergonomics) 2M->2M(3M) 7.590ms
         * [0.908s][info][gc,cpu         ] GC(64) User=0.00s Sys=0.00s Real=0.01s
         * [0.908s][info][gc,start       ] GC(65) Pause Full (Ergonomics)
         * [0.908s][info][gc,phases,start] GC(65) Marking Phase
         * [0.913s][info][gc,phases      ] GC(65) Marking Phase 4.394ms
         * [0.913s][info][gc,phases,start] GC(65) Summary Phase
         * [0.913s][info][gc,phases      ] GC(65) Summary Phase 0.017ms
         * [0.913s][info][gc,phases,start] GC(65) Adjust Roots
         * [0.914s][info][gc,phases      ] GC(65) Adjust Roots 0.760ms
         * [0.914s][info][gc,phases,start] GC(65) Compaction Phase
         * [0.916s][info][gc,phases      ] GC(65) Compaction Phase 2.640ms
         * [0.916s][info][gc,phases,start] GC(65) Post Compact
         * [0.916s][info][gc,phases      ] GC(65) Post Compact 0.036ms
         * [0.916s][info][gc,heap        ] GC(65) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.916s][info][gc,heap        ] GC(65) ParOldGen: 2337K(2560K)->2337K(2560K)
         * [0.916s][info][gc,metaspace   ] GC(65) Metaspace: 949K(4864K)->949K(4864K) NonClass: 856K(4352K)->856K(4352K) Class: 92K(512K)->92K(512K)
         * [0.916s][info][gc             ] GC(65) Pause Full (Ergonomics) 2M->2M(3M) 8.147ms
         * [0.916s][info][gc,cpu         ] GC(65) User=0.03s Sys=0.00s Real=0.01s
         * [0.917s][info][gc,start       ] GC(66) Pause Full (Ergonomics)
         * [0.917s][info][gc,phases,start] GC(66) Marking Phase
         * [0.922s][info][gc,phases      ] GC(66) Marking Phase 4.926ms
         * [0.922s][info][gc,phases,start] GC(66) Summary Phase
         * [0.922s][info][gc,phases      ] GC(66) Summary Phase 0.018ms
         * [0.922s][info][gc,phases,start] GC(66) Adjust Roots
         * [0.923s][info][gc,phases      ] GC(66) Adjust Roots 0.736ms
         * [0.923s][info][gc,phases,start] GC(66) Compaction Phase
         * [0.924s][info][gc,phases      ] GC(66) Compaction Phase 1.731ms
         * [0.924s][info][gc,phases,start] GC(66) Post Compact
         * [0.924s][info][gc,phases      ] GC(66) Post Compact 0.018ms
         * [0.924s][info][gc,heap        ] GC(66) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.924s][info][gc,heap        ] GC(66) ParOldGen: 2338K(2560K)->2338K(2560K)
         * [0.924s][info][gc,metaspace   ] GC(66) Metaspace: 949K(4864K)->949K(4864K) NonClass: 856K(4352K)->856K(4352K) Class: 92K(512K)->92K(512K)
         * [0.924s][info][gc             ] GC(66) Pause Full (Ergonomics) 2M->2M(3M) 7.645ms
         * [0.924s][info][gc,cpu         ] GC(66) User=0.02s Sys=0.00s Real=0.01s
         * [0.925s][info][gc,start       ] GC(67) Pause Full (Ergonomics)
         * [0.925s][info][gc,phases,start] GC(67) Marking Phase
         * [0.929s][info][gc,phases      ] GC(67) Marking Phase 4.429ms
         * [0.929s][info][gc,phases,start] GC(67) Summary Phase
         * [0.929s][info][gc,phases      ] GC(67) Summary Phase 0.016ms
         * [0.929s][info][gc,phases,start] GC(67) Adjust Roots
         * [0.930s][info][gc,phases      ] GC(67) Adjust Roots 0.792ms
         * [0.930s][info][gc,phases,start] GC(67) Compaction Phase
         * [0.932s][info][gc,phases      ] GC(67) Compaction Phase 1.976ms
         * [0.932s][info][gc,phases,start] GC(67) Post Compact
         * [0.932s][info][gc,phases      ] GC(67) Post Compact 0.025ms
         * [0.932s][info][gc,heap        ] GC(67) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.932s][info][gc,heap        ] GC(67) ParOldGen: 2340K(2560K)->2340K(2560K)
         * [0.932s][info][gc,metaspace   ] GC(67) Metaspace: 949K(4864K)->949K(4864K) NonClass: 856K(4352K)->856K(4352K) Class: 92K(512K)->92K(512K)
         * [0.932s][info][gc             ] GC(67) Pause Full (Ergonomics) 2M->2M(3M) 7.483ms
         * [0.932s][info][gc,cpu         ] GC(67) User=0.00s Sys=0.00s Real=0.01s
         * [0.932s][info][gc,start       ] GC(68) Pause Full (Ergonomics)
         * [0.932s][info][gc,phases,start] GC(68) Marking Phase
         * [0.937s][info][gc,phases      ] GC(68) Marking Phase 4.821ms
         * [0.937s][info][gc,phases,start] GC(68) Summary Phase
         * [0.937s][info][gc,phases      ] GC(68) Summary Phase 0.015ms
         * [0.937s][info][gc,phases,start] GC(68) Adjust Roots
         * [0.938s][info][gc,phases      ] GC(68) Adjust Roots 0.692ms
         * [0.938s][info][gc,phases,start] GC(68) Compaction Phase
         * [0.940s][info][gc,phases      ] GC(68) Compaction Phase 2.135ms
         * [0.940s][info][gc,phases,start] GC(68) Post Compact
         * [0.940s][info][gc,phases      ] GC(68) Post Compact 0.025ms
         * [0.940s][info][gc,heap        ] GC(68) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.940s][info][gc,heap        ] GC(68) ParOldGen: 2341K(2560K)->2341K(2560K)
         * [0.940s][info][gc,metaspace   ] GC(68) Metaspace: 949K(4864K)->949K(4864K) NonClass: 856K(4352K)->856K(4352K) Class: 92K(512K)->92K(512K)
         * [0.940s][info][gc             ] GC(68) Pause Full (Ergonomics) 2M->2M(3M) 7.897ms
         * [0.940s][info][gc,cpu         ] GC(68) User=0.00s Sys=0.00s Real=0.01s
         * [0.941s][info][gc,start       ] GC(69) Pause Full (Ergonomics)
         * [0.941s][info][gc,phases,start] GC(69) Marking Phase
         * [0.945s][info][gc,phases      ] GC(69) Marking Phase 4.142ms
         * [0.945s][info][gc,phases,start] GC(69) Summary Phase
         * [0.945s][info][gc,phases      ] GC(69) Summary Phase 0.017ms
         * [0.945s][info][gc,phases,start] GC(69) Adjust Roots
         * [0.946s][info][gc,phases      ] GC(69) Adjust Roots 0.674ms
         * [0.946s][info][gc,phases,start] GC(69) Compaction Phase
         * [0.947s][info][gc,phases      ] GC(69) Compaction Phase 1.761ms
         * [0.947s][info][gc,phases,start] GC(69) Post Compact
         * [0.947s][info][gc,phases      ] GC(69) Post Compact 0.024ms
         * [0.948s][info][gc,heap        ] GC(69) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.948s][info][gc,heap        ] GC(69) ParOldGen: 2343K(2560K)->2343K(2560K)
         * [0.948s][info][gc,metaspace   ] GC(69) Metaspace: 954K(4864K)->954K(4864K) NonClass: 860K(4352K)->860K(4352K) Class: 93K(512K)->93K(512K)
         * [0.948s][info][gc             ] GC(69) Pause Full (Ergonomics) 2M->2M(3M) 6.840ms
         * [0.948s][info][gc,cpu         ] GC(69) User=0.00s Sys=0.00s Real=0.01s
         * [0.948s][info][gc,start       ] GC(70) Pause Full (Ergonomics)
         * [0.948s][info][gc,phases,start] GC(70) Marking Phase
         * [0.954s][info][gc,phases      ] GC(70) Marking Phase 5.923ms
         * [0.954s][info][gc,phases,start] GC(70) Summary Phase
         * [0.954s][info][gc,phases      ] GC(70) Summary Phase 0.018ms
         * [0.954s][info][gc,phases,start] GC(70) Adjust Roots
         * [0.955s][info][gc,phases      ] GC(70) Adjust Roots 0.746ms
         * [0.955s][info][gc,phases,start] GC(70) Compaction Phase
         * [0.957s][info][gc,phases      ] GC(70) Compaction Phase 2.052ms
         * [0.957s][info][gc,phases,start] GC(70) Post Compact
         * [0.957s][info][gc,phases      ] GC(70) Post Compact 0.029ms
         * [0.957s][info][gc,heap        ] GC(70) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.957s][info][gc,heap        ] GC(70) ParOldGen: 2345K(2560K)->2345K(2560K)
         * [0.957s][info][gc,metaspace   ] GC(70) Metaspace: 955K(4864K)->955K(4864K) NonClass: 861K(4352K)->861K(4352K) Class: 93K(512K)->93K(512K)
         * [0.957s][info][gc             ] GC(70) Pause Full (Ergonomics) 2M->2M(3M) 9.046ms
         * [0.957s][info][gc,cpu         ] GC(70) User=0.03s Sys=0.00s Real=0.01s
         * [0.957s][info][gc,start       ] GC(71) Pause Full (Ergonomics)
         * [0.957s][info][gc,phases,start] GC(71) Marking Phase
         * [0.961s][info][gc,phases      ] GC(71) Marking Phase 3.903ms
         * [0.961s][info][gc,phases,start] GC(71) Summary Phase
         * [0.961s][info][gc,phases      ] GC(71) Summary Phase 0.022ms
         * [0.961s][info][gc,phases,start] GC(71) Adjust Roots
         * [0.962s][info][gc,phases      ] GC(71) Adjust Roots 0.775ms
         * [0.962s][info][gc,phases,start] GC(71) Compaction Phase
         * [0.964s][info][gc,phases      ] GC(71) Compaction Phase 2.159ms
         * [0.964s][info][gc,phases,start] GC(71) Post Compact
         * [0.964s][info][gc,phases      ] GC(71) Post Compact 0.026ms
         * [0.964s][info][gc,heap        ] GC(71) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.964s][info][gc,heap        ] GC(71) ParOldGen: 2350K(2560K)->2350K(2560K)
         * [0.964s][info][gc,metaspace   ] GC(71) Metaspace: 955K(4864K)->955K(4864K) NonClass: 861K(4352K)->861K(4352K) Class: 93K(512K)->93K(512K)
         * [0.964s][info][gc             ] GC(71) Pause Full (Ergonomics) 2M->2M(3M) 7.123ms
         * [0.965s][info][gc,cpu         ] GC(71) User=0.00s Sys=0.00s Real=0.01s
         * [0.966s][info][gc,start       ] GC(72) Pause Full (Ergonomics)
         * [0.966s][info][gc,phases,start] GC(72) Marking Phase
         * [0.972s][info][gc,phases      ] GC(72) Marking Phase 5.246ms
         * [0.972s][info][gc,phases,start] GC(72) Summary Phase
         * [0.972s][info][gc,phases      ] GC(72) Summary Phase 0.015ms
         * [0.972s][info][gc,phases,start] GC(72) Adjust Roots
         * [0.973s][info][gc,phases      ] GC(72) Adjust Roots 0.844ms
         * [0.973s][info][gc,phases,start] GC(72) Compaction Phase
         * [0.975s][info][gc,phases      ] GC(72) Compaction Phase 2.068ms
         * [0.975s][info][gc,phases,start] GC(72) Post Compact
         * [0.975s][info][gc,phases      ] GC(72) Post Compact 0.028ms
         * [0.975s][info][gc,heap        ] GC(72) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.975s][info][gc,heap        ] GC(72) ParOldGen: 2352K(2560K)->2352K(2560K)
         * [0.975s][info][gc,metaspace   ] GC(72) Metaspace: 955K(4864K)->955K(4864K) NonClass: 861K(4352K)->861K(4352K) Class: 93K(512K)->93K(512K)
         * [0.975s][info][gc             ] GC(72) Pause Full (Ergonomics) 2M->2M(3M) 8.511ms
         * [0.975s][info][gc,cpu         ] GC(72) User=0.02s Sys=0.00s Real=0.01s
         * [0.975s][info][gc,start       ] GC(73) Pause Full (Ergonomics)
         * [0.975s][info][gc,phases,start] GC(73) Marking Phase
         * [0.980s][info][gc,phases      ] GC(73) Marking Phase 5.244ms
         * [0.980s][info][gc,phases,start] GC(73) Summary Phase
         * [0.980s][info][gc,phases      ] GC(73) Summary Phase 0.016ms
         * [0.980s][info][gc,phases,start] GC(73) Adjust Roots
         * [0.981s][info][gc,phases      ] GC(73) Adjust Roots 0.784ms
         * [0.981s][info][gc,phases,start] GC(73) Compaction Phase
         * [0.984s][info][gc,phases      ] GC(73) Compaction Phase 2.271ms
         * [0.984s][info][gc,phases,start] GC(73) Post Compact
         * [0.984s][info][gc,phases      ] GC(73) Post Compact 0.031ms
         * [0.984s][info][gc,heap        ] GC(73) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.984s][info][gc,heap        ] GC(73) ParOldGen: 2353K(2560K)->2353K(2560K)
         * [0.984s][info][gc,metaspace   ] GC(73) Metaspace: 955K(4864K)->955K(4864K) NonClass: 862K(4352K)->862K(4352K) Class: 93K(512K)->93K(512K)
         * [0.984s][info][gc             ] GC(73) Pause Full (Ergonomics) 2M->2M(3M) 8.621ms
         * [0.984s][info][gc,cpu         ] GC(73) User=0.00s Sys=0.00s Real=0.01s
         * [0.984s][info][gc,start       ] GC(74) Pause Full (Ergonomics)
         * [0.984s][info][gc,phases,start] GC(74) Marking Phase
         * [0.989s][info][gc,phases      ] GC(74) Marking Phase 4.442ms
         * [0.989s][info][gc,phases,start] GC(74) Summary Phase
         * [0.989s][info][gc,phases      ] GC(74) Summary Phase 0.015ms
         * [0.989s][info][gc,phases,start] GC(74) Adjust Roots
         * [0.989s][info][gc,phases      ] GC(74) Adjust Roots 0.653ms
         * [0.989s][info][gc,phases,start] GC(74) Compaction Phase
         * [0.992s][info][gc,phases      ] GC(74) Compaction Phase 2.225ms
         * [0.992s][info][gc,phases,start] GC(74) Post Compact
         * [0.992s][info][gc,phases      ] GC(74) Post Compact 0.030ms
         * [0.992s][info][gc,heap        ] GC(74) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [0.992s][info][gc,heap        ] GC(74) ParOldGen: 2355K(2560K)->2355K(2560K)
         * [0.992s][info][gc,metaspace   ] GC(74) Metaspace: 956K(4864K)->956K(4864K) NonClass: 862K(4352K)->862K(4352K) Class: 93K(512K)->93K(512K)
         * [0.992s][info][gc             ] GC(74) Pause Full (Ergonomics) 2M->2M(3M) 7.618ms
         * [0.992s][info][gc,cpu         ] GC(74) User=0.03s Sys=0.00s Real=0.01s
         * [0.992s][info][gc,start       ] GC(75) Pause Full (Ergonomics)
         * [0.992s][info][gc,phases,start] GC(75) Marking Phase
         * [0.997s][info][gc,phases      ] GC(75) Marking Phase 4.507ms
         * [0.997s][info][gc,phases,start] GC(75) Summary Phase
         * [0.997s][info][gc,phases      ] GC(75) Summary Phase 0.015ms
         * [0.997s][info][gc,phases,start] GC(75) Adjust Roots
         * [0.997s][info][gc,phases      ] GC(75) Adjust Roots 0.753ms
         * [0.997s][info][gc,phases,start] GC(75) Compaction Phase
         * [1.000s][info][gc,phases      ] GC(75) Compaction Phase 2.032ms
         * [1.000s][info][gc,phases,start] GC(75) Post Compact
         * [1.000s][info][gc,phases      ] GC(75) Post Compact 0.025ms
         * [1.000s][info][gc,heap        ] GC(75) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.000s][info][gc,heap        ] GC(75) ParOldGen: 2357K(2560K)->2357K(2560K)
         * [1.000s][info][gc,metaspace   ] GC(75) Metaspace: 956K(4864K)->956K(4864K) NonClass: 863K(4352K)->863K(4352K) Class: 93K(512K)->93K(512K)
         * [1.000s][info][gc             ] GC(75) Pause Full (Ergonomics) 2M->2M(3M) 7.563ms
         * [1.000s][info][gc,cpu         ] GC(75) User=0.00s Sys=0.00s Real=0.01s
         * [1.000s][info][gc,start       ] GC(76) Pause Full (Ergonomics)
         * [1.000s][info][gc,phases,start] GC(76) Marking Phase
         * [1.005s][info][gc,phases      ] GC(76) Marking Phase 4.639ms
         * [1.005s][info][gc,phases,start] GC(76) Summary Phase
         * [1.005s][info][gc,phases      ] GC(76) Summary Phase 0.009ms
         * [1.005s][info][gc,phases,start] GC(76) Adjust Roots
         * [1.005s][info][gc,phases      ] GC(76) Adjust Roots 0.487ms
         * [1.005s][info][gc,phases,start] GC(76) Compaction Phase
         * [1.007s][info][gc,phases      ] GC(76) Compaction Phase 1.401ms
         * [1.007s][info][gc,phases,start] GC(76) Post Compact
         * [1.007s][info][gc,phases      ] GC(76) Post Compact 0.017ms
         * [1.007s][info][gc,heap        ] GC(76) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.007s][info][gc,heap        ] GC(76) ParOldGen: 2358K(2560K)->2358K(2560K)
         * [1.007s][info][gc,metaspace   ] GC(76) Metaspace: 956K(4864K)->956K(4864K) NonClass: 863K(4352K)->863K(4352K) Class: 93K(512K)->93K(512K)
         * [1.007s][info][gc             ] GC(76) Pause Full (Ergonomics) 2M->2M(3M) 6.707ms
         * [1.007s][info][gc,cpu         ] GC(76) User=0.03s Sys=0.00s Real=0.01s
         * [1.007s][info][gc,start       ] GC(77) Pause Full (Ergonomics)
         * [1.007s][info][gc,phases,start] GC(77) Marking Phase
         * [1.011s][info][gc,phases      ] GC(77) Marking Phase 4.143ms
         * [1.011s][info][gc,phases,start] GC(77) Summary Phase
         * [1.011s][info][gc,phases      ] GC(77) Summary Phase 0.016ms
         * [1.011s][info][gc,phases,start] GC(77) Adjust Roots
         * [1.012s][info][gc,phases      ] GC(77) Adjust Roots 0.846ms
         * [1.012s][info][gc,phases,start] GC(77) Compaction Phase
         * [1.014s][info][gc,phases      ] GC(77) Compaction Phase 2.164ms
         * [1.014s][info][gc,phases,start] GC(77) Post Compact
         * [1.014s][info][gc,phases      ] GC(77) Post Compact 0.024ms
         * [1.014s][info][gc,heap        ] GC(77) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.014s][info][gc,heap        ] GC(77) ParOldGen: 2360K(2560K)->2360K(2560K)
         * [1.014s][info][gc,metaspace   ] GC(77) Metaspace: 956K(4864K)->956K(4864K) NonClass: 863K(4352K)->863K(4352K) Class: 93K(512K)->93K(512K)
         * [1.014s][info][gc             ] GC(77) Pause Full (Ergonomics) 2M->2M(3M) 7.425ms
         * [1.014s][info][gc,cpu         ] GC(77) User=0.00s Sys=0.00s Real=0.01s
         * [1.015s][info][gc,start       ] GC(78) Pause Full (Ergonomics)
         * [1.015s][info][gc,phases,start] GC(78) Marking Phase
         * [1.019s][info][gc,phases      ] GC(78) Marking Phase 4.385ms
         * [1.019s][info][gc,phases,start] GC(78) Summary Phase
         * [1.019s][info][gc,phases      ] GC(78) Summary Phase 0.019ms
         * [1.019s][info][gc,phases,start] GC(78) Adjust Roots
         * [1.020s][info][gc,phases      ] GC(78) Adjust Roots 0.800ms
         * [1.020s][info][gc,phases,start] GC(78) Compaction Phase
         * [1.022s][info][gc,phases      ] GC(78) Compaction Phase 2.146ms
         * [1.022s][info][gc,phases,start] GC(78) Post Compact
         * [1.022s][info][gc,phases      ] GC(78) Post Compact 0.026ms
         * [1.022s][info][gc,heap        ] GC(78) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.022s][info][gc,heap        ] GC(78) ParOldGen: 2361K(2560K)->2361K(2560K)
         * [1.022s][info][gc,metaspace   ] GC(78) Metaspace: 962K(4864K)->962K(4864K) NonClass: 868K(4352K)->868K(4352K) Class: 94K(512K)->94K(512K)
         * [1.022s][info][gc             ] GC(78) Pause Full (Ergonomics) 2M->2M(3M) 7.617ms
         * [1.022s][info][gc,cpu         ] GC(78) User=0.03s Sys=0.00s Real=0.01s
         * [1.023s][info][gc,start       ] GC(79) Pause Full (Ergonomics)
         * [1.023s][info][gc,phases,start] GC(79) Marking Phase
         * [1.027s][info][gc,phases      ] GC(79) Marking Phase 4.167ms
         * [1.027s][info][gc,phases,start] GC(79) Summary Phase
         * [1.027s][info][gc,phases      ] GC(79) Summary Phase 0.013ms
         * [1.027s][info][gc,phases,start] GC(79) Adjust Roots
         * [1.028s][info][gc,phases      ] GC(79) Adjust Roots 0.758ms
         * [1.028s][info][gc,phases,start] GC(79) Compaction Phase
         * [1.030s][info][gc,phases      ] GC(79) Compaction Phase 1.949ms
         * [1.030s][info][gc,phases,start] GC(79) Post Compact
         * [1.030s][info][gc,phases      ] GC(79) Post Compact 0.028ms
         * [1.030s][info][gc,heap        ] GC(79) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.030s][info][gc,heap        ] GC(79) ParOldGen: 2363K(2560K)->2363K(2560K)
         * [1.030s][info][gc,metaspace   ] GC(79) Metaspace: 963K(4864K)->963K(4864K) NonClass: 869K(4352K)->869K(4352K) Class: 94K(512K)->94K(512K)
         * [1.030s][info][gc             ] GC(79) Pause Full (Ergonomics) 2M->2M(3M) 7.124ms
         * [1.030s][info][gc,cpu         ] GC(79) User=0.00s Sys=0.00s Real=0.01s
         * [1.030s][info][gc,start       ] GC(80) Pause Full (Ergonomics)
         * [1.030s][info][gc,phases,start] GC(80) Marking Phase
         * [1.035s][info][gc,phases      ] GC(80) Marking Phase 5.236ms
         * [1.035s][info][gc,phases,start] GC(80) Summary Phase
         * [1.035s][info][gc,phases      ] GC(80) Summary Phase 0.021ms
         * [1.035s][info][gc,phases,start] GC(80) Adjust Roots
         * [1.036s][info][gc,phases      ] GC(80) Adjust Roots 0.732ms
         * [1.036s][info][gc,phases,start] GC(80) Compaction Phase
         * [1.038s][info][gc,phases      ] GC(80) Compaction Phase 2.037ms
         * [1.038s][info][gc,phases,start] GC(80) Post Compact
         * [1.038s][info][gc,phases      ] GC(80) Post Compact 0.031ms
         * [1.038s][info][gc,heap        ] GC(80) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.038s][info][gc,heap        ] GC(80) ParOldGen: 2364K(2560K)->2364K(2560K)
         * [1.038s][info][gc,metaspace   ] GC(80) Metaspace: 967K(4864K)->967K(4864K) NonClass: 872K(4352K)->872K(4352K) Class: 94K(512K)->94K(512K)
         * [1.038s][info][gc             ] GC(80) Pause Full (Ergonomics) 2M->2M(3M) 8.307ms
         * [1.038s][info][gc,cpu         ] GC(80) User=0.03s Sys=0.00s Real=0.01s
         * [1.039s][info][gc,start       ] GC(81) Pause Full (Ergonomics)
         * [1.039s][info][gc,phases,start] GC(81) Marking Phase
         * [1.044s][info][gc,phases      ] GC(81) Marking Phase 4.841ms
         * [1.044s][info][gc,phases,start] GC(81) Summary Phase
         * [1.044s][info][gc,phases      ] GC(81) Summary Phase 0.015ms
         * [1.044s][info][gc,phases,start] GC(81) Adjust Roots
         * [1.045s][info][gc,phases      ] GC(81) Adjust Roots 0.758ms
         * [1.045s][info][gc,phases,start] GC(81) Compaction Phase
         * [1.047s][info][gc,phases      ] GC(81) Compaction Phase 2.076ms
         * [1.047s][info][gc,phases,start] GC(81) Post Compact
         * [1.047s][info][gc,phases      ] GC(81) Post Compact 0.034ms
         * [1.047s][info][gc,heap        ] GC(81) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.047s][info][gc,heap        ] GC(81) ParOldGen: 2366K(2560K)->2366K(2560K)
         * [1.047s][info][gc,metaspace   ] GC(81) Metaspace: 971K(4864K)->971K(4864K) NonClass: 876K(4352K)->876K(4352K) Class: 95K(512K)->95K(512K)
         * [1.047s][info][gc             ] GC(81) Pause Full (Ergonomics) 2M->2M(3M) 7.972ms
         * [1.047s][info][gc,cpu         ] GC(81) User=0.00s Sys=0.00s Real=0.01s
         * [1.047s][info][gc,start       ] GC(82) Pause Full (Ergonomics)
         * [1.047s][info][gc,phases,start] GC(82) Marking Phase
         * [1.052s][info][gc,phases      ] GC(82) Marking Phase 4.678ms
         * [1.052s][info][gc,phases,start] GC(82) Summary Phase
         * [1.052s][info][gc,phases      ] GC(82) Summary Phase 0.015ms
         * [1.052s][info][gc,phases,start] GC(82) Adjust Roots
         * [1.053s][info][gc,phases      ] GC(82) Adjust Roots 0.799ms
         * [1.053s][info][gc,phases,start] GC(82) Compaction Phase
         * [1.055s][info][gc,phases      ] GC(82) Compaction Phase 2.181ms
         * [1.055s][info][gc,phases,start] GC(82) Post Compact
         * [1.055s][info][gc,phases      ] GC(82) Post Compact 0.024ms
         * [1.055s][info][gc,heap        ] GC(82) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.055s][info][gc,heap        ] GC(82) ParOldGen: 2367K(2560K)->2367K(2560K)
         * [1.055s][info][gc,metaspace   ] GC(82) Metaspace: 971K(4864K)->971K(4864K) NonClass: 876K(4352K)->876K(4352K) Class: 95K(512K)->95K(512K)
         * [1.055s][info][gc             ] GC(82) Pause Full (Ergonomics) 2M->2M(3M) 7.932ms
         * [1.055s][info][gc,cpu         ] GC(82) User=0.03s Sys=0.00s Real=0.01s
         * [1.055s][info][gc,start       ] GC(83) Pause Full (Ergonomics)
         * [1.055s][info][gc,phases,start] GC(83) Marking Phase
         * [1.060s][info][gc,phases      ] GC(83) Marking Phase 4.544ms
         * [1.060s][info][gc,phases,start] GC(83) Summary Phase
         * [1.060s][info][gc,phases      ] GC(83) Summary Phase 0.016ms
         * [1.060s][info][gc,phases,start] GC(83) Adjust Roots
         * [1.061s][info][gc,phases      ] GC(83) Adjust Roots 0.742ms
         * [1.061s][info][gc,phases,start] GC(83) Compaction Phase
         * [1.063s][info][gc,phases      ] GC(83) Compaction Phase 1.736ms
         * [1.063s][info][gc,phases,start] GC(83) Post Compact
         * [1.063s][info][gc,phases      ] GC(83) Post Compact 0.026ms
         * [1.063s][info][gc,heap        ] GC(83) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.063s][info][gc,heap        ] GC(83) ParOldGen: 2393K(2560K)->2393K(2560K)
         * [1.063s][info][gc,metaspace   ] GC(83) Metaspace: 971K(4864K)->971K(4864K) NonClass: 876K(4352K)->876K(4352K) Class: 95K(512K)->95K(512K)
         * [1.063s][info][gc             ] GC(83) Pause Full (Ergonomics) 2M->2M(3M) 7.288ms
         * [1.063s][info][gc,cpu         ] GC(83) User=0.00s Sys=0.00s Real=0.01s
         * [1.063s][info][gc,start       ] GC(84) Pause Full (Ergonomics)
         * [1.063s][info][gc,phases,start] GC(84) Marking Phase
         * [1.068s][info][gc,phases      ] GC(84) Marking Phase 4.779ms
         * [1.068s][info][gc,phases,start] GC(84) Summary Phase
         * [1.068s][info][gc,phases      ] GC(84) Summary Phase 0.015ms
         * [1.068s][info][gc,phases,start] GC(84) Adjust Roots
         * [1.069s][info][gc,phases      ] GC(84) Adjust Roots 0.843ms
         * [1.069s][info][gc,phases,start] GC(84) Compaction Phase
         * [1.072s][info][gc,phases      ] GC(84) Compaction Phase 3.290ms
         * [1.072s][info][gc,phases,start] GC(84) Post Compact
         * [1.072s][info][gc,phases      ] GC(84) Post Compact 0.029ms
         * [1.072s][info][gc,heap        ] GC(84) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.072s][info][gc,heap        ] GC(84) ParOldGen: 2395K(2560K)->2395K(2560K)
         * [1.072s][info][gc,metaspace   ] GC(84) Metaspace: 971K(4864K)->971K(4864K) NonClass: 876K(4352K)->876K(4352K) Class: 95K(512K)->95K(512K)
         * [1.072s][info][gc             ] GC(84) Pause Full (Ergonomics) 2M->2M(3M) 9.230ms
         * [1.072s][info][gc,cpu         ] GC(84) User=0.03s Sys=0.00s Real=0.01s
         * [1.073s][info][gc,start       ] GC(85) Pause Full (Ergonomics)
         * [1.073s][info][gc,phases,start] GC(85) Marking Phase
         * [1.079s][info][gc,phases      ] GC(85) Marking Phase 5.733ms
         * [1.079s][info][gc,phases,start] GC(85) Summary Phase
         * [1.079s][info][gc,phases      ] GC(85) Summary Phase 0.014ms
         * [1.079s][info][gc,phases,start] GC(85) Adjust Roots
         * [1.080s][info][gc,phases      ] GC(85) Adjust Roots 0.754ms
         * [1.080s][info][gc,phases,start] GC(85) Compaction Phase
         * [1.082s][info][gc,phases      ] GC(85) Compaction Phase 2.689ms
         * [1.082s][info][gc,phases,start] GC(85) Post Compact
         * [1.082s][info][gc,phases      ] GC(85) Post Compact 0.048ms
         * [1.082s][info][gc,heap        ] GC(85) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.082s][info][gc,heap        ] GC(85) ParOldGen: 2397K(2560K)->2397K(2560K)
         * [1.082s][info][gc,metaspace   ] GC(85) Metaspace: 972K(4864K)->972K(4864K) NonClass: 876K(4352K)->876K(4352K) Class: 95K(512K)->95K(512K)
         * [1.082s][info][gc             ] GC(85) Pause Full (Ergonomics) 2M->2M(3M) 9.547ms
         * [1.083s][info][gc,cpu         ] GC(85) User=0.03s Sys=0.00s Real=0.01s
         * [1.083s][info][gc,start       ] GC(86) Pause Full (Ergonomics)
         * [1.083s][info][gc,phases,start] GC(86) Marking Phase
         * [1.089s][info][gc,phases      ] GC(86) Marking Phase 5.894ms
         * [1.089s][info][gc,phases,start] GC(86) Summary Phase
         * [1.089s][info][gc,phases      ] GC(86) Summary Phase 0.021ms
         * [1.089s][info][gc,phases,start] GC(86) Adjust Roots
         * [1.090s][info][gc,phases      ] GC(86) Adjust Roots 0.804ms
         * [1.090s][info][gc,phases,start] GC(86) Compaction Phase
         * [1.092s][info][gc,phases      ] GC(86) Compaction Phase 2.106ms
         * [1.092s][info][gc,phases,start] GC(86) Post Compact
         * [1.092s][info][gc,phases      ] GC(86) Post Compact 0.034ms
         * [1.092s][info][gc,heap        ] GC(86) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.092s][info][gc,heap        ] GC(86) ParOldGen: 2399K(2560K)->2399K(2560K)
         * [1.092s][info][gc,metaspace   ] GC(86) Metaspace: 972K(4864K)->972K(4864K) NonClass: 877K(4352K)->877K(4352K) Class: 95K(512K)->95K(512K)
         * [1.092s][info][gc             ] GC(86) Pause Full (Ergonomics) 2M->2M(3M) 9.155ms
         * [1.093s][info][gc,cpu         ] GC(86) User=0.00s Sys=0.00s Real=0.01s
         * [1.093s][info][gc,start       ] GC(87) Pause Full (Ergonomics)
         * [1.093s][info][gc,phases,start] GC(87) Marking Phase
         * [1.099s][info][gc,phases      ] GC(87) Marking Phase 6.602ms
         * [1.099s][info][gc,phases,start] GC(87) Summary Phase
         * [1.099s][info][gc,phases      ] GC(87) Summary Phase 0.020ms
         * [1.099s][info][gc,phases,start] GC(87) Adjust Roots
         * [1.100s][info][gc,phases      ] GC(87) Adjust Roots 0.688ms
         * [1.100s][info][gc,phases,start] GC(87) Compaction Phase
         * [1.102s][info][gc,phases      ] GC(87) Compaction Phase 2.116ms
         * [1.102s][info][gc,phases,start] GC(87) Post Compact
         * [1.102s][info][gc,phases      ] GC(87) Post Compact 0.024ms
         * [1.102s][info][gc,heap        ] GC(87) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.102s][info][gc,heap        ] GC(87) ParOldGen: 2400K(2560K)->2400K(2560K)
         * [1.102s][info][gc,metaspace   ] GC(87) Metaspace: 972K(4864K)->972K(4864K) NonClass: 877K(4352K)->877K(4352K) Class: 95K(512K)->95K(512K)
         * [1.102s][info][gc             ] GC(87) Pause Full (Ergonomics) 2M->2M(3M) 9.683ms
         * [1.102s][info][gc,cpu         ] GC(87) User=0.03s Sys=0.00s Real=0.01s
         * [1.103s][info][gc,start       ] GC(88) Pause Full (Ergonomics)
         * [1.103s][info][gc,phases,start] GC(88) Marking Phase
         * [1.108s][info][gc,phases      ] GC(88) Marking Phase 4.671ms
         * [1.108s][info][gc,phases,start] GC(88) Summary Phase
         * [1.108s][info][gc,phases      ] GC(88) Summary Phase 0.017ms
         * [1.108s][info][gc,phases,start] GC(88) Adjust Roots
         * [1.109s][info][gc,phases      ] GC(88) Adjust Roots 1.200ms
         * [1.109s][info][gc,phases,start] GC(88) Compaction Phase
         * [1.111s][info][gc,phases      ] GC(88) Compaction Phase 1.983ms
         * [1.111s][info][gc,phases,start] GC(88) Post Compact
         * [1.111s][info][gc,phases      ] GC(88) Post Compact 0.024ms
         * [1.111s][info][gc,heap        ] GC(88) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.111s][info][gc,heap        ] GC(88) ParOldGen: 2402K(2560K)->2402K(2560K)
         * [1.111s][info][gc,metaspace   ] GC(88) Metaspace: 972K(4864K)->972K(4864K) NonClass: 877K(4352K)->877K(4352K) Class: 95K(512K)->95K(512K)
         * [1.111s][info][gc             ] GC(88) Pause Full (Ergonomics) 2M->2M(3M) 8.141ms
         * [1.111s][info][gc,cpu         ] GC(88) User=0.00s Sys=0.00s Real=0.01s
         * [1.112s][info][gc,start       ] GC(89) Pause Full (Ergonomics)
         * [1.112s][info][gc,phases,start] GC(89) Marking Phase
         * [1.118s][info][gc,phases      ] GC(89) Marking Phase 6.021ms
         * [1.118s][info][gc,phases,start] GC(89) Summary Phase
         * [1.118s][info][gc,phases      ] GC(89) Summary Phase 0.018ms
         * [1.118s][info][gc,phases,start] GC(89) Adjust Roots
         * [1.119s][info][gc,phases      ] GC(89) Adjust Roots 0.816ms
         * [1.119s][info][gc,phases,start] GC(89) Compaction Phase
         * [1.121s][info][gc,phases      ] GC(89) Compaction Phase 2.093ms
         * [1.121s][info][gc,phases,start] GC(89) Post Compact
         * [1.121s][info][gc,phases      ] GC(89) Post Compact 0.028ms
         * [1.121s][info][gc,heap        ] GC(89) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.121s][info][gc,heap        ] GC(89) ParOldGen: 2404K(2560K)->2403K(2560K)
         * [1.121s][info][gc,metaspace   ] GC(89) Metaspace: 972K(4864K)->972K(4864K) NonClass: 877K(4352K)->877K(4352K) Class: 95K(512K)->95K(512K)
         * [1.121s][info][gc             ] GC(89) Pause Full (Ergonomics) 2M->2M(3M) 9.253ms
         * [1.121s][info][gc,cpu         ] GC(89) User=0.03s Sys=0.02s Real=0.01s
         * [1.121s][info][gc,start       ] GC(90) Pause Full (Ergonomics)
         * [1.121s][info][gc,phases,start] GC(90) Marking Phase
         * [1.126s][info][gc,phases      ] GC(90) Marking Phase 4.707ms
         * [1.126s][info][gc,phases,start] GC(90) Summary Phase
         * [1.126s][info][gc,phases      ] GC(90) Summary Phase 0.014ms
         * [1.126s][info][gc,phases,start] GC(90) Adjust Roots
         * [1.127s][info][gc,phases      ] GC(90) Adjust Roots 0.789ms
         * [1.127s][info][gc,phases,start] GC(90) Compaction Phase
         * [1.130s][info][gc,phases      ] GC(90) Compaction Phase 2.582ms
         * [1.130s][info][gc,phases,start] GC(90) Post Compact
         * [1.130s][info][gc,phases      ] GC(90) Post Compact 0.028ms
         * [1.130s][info][gc,heap        ] GC(90) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.130s][info][gc,heap        ] GC(90) ParOldGen: 2405K(2560K)->2405K(2560K)
         * [1.130s][info][gc,metaspace   ] GC(90) Metaspace: 972K(4864K)->972K(4864K) NonClass: 877K(4352K)->877K(4352K) Class: 95K(512K)->95K(512K)
         * [1.130s][info][gc             ] GC(90) Pause Full (Ergonomics) 2M->2M(3M) 8.400ms
         * [1.130s][info][gc,cpu         ] GC(90) User=0.03s Sys=0.00s Real=0.01s
         * [1.132s][info][gc,start       ] GC(91) Pause Full (Ergonomics)
         * [1.132s][info][gc,phases,start] GC(91) Marking Phase
         * [1.138s][info][gc,phases      ] GC(91) Marking Phase 6.430ms
         * [1.138s][info][gc,phases,start] GC(91) Summary Phase
         * [1.138s][info][gc,phases      ] GC(91) Summary Phase 0.017ms
         * [1.138s][info][gc,phases,start] GC(91) Adjust Roots
         * [1.139s][info][gc,phases      ] GC(91) Adjust Roots 0.929ms
         * [1.139s][info][gc,phases,start] GC(91) Compaction Phase
         * [1.142s][info][gc,phases      ] GC(91) Compaction Phase 2.531ms
         * [1.142s][info][gc,phases,start] GC(91) Post Compact
         * [1.142s][info][gc,phases      ] GC(91) Post Compact 0.025ms
         * [1.142s][info][gc,heap        ] GC(91) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.142s][info][gc,heap        ] GC(91) ParOldGen: 2407K(2560K)->2407K(2560K)
         * [1.142s][info][gc,metaspace   ] GC(91) Metaspace: 973K(4864K)->973K(4864K) NonClass: 877K(4352K)->877K(4352K) Class: 95K(512K)->95K(512K)
         * [1.142s][info][gc             ] GC(91) Pause Full (Ergonomics) 2M->2M(3M) 10.196ms
         * [1.142s][info][gc,cpu         ] GC(91) User=0.00s Sys=0.00s Real=0.01s
         * [1.142s][info][gc,start       ] GC(92) Pause Full (Ergonomics)
         * [1.142s][info][gc,phases,start] GC(92) Marking Phase
         * [1.148s][info][gc,phases      ] GC(92) Marking Phase 5.836ms
         * [1.148s][info][gc,phases,start] GC(92) Summary Phase
         * [1.148s][info][gc,phases      ] GC(92) Summary Phase 0.018ms
         * [1.148s][info][gc,phases,start] GC(92) Adjust Roots
         * [1.149s][info][gc,phases      ] GC(92) Adjust Roots 1.090ms
         * [1.149s][info][gc,phases,start] GC(92) Compaction Phase
         * [1.153s][info][gc,phases      ] GC(92) Compaction Phase 4.090ms
         * [1.153s][info][gc,phases,start] GC(92) Post Compact
         * [1.153s][info][gc,phases      ] GC(92) Post Compact 0.032ms
         * [1.153s][info][gc,heap        ] GC(92) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.153s][info][gc,heap        ] GC(92) ParOldGen: 2409K(2560K)->2405K(2560K)
         * [1.153s][info][gc,metaspace   ] GC(92) Metaspace: 973K(4864K)->973K(4864K) NonClass: 877K(4352K)->877K(4352K) Class: 95K(512K)->95K(512K)
         * [1.153s][info][gc             ] GC(92) Pause Full (Ergonomics) 2M->2M(3M) 11.331ms
         * [1.153s][info][gc,cpu         ] GC(92) User=0.03s Sys=0.00s Real=0.01s
         * [1.154s][info][gc,start       ] GC(93) Pause Full (Ergonomics)
         * [1.154s][info][gc,phases,start] GC(93) Marking Phase
         * [1.159s][info][gc,phases      ] GC(93) Marking Phase 5.181ms
         * [1.159s][info][gc,phases,start] GC(93) Summary Phase
         * [1.159s][info][gc,phases      ] GC(93) Summary Phase 0.021ms
         * [1.159s][info][gc,phases,start] GC(93) Adjust Roots
         * [1.160s][info][gc,phases      ] GC(93) Adjust Roots 1.088ms
         * [1.160s][info][gc,phases,start] GC(93) Compaction Phase
         * [1.162s][info][gc,phases      ] GC(93) Compaction Phase 2.108ms
         * [1.162s][info][gc,phases,start] GC(93) Post Compact
         * [1.162s][info][gc,phases      ] GC(93) Post Compact 0.030ms
         * [1.162s][info][gc,heap        ] GC(93) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.162s][info][gc,heap        ] GC(93) ParOldGen: 2407K(2560K)->2407K(2560K)
         * [1.162s][info][gc,metaspace   ] GC(93) Metaspace: 973K(4864K)->973K(4864K) NonClass: 877K(4352K)->877K(4352K) Class: 95K(512K)->95K(512K)
         * [1.163s][info][gc             ] GC(93) Pause Full (Ergonomics) 2M->2M(3M) 8.733ms
         * [1.163s][info][gc,cpu         ] GC(93) User=0.02s Sys=0.00s Real=0.01s
         * [1.163s][info][gc,start       ] GC(94) Pause Full (Ergonomics)
         * [1.163s][info][gc,phases,start] GC(94) Marking Phase
         * [1.169s][info][gc,phases      ] GC(94) Marking Phase 6.402ms
         * [1.169s][info][gc,phases,start] GC(94) Summary Phase
         * [1.169s][info][gc,phases      ] GC(94) Summary Phase 0.014ms
         * [1.169s][info][gc,phases,start] GC(94) Adjust Roots
         * [1.170s][info][gc,phases      ] GC(94) Adjust Roots 0.784ms
         * [1.170s][info][gc,phases,start] GC(94) Compaction Phase
         * [1.173s][info][gc,phases      ] GC(94) Compaction Phase 2.977ms
         * [1.173s][info][gc,phases,start] GC(94) Post Compact
         * [1.173s][info][gc,phases      ] GC(94) Post Compact 0.028ms
         * [1.173s][info][gc,heap        ] GC(94) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.173s][info][gc,heap        ] GC(94) ParOldGen: 2408K(2560K)->2408K(2560K)
         * [1.173s][info][gc,metaspace   ] GC(94) Metaspace: 973K(4864K)->973K(4864K) NonClass: 877K(4352K)->877K(4352K) Class: 95K(512K)->95K(512K)
         * [1.173s][info][gc             ] GC(94) Pause Full (Ergonomics) 2M->2M(3M) 10.466ms
         * [1.173s][info][gc,cpu         ] GC(94) User=0.00s Sys=0.00s Real=0.01s
         * [1.174s][info][gc,start       ] GC(95) Pause Full (Ergonomics)
         * [1.174s][info][gc,phases,start] GC(95) Marking Phase
         * [1.180s][info][gc,phases      ] GC(95) Marking Phase 6.525ms
         * [1.180s][info][gc,phases,start] GC(95) Summary Phase
         * [1.180s][info][gc,phases      ] GC(95) Summary Phase 0.019ms
         * [1.180s][info][gc,phases,start] GC(95) Adjust Roots
         * [1.181s][info][gc,phases      ] GC(95) Adjust Roots 0.892ms
         * [1.181s][info][gc,phases,start] GC(95) Compaction Phase
         * [1.184s][info][gc,phases      ] GC(95) Compaction Phase 2.416ms
         * [1.184s][info][gc,phases,start] GC(95) Post Compact
         * [1.184s][info][gc,phases      ] GC(95) Post Compact 0.031ms
         * [1.184s][info][gc,heap        ] GC(95) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.184s][info][gc,heap        ] GC(95) ParOldGen: 2410K(2560K)->2410K(2560K)
         * [1.184s][info][gc,metaspace   ] GC(95) Metaspace: 973K(4864K)->973K(4864K) NonClass: 878K(4352K)->878K(4352K) Class: 95K(512K)->95K(512K)
         * [1.184s][info][gc             ] GC(95) Pause Full (Ergonomics) 2M->2M(3M) 10.199ms
         * [1.184s][info][gc,cpu         ] GC(95) User=0.03s Sys=0.00s Real=0.01s
         * [1.184s][info][gc,start       ] GC(96) Pause Full (Ergonomics)
         * [1.184s][info][gc,phases,start] GC(96) Marking Phase
         * [1.189s][info][gc,phases      ] GC(96) Marking Phase 4.728ms
         * [1.189s][info][gc,phases,start] GC(96) Summary Phase
         * [1.189s][info][gc,phases      ] GC(96) Summary Phase 0.021ms
         * [1.189s][info][gc,phases,start] GC(96) Adjust Roots
         * [1.190s][info][gc,phases      ] GC(96) Adjust Roots 1.144ms
         * [1.190s][info][gc,phases,start] GC(96) Compaction Phase
         * [1.193s][info][gc,phases      ] GC(96) Compaction Phase 2.326ms
         * [1.193s][info][gc,phases,start] GC(96) Post Compact
         * [1.193s][info][gc,phases      ] GC(96) Post Compact 0.029ms
         * [1.193s][info][gc,heap        ] GC(96) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.193s][info][gc,heap        ] GC(96) ParOldGen: 2411K(2560K)->2411K(2560K)
         * [1.193s][info][gc,metaspace   ] GC(96) Metaspace: 973K(4864K)->973K(4864K) NonClass: 878K(4352K)->878K(4352K) Class: 95K(512K)->95K(512K)
         * [1.193s][info][gc             ] GC(96) Pause Full (Ergonomics) 2M->2M(3M) 8.529ms
         * [1.193s][info][gc,cpu         ] GC(96) User=0.02s Sys=0.00s Real=0.01s
         * [1.193s][info][gc,start       ] GC(97) Pause Full (Ergonomics)
         * [1.193s][info][gc,phases,start] GC(97) Marking Phase
         * [1.199s][info][gc,phases      ] GC(97) Marking Phase 5.875ms
         * [1.199s][info][gc,phases,start] GC(97) Summary Phase
         * [1.199s][info][gc,phases      ] GC(97) Summary Phase 0.019ms
         * [1.199s][info][gc,phases,start] GC(97) Adjust Roots
         * [1.200s][info][gc,phases      ] GC(97) Adjust Roots 0.826ms
         * [1.200s][info][gc,phases,start] GC(97) Compaction Phase
         * [1.202s][info][gc,phases      ] GC(97) Compaction Phase 2.049ms
         * [1.202s][info][gc,phases,start] GC(97) Post Compact
         * [1.202s][info][gc,phases      ] GC(97) Post Compact 0.025ms
         * [1.202s][info][gc,heap        ] GC(97) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.202s][info][gc,heap        ] GC(97) ParOldGen: 2413K(2560K)->2413K(2560K)
         * [1.202s][info][gc,metaspace   ] GC(97) Metaspace: 973K(4864K)->973K(4864K) NonClass: 878K(4352K)->878K(4352K) Class: 95K(512K)->95K(512K)
         * [1.202s][info][gc             ] GC(97) Pause Full (Ergonomics) 2M->2M(3M) 9.060ms
         * [1.202s][info][gc,cpu         ] GC(97) User=0.00s Sys=0.00s Real=0.01s
         * [1.203s][info][gc,start       ] GC(98) Pause Full (Ergonomics)
         * [1.203s][info][gc,phases,start] GC(98) Marking Phase
         * [1.209s][info][gc,phases      ] GC(98) Marking Phase 6.026ms
         * [1.209s][info][gc,phases,start] GC(98) Summary Phase
         * [1.209s][info][gc,phases      ] GC(98) Summary Phase 0.018ms
         * [1.209s][info][gc,phases,start] GC(98) Adjust Roots
         * [1.210s][info][gc,phases      ] GC(98) Adjust Roots 0.821ms
         * [1.210s][info][gc,phases,start] GC(98) Compaction Phase
         * [1.212s][info][gc,phases      ] GC(98) Compaction Phase 2.038ms
         * [1.212s][info][gc,phases,start] GC(98) Post Compact
         * [1.212s][info][gc,phases      ] GC(98) Post Compact 0.027ms
         * [1.212s][info][gc,heap        ] GC(98) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.212s][info][gc,heap        ] GC(98) ParOldGen: 2423K(2560K)->2422K(2560K)
         * [1.212s][info][gc,metaspace   ] GC(98) Metaspace: 973K(4864K)->973K(4864K) NonClass: 878K(4352K)->878K(4352K) Class: 95K(512K)->95K(512K)
         * [1.212s][info][gc             ] GC(98) Pause Full (Ergonomics) 2M->2M(3M) 9.177ms
         * [1.212s][info][gc,cpu         ] GC(98) User=0.03s Sys=0.00s Real=0.01s
         * [1.212s][info][gc,start       ] GC(99) Pause Full (Ergonomics)
         * [1.212s][info][gc,phases,start] GC(99) Marking Phase
         * [1.218s][info][gc,phases      ] GC(99) Marking Phase 5.988ms
         * [1.219s][info][gc,phases,start] GC(99) Summary Phase
         * [1.219s][info][gc,phases      ] GC(99) Summary Phase 0.015ms
         * [1.219s][info][gc,phases,start] GC(99) Adjust Roots
         * [1.220s][info][gc,phases      ] GC(99) Adjust Roots 0.962ms
         * [1.220s][info][gc,phases,start] GC(99) Compaction Phase
         * [1.222s][info][gc,phases      ] GC(99) Compaction Phase 2.461ms
         * [1.222s][info][gc,phases,start] GC(99) Post Compact
         * [1.222s][info][gc,phases      ] GC(99) Post Compact 0.023ms
         * [1.222s][info][gc,heap        ] GC(99) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.222s][info][gc,heap        ] GC(99) ParOldGen: 2426K(2560K)->2426K(2560K)
         * [1.222s][info][gc,metaspace   ] GC(99) Metaspace: 974K(4864K)->974K(4864K) NonClass: 878K(4352K)->878K(4352K) Class: 95K(512K)->95K(512K)
         * [1.222s][info][gc             ] GC(99) Pause Full (Ergonomics) 2M->2M(3M) 9.689ms
         * [1.222s][info][gc,cpu         ] GC(99) User=0.03s Sys=0.00s Real=0.01s
         * [1.223s][info][gc,start       ] GC(100) Pause Full (Ergonomics)
         * [1.223s][info][gc,phases,start] GC(100) Marking Phase
         * [1.228s][info][gc,phases      ] GC(100) Marking Phase 5.806ms
         * [1.228s][info][gc,phases,start] GC(100) Summary Phase
         * [1.228s][info][gc,phases      ] GC(100) Summary Phase 0.015ms
         * [1.228s][info][gc,phases,start] GC(100) Adjust Roots
         * [1.230s][info][gc,phases      ] GC(100) Adjust Roots 1.312ms
         * [1.230s][info][gc,phases,start] GC(100) Compaction Phase
         * [1.232s][info][gc,phases      ] GC(100) Compaction Phase 2.219ms
         * [1.232s][info][gc,phases,start] GC(100) Post Compact
         * [1.232s][info][gc,phases      ] GC(100) Post Compact 0.027ms
         * [1.232s][info][gc,heap        ] GC(100) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.232s][info][gc,heap        ] GC(100) ParOldGen: 2428K(2560K)->2428K(2560K)
         * [1.232s][info][gc,metaspace   ] GC(100) Metaspace: 974K(4864K)->974K(4864K) NonClass: 878K(4352K)->878K(4352K) Class: 95K(512K)->95K(512K)
         * [1.232s][info][gc             ] GC(100) Pause Full (Ergonomics) 2M->2M(3M) 9.684ms
         * [1.232s][info][gc,cpu         ] GC(100) User=0.00s Sys=0.00s Real=0.01s
         * [1.233s][info][gc,start       ] GC(101) Pause Full (Ergonomics)
         * [1.233s][info][gc,phases,start] GC(101) Marking Phase
         * [1.239s][info][gc,phases      ] GC(101) Marking Phase 5.932ms
         * [1.239s][info][gc,phases,start] GC(101) Summary Phase
         * [1.239s][info][gc,phases      ] GC(101) Summary Phase 0.020ms
         * [1.239s][info][gc,phases,start] GC(101) Adjust Roots
         * [1.240s][info][gc,phases      ] GC(101) Adjust Roots 0.867ms
         * [1.240s][info][gc,phases,start] GC(101) Compaction Phase
         * [1.242s][info][gc,phases      ] GC(101) Compaction Phase 2.212ms
         * [1.242s][info][gc,phases,start] GC(101) Post Compact
         * [1.242s][info][gc,phases      ] GC(101) Post Compact 0.030ms
         * [1.242s][info][gc,heap        ] GC(101) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.242s][info][gc,heap        ] GC(101) ParOldGen: 2430K(2560K)->2430K(2560K)
         * [1.242s][info][gc,metaspace   ] GC(101) Metaspace: 974K(4864K)->974K(4864K) NonClass: 878K(4352K)->878K(4352K) Class: 95K(512K)->95K(512K)
         * [1.242s][info][gc             ] GC(101) Pause Full (Ergonomics) 2M->2M(3M) 9.342ms
         * [1.242s][info][gc,cpu         ] GC(101) User=0.03s Sys=0.00s Real=0.01s
         * [1.242s][info][gc,start       ] GC(102) Pause Full (Ergonomics)
         * [1.242s][info][gc,phases,start] GC(102) Marking Phase
         * [1.248s][info][gc,phases      ] GC(102) Marking Phase 5.270ms
         * [1.248s][info][gc,phases,start] GC(102) Summary Phase
         * [1.248s][info][gc,phases      ] GC(102) Summary Phase 0.019ms
         * [1.248s][info][gc,phases,start] GC(102) Adjust Roots
         * [1.249s][info][gc,phases      ] GC(102) Adjust Roots 1.215ms
         * [1.249s][info][gc,phases,start] GC(102) Compaction Phase
         * [1.251s][info][gc,phases      ] GC(102) Compaction Phase 2.209ms
         * [1.251s][info][gc,phases,start] GC(102) Post Compact
         * [1.251s][info][gc,phases      ] GC(102) Post Compact 0.042ms
         * [1.251s][info][gc,heap        ] GC(102) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.251s][info][gc,heap        ] GC(102) ParOldGen: 2431K(2560K)->2431K(2560K)
         * [1.251s][info][gc,metaspace   ] GC(102) Metaspace: 974K(4864K)->974K(4864K) NonClass: 878K(4352K)->878K(4352K) Class: 95K(512K)->95K(512K)
         * [1.251s][info][gc             ] GC(102) Pause Full (Ergonomics) 2M->2M(3M) 9.054ms
         * [1.251s][info][gc,cpu         ] GC(102) User=0.00s Sys=0.00s Real=0.01s
         * [1.252s][info][gc,start       ] GC(103) Pause Full (Ergonomics)
         * [1.252s][info][gc,phases,start] GC(103) Marking Phase
         * [1.257s][info][gc,phases      ] GC(103) Marking Phase 4.913ms
         * [1.257s][info][gc,phases,start] GC(103) Summary Phase
         * [1.257s][info][gc,phases      ] GC(103) Summary Phase 0.017ms
         * [1.257s][info][gc,phases,start] GC(103) Adjust Roots
         * [1.259s][info][gc,phases      ] GC(103) Adjust Roots 1.629ms
         * [1.259s][info][gc,phases,start] GC(103) Compaction Phase
         * [1.261s][info][gc,phases      ] GC(103) Compaction Phase 2.181ms
         * [1.261s][info][gc,phases,start] GC(103) Post Compact
         * [1.261s][info][gc,phases      ] GC(103) Post Compact 0.027ms
         * [1.261s][info][gc,heap        ] GC(103) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.261s][info][gc,heap        ] GC(103) ParOldGen: 2433K(2560K)->2433K(2560K)
         * [1.261s][info][gc,metaspace   ] GC(103) Metaspace: 974K(4864K)->974K(4864K) NonClass: 878K(4352K)->878K(4352K) Class: 95K(512K)->95K(512K)
         * [1.261s][info][gc             ] GC(103) Pause Full (Ergonomics) 2M->2M(3M) 9.033ms
         * [1.261s][info][gc,cpu         ] GC(103) User=0.03s Sys=0.00s Real=0.01s
         * [1.261s][info][gc,start       ] GC(104) Pause Full (Ergonomics)
         * [1.261s][info][gc,phases,start] GC(104) Marking Phase
         * [1.267s][info][gc,phases      ] GC(104) Marking Phase 6.109ms
         * [1.267s][info][gc,phases,start] GC(104) Summary Phase
         * [1.267s][info][gc,phases      ] GC(104) Summary Phase 0.018ms
         * [1.267s][info][gc,phases,start] GC(104) Adjust Roots
         * [1.268s][info][gc,phases      ] GC(104) Adjust Roots 0.789ms
         * [1.268s][info][gc,phases,start] GC(104) Compaction Phase
         * [1.270s][info][gc,phases      ] GC(104) Compaction Phase 1.996ms
         * [1.270s][info][gc,phases,start] GC(104) Post Compact
         * [1.270s][info][gc,phases      ] GC(104) Post Compact 0.029ms
         * [1.270s][info][gc,heap        ] GC(104) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.270s][info][gc,heap        ] GC(104) ParOldGen: 2434K(2560K)->2434K(2560K)
         * [1.270s][info][gc,metaspace   ] GC(104) Metaspace: 974K(4864K)->974K(4864K) NonClass: 878K(4352K)->878K(4352K) Class: 95K(512K)->95K(512K)
         * [1.271s][info][gc             ] GC(104) Pause Full (Ergonomics) 2M->2M(3M) 9.220ms
         * [1.271s][info][gc,cpu         ] GC(104) User=0.00s Sys=0.02s Real=0.01s
         * [1.271s][info][gc,start       ] GC(105) Pause Full (Ergonomics)
         * [1.271s][info][gc,phases,start] GC(105) Marking Phase
         * [1.276s][info][gc,phases      ] GC(105) Marking Phase 4.650ms
         * [1.276s][info][gc,phases,start] GC(105) Summary Phase
         * [1.276s][info][gc,phases      ] GC(105) Summary Phase 0.014ms
         * [1.276s][info][gc,phases,start] GC(105) Adjust Roots
         * [1.277s][info][gc,phases      ] GC(105) Adjust Roots 0.805ms
         * [1.277s][info][gc,phases,start] GC(105) Compaction Phase
         * [1.279s][info][gc,phases      ] GC(105) Compaction Phase 2.107ms
         * [1.279s][info][gc,phases,start] GC(105) Post Compact
         * [1.279s][info][gc,phases      ] GC(105) Post Compact 0.027ms
         * [1.279s][info][gc,heap        ] GC(105) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.279s][info][gc,heap        ] GC(105) ParOldGen: 2436K(2560K)->2436K(2560K)
         * [1.279s][info][gc,metaspace   ] GC(105) Metaspace: 974K(4864K)->974K(4864K) NonClass: 879K(4352K)->879K(4352K) Class: 95K(512K)->95K(512K)
         * [1.279s][info][gc             ] GC(105) Pause Full (Ergonomics) 2M->2M(3M) 7.856ms
         * [1.279s][info][gc,cpu         ] GC(105) User=0.00s Sys=0.00s Real=0.01s
         * [1.279s][info][gc,start       ] GC(106) Pause Full (Ergonomics)
         * [1.279s][info][gc,phases,start] GC(106) Marking Phase
         * [1.285s][info][gc,phases      ] GC(106) Marking Phase 5.300ms
         * [1.285s][info][gc,phases,start] GC(106) Summary Phase
         * [1.285s][info][gc,phases      ] GC(106) Summary Phase 0.014ms
         * [1.285s][info][gc,phases,start] GC(106) Adjust Roots
         * [1.285s][info][gc,phases      ] GC(106) Adjust Roots 0.783ms
         * [1.285s][info][gc,phases,start] GC(106) Compaction Phase
         * [1.288s][info][gc,phases      ] GC(106) Compaction Phase 2.148ms
         * [1.288s][info][gc,phases,start] GC(106) Post Compact
         * [1.288s][info][gc,phases      ] GC(106) Post Compact 0.032ms
         * [1.288s][info][gc,heap        ] GC(106) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.288s][info][gc,heap        ] GC(106) ParOldGen: 2438K(2560K)->2438K(2560K)
         * [1.288s][info][gc,metaspace   ] GC(106) Metaspace: 975K(4864K)->975K(4864K) NonClass: 879K(4352K)->879K(4352K) Class: 95K(512K)->95K(512K)
         * [1.288s][info][gc             ] GC(106) Pause Full (Ergonomics) 2M->2M(3M) 8.514ms
         * [1.288s][info][gc,cpu         ] GC(106) User=0.02s Sys=0.00s Real=0.01s
         * [1.288s][info][gc,start       ] GC(107) Pause Full (Ergonomics)
         * [1.288s][info][gc,phases,start] GC(107) Marking Phase
         * [1.294s][info][gc,phases      ] GC(107) Marking Phase 5.535ms
         * [1.294s][info][gc,phases,start] GC(107) Summary Phase
         * [1.294s][info][gc,phases      ] GC(107) Summary Phase 0.013ms
         * [1.294s][info][gc,phases,start] GC(107) Adjust Roots
         * [1.295s][info][gc,phases      ] GC(107) Adjust Roots 0.767ms
         * [1.295s][info][gc,phases,start] GC(107) Compaction Phase
         * [1.297s][info][gc,phases      ] GC(107) Compaction Phase 2.067ms
         * [1.297s][info][gc,phases,start] GC(107) Post Compact
         * [1.297s][info][gc,phases      ] GC(107) Post Compact 0.049ms
         * [1.297s][info][gc,heap        ] GC(107) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.297s][info][gc,heap        ] GC(107) ParOldGen: 2440K(2560K)->2440K(2560K)
         * [1.297s][info][gc,metaspace   ] GC(107) Metaspace: 975K(4864K)->975K(4864K) NonClass: 879K(4352K)->879K(4352K) Class: 95K(512K)->95K(512K)
         * [1.297s][info][gc             ] GC(107) Pause Full (Ergonomics) 2M->2M(3M) 8.657ms
         * [1.297s][info][gc,cpu         ] GC(107) User=0.00s Sys=0.00s Real=0.01s
         * [1.297s][info][gc,start       ] GC(108) Pause Full (Ergonomics)
         * [1.297s][info][gc,phases,start] GC(108) Marking Phase
         * [1.303s][info][gc,phases      ] GC(108) Marking Phase 5.902ms
         * [1.303s][info][gc,phases,start] GC(108) Summary Phase
         * [1.303s][info][gc,phases      ] GC(108) Summary Phase 0.016ms
         * [1.303s][info][gc,phases,start] GC(108) Adjust Roots
         * [1.304s][info][gc,phases      ] GC(108) Adjust Roots 0.902ms
         * [1.304s][info][gc,phases,start] GC(108) Compaction Phase
         * [1.307s][info][gc,phases      ] GC(108) Compaction Phase 2.787ms
         * [1.307s][info][gc,phases,start] GC(108) Post Compact
         * [1.307s][info][gc,phases      ] GC(108) Post Compact 0.027ms
         * [1.307s][info][gc,heap        ] GC(108) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.307s][info][gc,heap        ] GC(108) ParOldGen: 2441K(2560K)->2441K(2560K)
         * [1.307s][info][gc,metaspace   ] GC(108) Metaspace: 975K(4864K)->975K(4864K) NonClass: 880K(4352K)->880K(4352K) Class: 95K(512K)->95K(512K)
         * [1.307s][info][gc             ] GC(108) Pause Full (Ergonomics) 2M->2M(3M) 9.902ms
         * [1.307s][info][gc,cpu         ] GC(108) User=0.03s Sys=0.00s Real=0.01s
         * [1.308s][info][gc,start       ] GC(109) Pause Full (Ergonomics)
         * [1.308s][info][gc,phases,start] GC(109) Marking Phase
         * [1.313s][info][gc,phases      ] GC(109) Marking Phase 5.293ms
         * [1.313s][info][gc,phases,start] GC(109) Summary Phase
         * [1.313s][info][gc,phases      ] GC(109) Summary Phase 0.017ms
         * [1.313s][info][gc,phases,start] GC(109) Adjust Roots
         * [1.314s][info][gc,phases      ] GC(109) Adjust Roots 0.811ms
         * [1.314s][info][gc,phases,start] GC(109) Compaction Phase
         * [1.317s][info][gc,phases      ] GC(109) Compaction Phase 2.716ms
         * [1.317s][info][gc,phases,start] GC(109) Post Compact
         * [1.317s][info][gc,phases      ] GC(109) Post Compact 0.037ms
         * [1.317s][info][gc,heap        ] GC(109) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.317s][info][gc,heap        ] GC(109) ParOldGen: 2443K(2560K)->2443K(2560K)
         * [1.317s][info][gc,metaspace   ] GC(109) Metaspace: 976K(4864K)->976K(4864K) NonClass: 881K(4352K)->881K(4352K) Class: 95K(512K)->95K(512K)
         * [1.317s][info][gc             ] GC(109) Pause Full (Ergonomics) 2M->2M(3M) 9.196ms
         * [1.317s][info][gc,cpu         ] GC(109) User=0.03s Sys=0.00s Real=0.01s
         * [1.317s][info][gc,start       ] GC(110) Pause Full (Ergonomics)
         * [1.317s][info][gc,phases,start] GC(110) Marking Phase
         * [1.322s][info][gc,phases      ] GC(110) Marking Phase 4.599ms
         * [1.322s][info][gc,phases,start] GC(110) Summary Phase
         * [1.322s][info][gc,phases      ] GC(110) Summary Phase 0.019ms
         * [1.322s][info][gc,phases,start] GC(110) Adjust Roots
         * [1.323s][info][gc,phases      ] GC(110) Adjust Roots 0.861ms
         * [1.323s][info][gc,phases,start] GC(110) Compaction Phase
         * [1.325s][info][gc,phases      ] GC(110) Compaction Phase 1.955ms
         * [1.325s][info][gc,phases,start] GC(110) Post Compact
         * [1.325s][info][gc,phases      ] GC(110) Post Compact 0.027ms
         * [1.325s][info][gc,heap        ] GC(110) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.325s][info][gc,heap        ] GC(110) ParOldGen: 2445K(2560K)->2445K(2560K)
         * [1.325s][info][gc,metaspace   ] GC(110) Metaspace: 976K(4864K)->976K(4864K) NonClass: 881K(4352K)->881K(4352K) Class: 95K(512K)->95K(512K)
         * [1.325s][info][gc             ] GC(110) Pause Full (Ergonomics) 2M->2M(3M) 7.712ms
         * [1.325s][info][gc,cpu         ] GC(110) User=0.00s Sys=0.00s Real=0.01s
         * [1.325s][info][gc,start       ] GC(111) Pause Full (Ergonomics)
         * [1.325s][info][gc,phases,start] GC(111) Marking Phase
         * [1.331s][info][gc,phases      ] GC(111) Marking Phase 5.937ms
         * [1.331s][info][gc,phases,start] GC(111) Summary Phase
         * [1.331s][info][gc,phases      ] GC(111) Summary Phase 0.014ms
         * [1.331s][info][gc,phases,start] GC(111) Adjust Roots
         * [1.332s][info][gc,phases      ] GC(111) Adjust Roots 0.841ms
         * [1.332s][info][gc,phases,start] GC(111) Compaction Phase
         * [1.334s][info][gc,phases      ] GC(111) Compaction Phase 2.285ms
         * [1.334s][info][gc,phases,start] GC(111) Post Compact
         * [1.334s][info][gc,phases      ] GC(111) Post Compact 0.026ms
         * [1.335s][info][gc,heap        ] GC(111) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.335s][info][gc,heap        ] GC(111) ParOldGen: 2446K(2560K)->2446K(2560K)
         * [1.335s][info][gc,metaspace   ] GC(111) Metaspace: 976K(4864K)->976K(4864K) NonClass: 881K(4352K)->881K(4352K) Class: 95K(512K)->95K(512K)
         * [1.335s][info][gc             ] GC(111) Pause Full (Ergonomics) 2M->2M(3M) 9.347ms
         * [1.335s][info][gc,cpu         ] GC(111) User=0.02s Sys=0.00s Real=0.01s
         * [1.335s][info][gc,start       ] GC(112) Pause Full (Ergonomics)
         * [1.335s][info][gc,phases,start] GC(112) Marking Phase
         * [1.339s][info][gc,phases      ] GC(112) Marking Phase 4.520ms
         * [1.339s][info][gc,phases,start] GC(112) Summary Phase
         * [1.339s][info][gc,phases      ] GC(112) Summary Phase 0.018ms
         * [1.340s][info][gc,phases,start] GC(112) Adjust Roots
         * [1.340s][info][gc,phases      ] GC(112) Adjust Roots 0.848ms
         * [1.340s][info][gc,phases,start] GC(112) Compaction Phase
         * [1.342s][info][gc,phases      ] GC(112) Compaction Phase 2.092ms
         * [1.343s][info][gc,phases,start] GC(112) Post Compact
         * [1.343s][info][gc,phases      ] GC(112) Post Compact 0.025ms
         * [1.343s][info][gc,heap        ] GC(112) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.343s][info][gc,heap        ] GC(112) ParOldGen: 2448K(2560K)->2448K(2560K)
         * [1.343s][info][gc,metaspace   ] GC(112) Metaspace: 978K(4864K)->978K(4864K) NonClass: 883K(4352K)->883K(4352K) Class: 95K(512K)->95K(512K)
         * [1.343s][info][gc             ] GC(112) Pause Full (Ergonomics) 2M->2M(3M) 7.735ms
         * [1.343s][info][gc,cpu         ] GC(112) User=0.00s Sys=0.00s Real=0.01s
         * [1.343s][info][gc,start       ] GC(113) Pause Full (Ergonomics)
         * [1.343s][info][gc,phases,start] GC(113) Marking Phase
         * [1.349s][info][gc,phases      ] GC(113) Marking Phase 5.835ms
         * [1.349s][info][gc,phases,start] GC(113) Summary Phase
         * [1.349s][info][gc,phases      ] GC(113) Summary Phase 0.018ms
         * [1.349s][info][gc,phases,start] GC(113) Adjust Roots
         * [1.351s][info][gc,phases      ] GC(113) Adjust Roots 2.294ms
         * [1.351s][info][gc,phases,start] GC(113) Compaction Phase
         * [1.357s][info][gc,phases      ] GC(113) Compaction Phase 5.667ms
         * [1.357s][info][gc,phases,start] GC(113) Post Compact
         * [1.357s][info][gc,phases      ] GC(113) Post Compact 0.029ms
         * [1.357s][info][gc,heap        ] GC(113) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.357s][info][gc,heap        ] GC(113) ParOldGen: 2450K(2560K)->2442K(2560K)
         * [1.357s][info][gc,metaspace   ] GC(113) Metaspace: 978K(4864K)->978K(4864K) NonClass: 883K(4352K)->883K(4352K) Class: 95K(512K)->95K(512K)
         * [1.357s][info][gc             ] GC(113) Pause Full (Ergonomics) 2M->2M(3M) 14.132ms
         * [1.357s][info][gc,cpu         ] GC(113) User=0.03s Sys=0.00s Real=0.01s
         * [1.358s][info][gc,start       ] GC(114) Pause Full (Ergonomics)
         * [1.358s][info][gc,phases,start] GC(114) Marking Phase
         * [1.366s][info][gc,phases      ] GC(114) Marking Phase 8.474ms
         * [1.366s][info][gc,phases,start] GC(114) Summary Phase
         * [1.366s][info][gc,phases      ] GC(114) Summary Phase 0.017ms
         * [1.366s][info][gc,phases,start] GC(114) Adjust Roots
         * [1.367s][info][gc,phases      ] GC(114) Adjust Roots 1.131ms
         * [1.367s][info][gc,phases,start] GC(114) Compaction Phase
         * [1.370s][info][gc,phases      ] GC(114) Compaction Phase 2.315ms
         * [1.370s][info][gc,phases,start] GC(114) Post Compact
         * [1.370s][info][gc,phases      ] GC(114) Post Compact 0.032ms
         * [1.370s][info][gc,heap        ] GC(114) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.370s][info][gc,heap        ] GC(114) ParOldGen: 2444K(2560K)->2444K(2560K)
         * [1.370s][info][gc,metaspace   ] GC(114) Metaspace: 978K(4864K)->978K(4864K) NonClass: 883K(4352K)->883K(4352K) Class: 95K(512K)->95K(512K)
         * [1.370s][info][gc             ] GC(114) Pause Full (Ergonomics) 2M->2M(3M) 12.313ms
         * [1.370s][info][gc,cpu         ] GC(114) User=0.03s Sys=0.00s Real=0.01s
         * [1.370s][info][gc,start       ] GC(115) Pause Full (Ergonomics)
         * [1.370s][info][gc,phases,start] GC(115) Marking Phase
         * [1.375s][info][gc,phases      ] GC(115) Marking Phase 4.773ms
         * [1.375s][info][gc,phases,start] GC(115) Summary Phase
         * [1.375s][info][gc,phases      ] GC(115) Summary Phase 0.021ms
         * [1.375s][info][gc,phases,start] GC(115) Adjust Roots
         * [1.376s][info][gc,phases      ] GC(115) Adjust Roots 0.850ms
         * [1.376s][info][gc,phases,start] GC(115) Compaction Phase
         * [1.378s][info][gc,phases      ] GC(115) Compaction Phase 2.302ms
         * [1.378s][info][gc,phases,start] GC(115) Post Compact
         * [1.378s][info][gc,phases      ] GC(115) Post Compact 0.030ms
         * [1.378s][info][gc,heap        ] GC(115) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.378s][info][gc,heap        ] GC(115) ParOldGen: 2445K(2560K)->2445K(2560K)
         * [1.378s][info][gc,metaspace   ] GC(115) Metaspace: 978K(4864K)->978K(4864K) NonClass: 883K(4352K)->883K(4352K) Class: 95K(512K)->95K(512K)
         * [1.379s][info][gc             ] GC(115) Pause Full (Ergonomics) 2M->2M(3M) 8.267ms
         * [1.379s][info][gc,cpu         ] GC(115) User=0.02s Sys=0.00s Real=0.01s
         * [1.380s][info][gc,start       ] GC(116) Pause Full (Ergonomics)
         * [1.380s][info][gc,phases,start] GC(116) Marking Phase
         * [1.386s][info][gc,phases      ] GC(116) Marking Phase 5.627ms
         * [1.386s][info][gc,phases,start] GC(116) Summary Phase
         * [1.386s][info][gc,phases      ] GC(116) Summary Phase 0.013ms
         * [1.386s][info][gc,phases,start] GC(116) Adjust Roots
         * [1.387s][info][gc,phases      ] GC(116) Adjust Roots 0.818ms
         * [1.387s][info][gc,phases,start] GC(116) Compaction Phase
         * [1.389s][info][gc,phases      ] GC(116) Compaction Phase 2.198ms
         * [1.389s][info][gc,phases,start] GC(116) Post Compact
         * [1.389s][info][gc,phases      ] GC(116) Post Compact 0.029ms
         * [1.389s][info][gc,heap        ] GC(116) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.389s][info][gc,heap        ] GC(116) ParOldGen: 2447K(2560K)->2447K(2560K)
         * [1.389s][info][gc,metaspace   ] GC(116) Metaspace: 980K(4864K)->980K(4864K) NonClass: 884K(4352K)->884K(4352K) Class: 95K(512K)->95K(512K)
         * [1.389s][info][gc             ] GC(116) Pause Full (Ergonomics) 2M->2M(3M) 8.973ms
         * [1.389s][info][gc,cpu         ] GC(116) User=0.00s Sys=0.00s Real=0.01s
         * [1.391s][info][gc,start       ] GC(117) Pause Full (Ergonomics)
         * [1.391s][info][gc,phases,start] GC(117) Marking Phase
         * [1.396s][info][gc,phases      ] GC(117) Marking Phase 5.081ms
         * [1.396s][info][gc,phases,start] GC(117) Summary Phase
         * [1.396s][info][gc,phases      ] GC(117) Summary Phase 0.016ms
         * [1.396s][info][gc,phases,start] GC(117) Adjust Roots
         * [1.398s][info][gc,phases      ] GC(117) Adjust Roots 1.881ms
         * [1.398s][info][gc,phases,start] GC(117) Compaction Phase
         * [1.403s][info][gc,phases      ] GC(117) Compaction Phase 4.846ms
         * [1.403s][info][gc,phases,start] GC(117) Post Compact
         * [1.403s][info][gc,phases      ] GC(117) Post Compact 0.031ms
         * [1.403s][info][gc,heap        ] GC(117) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.403s][info][gc,heap        ] GC(117) ParOldGen: 2448K(2560K)->2448K(2560K)
         * [1.403s][info][gc,metaspace   ] GC(117) Metaspace: 981K(4864K)->981K(4864K) NonClass: 885K(4352K)->885K(4352K) Class: 95K(512K)->95K(512K)
         * [1.403s][info][gc             ] GC(117) Pause Full (Ergonomics) 2M->2M(3M) 12.156ms
         * [1.403s][info][gc,cpu         ] GC(117) User=0.03s Sys=0.00s Real=0.01s
         * [1.403s][info][gc,start       ] GC(118) Pause Full (Ergonomics)
         * [1.403s][info][gc,phases,start] GC(118) Marking Phase
         * [1.408s][info][gc,phases      ] GC(118) Marking Phase 4.573ms
         * [1.408s][info][gc,phases,start] GC(118) Summary Phase
         * [1.408s][info][gc,phases      ] GC(118) Summary Phase 0.014ms
         * [1.408s][info][gc,phases,start] GC(118) Adjust Roots
         * [1.409s][info][gc,phases      ] GC(118) Adjust Roots 0.850ms
         * [1.409s][info][gc,phases,start] GC(118) Compaction Phase
         * [1.411s][info][gc,phases      ] GC(118) Compaction Phase 2.158ms
         * [1.411s][info][gc,phases,start] GC(118) Post Compact
         * [1.411s][info][gc,phases      ] GC(118) Post Compact 0.025ms
         * [1.411s][info][gc,heap        ] GC(118) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.411s][info][gc,heap        ] GC(118) ParOldGen: 2450K(2560K)->2450K(2560K)
         * [1.411s][info][gc,metaspace   ] GC(118) Metaspace: 981K(4864K)->981K(4864K) NonClass: 885K(4352K)->885K(4352K) Class: 95K(512K)->95K(512K)
         * [1.411s][info][gc             ] GC(118) Pause Full (Ergonomics) 2M->2M(3M) 7.876ms
         * [1.411s][info][gc,cpu         ] GC(118) User=0.03s Sys=0.00s Real=0.01s
         * [1.411s][info][gc,start       ] GC(119) Pause Full (Ergonomics)
         * [1.412s][info][gc,phases,start] GC(119) Marking Phase
         * [1.417s][info][gc,phases      ] GC(119) Marking Phase 5.508ms
         * [1.417s][info][gc,phases,start] GC(119) Summary Phase
         * [1.417s][info][gc,phases      ] GC(119) Summary Phase 0.018ms
         * [1.417s][info][gc,phases,start] GC(119) Adjust Roots
         * [1.418s][info][gc,phases      ] GC(119) Adjust Roots 0.700ms
         * [1.418s][info][gc,phases,start] GC(119) Compaction Phase
         * [1.420s][info][gc,phases      ] GC(119) Compaction Phase 2.311ms
         * [1.420s][info][gc,phases,start] GC(119) Post Compact
         * [1.420s][info][gc,phases      ] GC(119) Post Compact 0.024ms
         * [1.420s][info][gc,heap        ] GC(119) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.420s][info][gc,heap        ] GC(119) ParOldGen: 2451K(2560K)->2451K(2560K)
         * [1.420s][info][gc,metaspace   ] GC(119) Metaspace: 981K(4864K)->981K(4864K) NonClass: 885K(4352K)->885K(4352K) Class: 95K(512K)->95K(512K)
         * [1.420s][info][gc             ] GC(119) Pause Full (Ergonomics) 2M->2M(3M) 8.783ms
         * [1.420s][info][gc,cpu         ] GC(119) User=0.00s Sys=0.00s Real=0.01s
         * [1.421s][info][gc,start       ] GC(120) Pause Full (Ergonomics)
         * [1.421s][info][gc,phases,start] GC(120) Marking Phase
         * [1.426s][info][gc,phases      ] GC(120) Marking Phase 4.780ms
         * [1.426s][info][gc,phases,start] GC(120) Summary Phase
         * [1.426s][info][gc,phases      ] GC(120) Summary Phase 0.016ms
         * [1.426s][info][gc,phases,start] GC(120) Adjust Roots
         * [1.427s][info][gc,phases      ] GC(120) Adjust Roots 0.873ms
         * [1.427s][info][gc,phases,start] GC(120) Compaction Phase
         * [1.429s][info][gc,phases      ] GC(120) Compaction Phase 2.155ms
         * [1.429s][info][gc,phases,start] GC(120) Post Compact
         * [1.429s][info][gc,phases      ] GC(120) Post Compact 0.028ms
         * [1.429s][info][gc,heap        ] GC(120) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.429s][info][gc,heap        ] GC(120) ParOldGen: 2453K(2560K)->2453K(2560K)
         * [1.429s][info][gc,metaspace   ] GC(120) Metaspace: 981K(4864K)->981K(4864K) NonClass: 886K(4352K)->886K(4352K) Class: 95K(512K)->95K(512K)
         * [1.429s][info][gc             ] GC(120) Pause Full (Ergonomics) 2M->2M(3M) 8.091ms
         * [1.429s][info][gc,cpu         ] GC(120) User=0.03s Sys=0.00s Real=0.01s
         * [1.430s][info][gc,start       ] GC(121) Pause Full (Ergonomics)
         * [1.430s][info][gc,phases,start] GC(121) Marking Phase
         * [1.436s][info][gc,phases      ] GC(121) Marking Phase 6.134ms
         * [1.436s][info][gc,phases,start] GC(121) Summary Phase
         * [1.436s][info][gc,phases      ] GC(121) Summary Phase 0.015ms
         * [1.436s][info][gc,phases,start] GC(121) Adjust Roots
         * [1.437s][info][gc,phases      ] GC(121) Adjust Roots 0.880ms
         * [1.437s][info][gc,phases,start] GC(121) Compaction Phase
         * [1.440s][info][gc,phases      ] GC(121) Compaction Phase 2.442ms
         * [1.440s][info][gc,phases,start] GC(121) Post Compact
         * [1.440s][info][gc,phases      ] GC(121) Post Compact 0.030ms
         * [1.440s][info][gc,heap        ] GC(121) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.440s][info][gc,heap        ] GC(121) ParOldGen: 2455K(2560K)->2455K(2560K)
         * [1.440s][info][gc,metaspace   ] GC(121) Metaspace: 983K(4864K)->983K(4864K) NonClass: 888K(4352K)->888K(4352K) Class: 95K(512K)->95K(512K)
         * [1.440s][info][gc             ] GC(121) Pause Full (Ergonomics) 2M->2M(3M) 9.772ms
         * [1.440s][info][gc,cpu         ] GC(121) User=0.00s Sys=0.00s Real=0.01s
         * [1.440s][info][gc,start       ] GC(122) Pause Full (Ergonomics)
         * [1.440s][info][gc,phases,start] GC(122) Marking Phase
         * [1.445s][info][gc,phases      ] GC(122) Marking Phase 4.963ms
         * [1.445s][info][gc,phases,start] GC(122) Summary Phase
         * [1.445s][info][gc,phases      ] GC(122) Summary Phase 0.016ms
         * [1.445s][info][gc,phases,start] GC(122) Adjust Roots
         * [1.446s][info][gc,phases      ] GC(122) Adjust Roots 0.961ms
         * [1.446s][info][gc,phases,start] GC(122) Compaction Phase
         * [1.449s][info][gc,phases      ] GC(122) Compaction Phase 2.529ms
         * [1.449s][info][gc,phases,start] GC(122) Post Compact
         * [1.449s][info][gc,phases      ] GC(122) Post Compact 0.035ms
         * [1.449s][info][gc,heap        ] GC(122) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.449s][info][gc,heap        ] GC(122) ParOldGen: 2456K(2560K)->2456K(2560K)
         * [1.449s][info][gc,metaspace   ] GC(122) Metaspace: 983K(4864K)->983K(4864K) NonClass: 888K(4352K)->888K(4352K) Class: 95K(512K)->95K(512K)
         * [1.449s][info][gc             ] GC(122) Pause Full (Ergonomics) 2M->2M(3M) 8.826ms
         * [1.449s][info][gc,cpu         ] GC(122) User=0.03s Sys=0.00s Real=0.01s
         * [1.450s][info][gc,start       ] GC(123) Pause Full (Ergonomics)
         * [1.450s][info][gc,phases,start] GC(123) Marking Phase
         * [1.455s][info][gc,phases      ] GC(123) Marking Phase 5.241ms
         * [1.455s][info][gc,phases,start] GC(123) Summary Phase
         * [1.455s][info][gc,phases      ] GC(123) Summary Phase 0.018ms
         * [1.455s][info][gc,phases,start] GC(123) Adjust Roots
         * [1.456s][info][gc,phases      ] GC(123) Adjust Roots 0.721ms
         * [1.456s][info][gc,phases,start] GC(123) Compaction Phase
         * [1.457s][info][gc,phases      ] GC(123) Compaction Phase 1.609ms
         * [1.457s][info][gc,phases,start] GC(123) Post Compact
         * [1.457s][info][gc,phases      ] GC(123) Post Compact 0.018ms
         * [1.457s][info][gc,heap        ] GC(123) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.457s][info][gc,heap        ] GC(123) ParOldGen: 2458K(2560K)->2458K(2560K)
         * [1.457s][info][gc,metaspace   ] GC(123) Metaspace: 983K(4864K)->983K(4864K) NonClass: 888K(4352K)->888K(4352K) Class: 95K(512K)->95K(512K)
         * [1.457s][info][gc             ] GC(123) Pause Full (Ergonomics) 2M->2M(3M) 7.809ms
         * [1.457s][info][gc,cpu         ] GC(123) User=0.03s Sys=0.00s Real=0.01s
         * [1.458s][info][gc,start       ] GC(124) Pause Full (Ergonomics)
         * [1.458s][info][gc,phases,start] GC(124) Marking Phase
         * [1.462s][info][gc,phases      ] GC(124) Marking Phase 4.735ms
         * [1.462s][info][gc,phases,start] GC(124) Summary Phase
         * [1.462s][info][gc,phases      ] GC(124) Summary Phase 0.016ms
         * [1.462s][info][gc,phases,start] GC(124) Adjust Roots
         * [1.463s][info][gc,phases      ] GC(124) Adjust Roots 0.865ms
         * [1.463s][info][gc,phases,start] GC(124) Compaction Phase
         * [1.465s][info][gc,phases      ] GC(124) Compaction Phase 2.208ms
         * [1.466s][info][gc,phases,start] GC(124) Post Compact
         * [1.466s][info][gc,phases      ] GC(124) Post Compact 0.028ms
         * [1.466s][info][gc,heap        ] GC(124) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.466s][info][gc,heap        ] GC(124) ParOldGen: 2459K(2560K)->2459K(2560K)
         * [1.466s][info][gc,metaspace   ] GC(124) Metaspace: 983K(4864K)->983K(4864K) NonClass: 888K(4352K)->888K(4352K) Class: 95K(512K)->95K(512K)
         * [1.466s][info][gc             ] GC(124) Pause Full (Ergonomics) 2M->2M(3M) 8.094ms
         * [1.466s][info][gc,cpu         ] GC(124) User=0.00s Sys=0.00s Real=0.01s
         * [1.466s][info][gc,start       ] GC(125) Pause Full (Ergonomics)
         * [1.466s][info][gc,phases,start] GC(125) Marking Phase
         * [1.472s][info][gc,phases      ] GC(125) Marking Phase 5.626ms
         * [1.472s][info][gc,phases,start] GC(125) Summary Phase
         * [1.472s][info][gc,phases      ] GC(125) Summary Phase 0.015ms
         * [1.472s][info][gc,phases,start] GC(125) Adjust Roots
         * [1.473s][info][gc,phases      ] GC(125) Adjust Roots 0.905ms
         * [1.473s][info][gc,phases,start] GC(125) Compaction Phase
         * [1.475s][info][gc,phases      ] GC(125) Compaction Phase 1.995ms
         * [1.475s][info][gc,phases,start] GC(125) Post Compact
         * [1.475s][info][gc,phases      ] GC(125) Post Compact 0.027ms
         * [1.475s][info][gc,heap        ] GC(125) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.475s][info][gc,heap        ] GC(125) ParOldGen: 2461K(2560K)->2461K(2560K)
         * [1.475s][info][gc,metaspace   ] GC(125) Metaspace: 983K(4864K)->983K(4864K) NonClass: 888K(4352K)->888K(4352K) Class: 95K(512K)->95K(512K)
         * [1.475s][info][gc             ] GC(125) Pause Full (Ergonomics) 2M->2M(3M) 8.805ms
         * [1.475s][info][gc,cpu         ] GC(125) User=0.02s Sys=0.00s Real=0.01s
         * [1.475s][info][gc,start       ] GC(126) Pause Full (Ergonomics)
         * [1.475s][info][gc,phases,start] GC(126) Marking Phase
         * [1.481s][info][gc,phases      ] GC(126) Marking Phase 5.624ms
         * [1.481s][info][gc,phases,start] GC(126) Summary Phase
         * [1.481s][info][gc,phases      ] GC(126) Summary Phase 0.016ms
         * [1.481s][info][gc,phases,start] GC(126) Adjust Roots
         * [1.482s][info][gc,phases      ] GC(126) Adjust Roots 0.953ms
         * [1.482s][info][gc,phases,start] GC(126) Compaction Phase
         * [1.484s][info][gc,phases      ] GC(126) Compaction Phase 2.234ms
         * [1.484s][info][gc,phases,start] GC(126) Post Compact
         * [1.484s][info][gc,phases      ] GC(126) Post Compact 0.032ms
         * [1.484s][info][gc,heap        ] GC(126) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.484s][info][gc,heap        ] GC(126) ParOldGen: 2463K(2560K)->2463K(2560K)
         * [1.484s][info][gc,metaspace   ] GC(126) Metaspace: 983K(4864K)->983K(4864K) NonClass: 888K(4352K)->888K(4352K) Class: 95K(512K)->95K(512K)
         * [1.484s][info][gc             ] GC(126) Pause Full (Ergonomics) 2M->2M(3M) 9.144ms
         * [1.484s][info][gc,cpu         ] GC(126) User=0.00s Sys=0.00s Real=0.01s
         * [1.485s][info][gc,start       ] GC(127) Pause Full (Ergonomics)
         * [1.485s][info][gc,phases,start] GC(127) Marking Phase
         * [1.490s][info][gc,phases      ] GC(127) Marking Phase 5.663ms
         * [1.491s][info][gc,phases,start] GC(127) Summary Phase
         * [1.491s][info][gc,phases      ] GC(127) Summary Phase 0.017ms
         * [1.491s][info][gc,phases,start] GC(127) Adjust Roots
         * [1.491s][info][gc,phases      ] GC(127) Adjust Roots 0.868ms
         * [1.491s][info][gc,phases,start] GC(127) Compaction Phase
         * [1.493s][info][gc,phases      ] GC(127) Compaction Phase 1.943ms
         * [1.493s][info][gc,phases,start] GC(127) Post Compact
         * [1.493s][info][gc,phases      ] GC(127) Post Compact 0.029ms
         * [1.494s][info][gc,heap        ] GC(127) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.494s][info][gc,heap        ] GC(127) ParOldGen: 2464K(2560K)->2464K(2560K)
         * [1.494s][info][gc,metaspace   ] GC(127) Metaspace: 983K(4864K)->983K(4864K) NonClass: 888K(4352K)->888K(4352K) Class: 95K(512K)->95K(512K)
         * [1.494s][info][gc             ] GC(127) Pause Full (Ergonomics) 2M->2M(3M) 8.790ms
         * [1.494s][info][gc,cpu         ] GC(127) User=0.03s Sys=0.00s Real=0.01s
         * [1.494s][info][gc,start       ] GC(128) Pause Full (Ergonomics)
         * [1.494s][info][gc,phases,start] GC(128) Marking Phase
         * [1.499s][info][gc,phases      ] GC(128) Marking Phase 4.932ms
         * [1.499s][info][gc,phases,start] GC(128) Summary Phase
         * [1.499s][info][gc,phases      ] GC(128) Summary Phase 0.021ms
         * [1.499s][info][gc,phases,start] GC(128) Adjust Roots
         * [1.501s][info][gc,phases      ] GC(128) Adjust Roots 1.801ms
         * [1.501s][info][gc,phases,start] GC(128) Compaction Phase
         * [1.503s][info][gc,phases      ] GC(128) Compaction Phase 2.172ms
         * [1.503s][info][gc,phases,start] GC(128) Post Compact
         * [1.503s][info][gc,phases      ] GC(128) Post Compact 0.032ms
         * [1.503s][info][gc,heap        ] GC(128) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.503s][info][gc,heap        ] GC(128) ParOldGen: 2466K(2560K)->2466K(2560K)
         * [1.503s][info][gc,metaspace   ] GC(128) Metaspace: 983K(4864K)->983K(4864K) NonClass: 888K(4352K)->888K(4352K) Class: 95K(512K)->95K(512K)
         * [1.503s][info][gc             ] GC(128) Pause Full (Ergonomics) 2M->2M(3M) 9.276ms
         * [1.503s][info][gc,cpu         ] GC(128) User=0.02s Sys=0.00s Real=0.01s
         * [1.503s][info][gc,start       ] GC(129) Pause Full (Ergonomics)
         * [1.504s][info][gc,phases,start] GC(129) Marking Phase
         * [1.509s][info][gc,phases      ] GC(129) Marking Phase 5.152ms
         * [1.509s][info][gc,phases,start] GC(129) Summary Phase
         * [1.509s][info][gc,phases      ] GC(129) Summary Phase 0.017ms
         * [1.509s][info][gc,phases,start] GC(129) Adjust Roots
         * [1.510s][info][gc,phases      ] GC(129) Adjust Roots 0.857ms
         * [1.510s][info][gc,phases,start] GC(129) Compaction Phase
         * [1.512s][info][gc,phases      ] GC(129) Compaction Phase 2.150ms
         * [1.512s][info][gc,phases,start] GC(129) Post Compact
         * [1.512s][info][gc,phases      ] GC(129) Post Compact 0.025ms
         * [1.512s][info][gc,heap        ] GC(129) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.512s][info][gc,heap        ] GC(129) ParOldGen: 2468K(2560K)->2468K(2560K)
         * [1.512s][info][gc,metaspace   ] GC(129) Metaspace: 984K(4864K)->984K(4864K) NonClass: 888K(4352K)->888K(4352K) Class: 95K(512K)->95K(512K)
         * [1.512s][info][gc             ] GC(129) Pause Full (Ergonomics) 2M->2M(3M) 8.448ms
         * [1.512s][info][gc,cpu         ] GC(129) User=0.00s Sys=0.00s Real=0.01s
         * [1.512s][info][gc,start       ] GC(130) Pause Full (Ergonomics)
         * [1.512s][info][gc,phases,start] GC(130) Marking Phase
         * [1.518s][info][gc,phases      ] GC(130) Marking Phase 5.264ms
         * [1.518s][info][gc,phases,start] GC(130) Summary Phase
         * [1.518s][info][gc,phases      ] GC(130) Summary Phase 0.017ms
         * [1.518s][info][gc,phases,start] GC(130) Adjust Roots
         * [1.519s][info][gc,phases      ] GC(130) Adjust Roots 0.870ms
         * [1.519s][info][gc,phases,start] GC(130) Compaction Phase
         * [1.521s][info][gc,phases      ] GC(130) Compaction Phase 2.047ms
         * [1.521s][info][gc,phases,start] GC(130) Post Compact
         * [1.521s][info][gc,phases      ] GC(130) Post Compact 0.030ms
         * [1.521s][info][gc,heap        ] GC(130) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.521s][info][gc,heap        ] GC(130) ParOldGen: 2469K(2560K)->2469K(2560K)
         * [1.521s][info][gc,metaspace   ] GC(130) Metaspace: 984K(4864K)->984K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.521s][info][gc             ] GC(130) Pause Full (Ergonomics) 2M->2M(3M) 8.516ms
         * [1.521s][info][gc,cpu         ] GC(130) User=0.03s Sys=0.00s Real=0.01s
         * [1.521s][info][gc,start       ] GC(131) Pause Full (Ergonomics)
         * [1.521s][info][gc,phases,start] GC(131) Marking Phase
         * [1.527s][info][gc,phases      ] GC(131) Marking Phase 5.566ms
         * [1.527s][info][gc,phases,start] GC(131) Summary Phase
         * [1.527s][info][gc,phases      ] GC(131) Summary Phase 0.020ms
         * [1.527s][info][gc,phases,start] GC(131) Adjust Roots
         * [1.528s][info][gc,phases      ] GC(131) Adjust Roots 0.930ms
         * [1.528s][info][gc,phases,start] GC(131) Compaction Phase
         * [1.530s][info][gc,phases      ] GC(131) Compaction Phase 2.164ms
         * [1.530s][info][gc,phases,start] GC(131) Post Compact
         * [1.530s][info][gc,phases      ] GC(131) Post Compact 0.025ms
         * [1.530s][info][gc,heap        ] GC(131) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.530s][info][gc,heap        ] GC(131) ParOldGen: 2471K(2560K)->2471K(2560K)
         * [1.530s][info][gc,metaspace   ] GC(131) Metaspace: 984K(4864K)->984K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.530s][info][gc             ] GC(131) Pause Full (Ergonomics) 2M->2M(3M) 8.956ms
         * [1.530s][info][gc,cpu         ] GC(131) User=0.00s Sys=0.00s Real=0.01s
         * [1.531s][info][gc,start       ] GC(132) Pause Full (Ergonomics)
         * [1.531s][info][gc,phases,start] GC(132) Marking Phase
         * [1.537s][info][gc,phases      ] GC(132) Marking Phase 5.854ms
         * [1.537s][info][gc,phases,start] GC(132) Summary Phase
         * [1.537s][info][gc,phases      ] GC(132) Summary Phase 0.016ms
         * [1.537s][info][gc,phases,start] GC(132) Adjust Roots
         * [1.538s][info][gc,phases      ] GC(132) Adjust Roots 1.054ms
         * [1.538s][info][gc,phases,start] GC(132) Compaction Phase
         * [1.540s][info][gc,phases      ] GC(132) Compaction Phase 2.326ms
         * [1.540s][info][gc,phases,start] GC(132) Post Compact
         * [1.540s][info][gc,phases      ] GC(132) Post Compact 0.027ms
         * [1.540s][info][gc,heap        ] GC(132) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.540s][info][gc,heap        ] GC(132) ParOldGen: 2473K(2560K)->2473K(2560K)
         * [1.540s][info][gc,metaspace   ] GC(132) Metaspace: 984K(4864K)->984K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.540s][info][gc             ] GC(132) Pause Full (Ergonomics) 2M->2M(3M) 9.551ms
         * [1.540s][info][gc,cpu         ] GC(132) User=0.03s Sys=0.00s Real=0.01s
         * [1.540s][info][gc,start       ] GC(133) Pause Full (Ergonomics)
         * [1.540s][info][gc,phases,start] GC(133) Marking Phase
         * [1.546s][info][gc,phases      ] GC(133) Marking Phase 5.710ms
         * [1.546s][info][gc,phases,start] GC(133) Summary Phase
         * [1.546s][info][gc,phases      ] GC(133) Summary Phase 0.016ms
         * [1.546s][info][gc,phases,start] GC(133) Adjust Roots
         * [1.547s][info][gc,phases      ] GC(133) Adjust Roots 0.896ms
         * [1.547s][info][gc,phases,start] GC(133) Compaction Phase
         * [1.550s][info][gc,phases      ] GC(133) Compaction Phase 2.846ms
         * [1.550s][info][gc,phases,start] GC(133) Post Compact
         * [1.550s][info][gc,phases      ] GC(133) Post Compact 0.027ms
         * [1.550s][info][gc,heap        ] GC(133) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.550s][info][gc,heap        ] GC(133) ParOldGen: 2474K(2560K)->2474K(2560K)
         * [1.550s][info][gc,metaspace   ] GC(133) Metaspace: 984K(4864K)->984K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.550s][info][gc             ] GC(133) Pause Full (Ergonomics) 2M->2M(3M) 9.748ms
         * [1.550s][info][gc,cpu         ] GC(133) User=0.00s Sys=0.00s Real=0.01s
         * [1.550s][info][gc,start       ] GC(134) Pause Full (Ergonomics)
         * [1.551s][info][gc,phases,start] GC(134) Marking Phase
         * [1.556s][info][gc,phases      ] GC(134) Marking Phase 5.894ms
         * [1.556s][info][gc,phases,start] GC(134) Summary Phase
         * [1.556s][info][gc,phases      ] GC(134) Summary Phase 0.016ms
         * [1.556s][info][gc,phases,start] GC(134) Adjust Roots
         * [1.558s][info][gc,phases      ] GC(134) Adjust Roots 1.020ms
         * [1.558s][info][gc,phases,start] GC(134) Compaction Phase
         * [1.560s][info][gc,phases      ] GC(134) Compaction Phase 2.216ms
         * [1.560s][info][gc,phases,start] GC(134) Post Compact
         * [1.560s][info][gc,phases      ] GC(134) Post Compact 0.031ms
         * [1.560s][info][gc,heap        ] GC(134) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.560s][info][gc,heap        ] GC(134) ParOldGen: 2476K(2560K)->2476K(2560K)
         * [1.560s][info][gc,metaspace   ] GC(134) Metaspace: 984K(4864K)->984K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.560s][info][gc             ] GC(134) Pause Full (Ergonomics) 2M->2M(3M) 9.481ms
         * [1.560s][info][gc,cpu         ] GC(134) User=0.00s Sys=0.00s Real=0.01s
         * [1.560s][info][gc,start       ] GC(135) Pause Full (Ergonomics)
         * [1.560s][info][gc,phases,start] GC(135) Marking Phase
         * [1.566s][info][gc,phases      ] GC(135) Marking Phase 5.951ms
         * [1.566s][info][gc,phases,start] GC(135) Summary Phase
         * [1.566s][info][gc,phases      ] GC(135) Summary Phase 0.015ms
         * [1.566s][info][gc,phases,start] GC(135) Adjust Roots
         * [1.567s][info][gc,phases      ] GC(135) Adjust Roots 0.880ms
         * [1.567s][info][gc,phases,start] GC(135) Compaction Phase
         * [1.569s][info][gc,phases      ] GC(135) Compaction Phase 2.184ms
         * [1.569s][info][gc,phases,start] GC(135) Post Compact
         * [1.569s][info][gc,phases      ] GC(135) Post Compact 0.032ms
         * [1.569s][info][gc,heap        ] GC(135) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.570s][info][gc,heap        ] GC(135) ParOldGen: 2478K(2560K)->2478K(2560K)
         * [1.570s][info][gc,metaspace   ] GC(135) Metaspace: 984K(4864K)->984K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.570s][info][gc             ] GC(135) Pause Full (Ergonomics) 2M->2M(3M) 9.319ms
         * [1.570s][info][gc,cpu         ] GC(135) User=0.02s Sys=0.00s Real=0.01s
         * [1.570s][info][gc,start       ] GC(136) Pause Full (Ergonomics)
         * [1.570s][info][gc,phases,start] GC(136) Marking Phase
         * [1.576s][info][gc,phases      ] GC(136) Marking Phase 5.914ms
         * [1.576s][info][gc,phases,start] GC(136) Summary Phase
         * [1.576s][info][gc,phases      ] GC(136) Summary Phase 0.016ms
         * [1.576s][info][gc,phases,start] GC(136) Adjust Roots
         * [1.577s][info][gc,phases      ] GC(136) Adjust Roots 0.899ms
         * [1.577s][info][gc,phases,start] GC(136) Compaction Phase
         * [1.579s][info][gc,phases      ] GC(136) Compaction Phase 2.131ms
         * [1.579s][info][gc,phases,start] GC(136) Post Compact
         * [1.579s][info][gc,phases      ] GC(136) Post Compact 0.023ms
         * [1.579s][info][gc,heap        ] GC(136) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.579s][info][gc,heap        ] GC(136) ParOldGen: 2479K(2560K)->2479K(2560K)
         * [1.579s][info][gc,metaspace   ] GC(136) Metaspace: 984K(4864K)->984K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.579s][info][gc             ] GC(136) Pause Full (Ergonomics) 2M->2M(3M) 9.229ms
         * [1.579s][info][gc,cpu         ] GC(136) User=0.00s Sys=0.00s Real=0.01s
         * [1.579s][info][gc,start       ] GC(137) Pause Full (Ergonomics)
         * [1.579s][info][gc,phases,start] GC(137) Marking Phase
         * [1.584s][info][gc,phases      ] GC(137) Marking Phase 4.996ms
         * [1.584s][info][gc,phases,start] GC(137) Summary Phase
         * [1.584s][info][gc,phases      ] GC(137) Summary Phase 0.015ms
         * [1.584s][info][gc,phases,start] GC(137) Adjust Roots
         * [1.585s][info][gc,phases      ] GC(137) Adjust Roots 0.964ms
         * [1.585s][info][gc,phases,start] GC(137) Compaction Phase
         * [1.588s][info][gc,phases      ] GC(137) Compaction Phase 2.217ms
         * [1.588s][info][gc,phases,start] GC(137) Post Compact
         * [1.588s][info][gc,phases      ] GC(137) Post Compact 0.026ms
         * [1.588s][info][gc,heap        ] GC(137) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.588s][info][gc,heap        ] GC(137) ParOldGen: 2481K(2560K)->2481K(2560K)
         * [1.588s][info][gc,metaspace   ] GC(137) Metaspace: 984K(4864K)->984K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.588s][info][gc             ] GC(137) Pause Full (Ergonomics) 2M->2M(3M) 8.485ms
         * [1.588s][info][gc,cpu         ] GC(137) User=0.03s Sys=0.00s Real=0.01s
         * [1.588s][info][gc,start       ] GC(138) Pause Full (Ergonomics)
         * [1.588s][info][gc,phases,start] GC(138) Marking Phase
         * [1.593s][info][gc,phases      ] GC(138) Marking Phase 5.370ms
         * [1.594s][info][gc,phases,start] GC(138) Summary Phase
         * [1.594s][info][gc,phases      ] GC(138) Summary Phase 0.022ms
         * [1.594s][info][gc,phases,start] GC(138) Adjust Roots
         * [1.596s][info][gc,phases      ] GC(138) Adjust Roots 2.024ms
         * [1.596s][info][gc,phases,start] GC(138) Compaction Phase
         * [1.598s][info][gc,phases      ] GC(138) Compaction Phase 2.728ms
         * [1.598s][info][gc,phases,start] GC(138) Post Compact
         * [1.598s][info][gc,phases      ] GC(138) Post Compact 0.034ms
         * [1.599s][info][gc,heap        ] GC(138) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.599s][info][gc,heap        ] GC(138) ParOldGen: 2483K(2560K)->2483K(2560K)
         * [1.599s][info][gc,metaspace   ] GC(138) Metaspace: 984K(4864K)->984K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.599s][info][gc             ] GC(138) Pause Full (Ergonomics) 2M->2M(3M) 10.474ms
         * [1.599s][info][gc,cpu         ] GC(138) User=0.03s Sys=0.00s Real=0.01s
         * [1.599s][info][gc,start       ] GC(139) Pause Full (Ergonomics)
         * [1.599s][info][gc,phases,start] GC(139) Marking Phase
         * [1.604s][info][gc,phases      ] GC(139) Marking Phase 4.640ms
         * [1.604s][info][gc,phases,start] GC(139) Summary Phase
         * [1.604s][info][gc,phases      ] GC(139) Summary Phase 0.017ms
         * [1.604s][info][gc,phases,start] GC(139) Adjust Roots
         * [1.605s][info][gc,phases      ] GC(139) Adjust Roots 0.875ms
         * [1.605s][info][gc,phases,start] GC(139) Compaction Phase
         * [1.607s][info][gc,phases      ] GC(139) Compaction Phase 2.388ms
         * [1.607s][info][gc,phases,start] GC(139) Post Compact
         * [1.607s][info][gc,phases      ] GC(139) Post Compact 0.027ms
         * [1.607s][info][gc,heap        ] GC(139) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.607s][info][gc,heap        ] GC(139) ParOldGen: 2484K(2560K)->2484K(2560K)
         * [1.607s][info][gc,metaspace   ] GC(139) Metaspace: 984K(4864K)->984K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.607s][info][gc             ] GC(139) Pause Full (Ergonomics) 2M->2M(3M) 8.188ms
         * [1.607s][info][gc,cpu         ] GC(139) User=0.00s Sys=0.00s Real=0.01s
         * [1.607s][info][gc,start       ] GC(140) Pause Full (Ergonomics)
         * [1.607s][info][gc,phases,start] GC(140) Marking Phase
         * [1.612s][info][gc,phases      ] GC(140) Marking Phase 5.003ms
         * [1.612s][info][gc,phases,start] GC(140) Summary Phase
         * [1.612s][info][gc,phases      ] GC(140) Summary Phase 0.016ms
         * [1.612s][info][gc,phases,start] GC(140) Adjust Roots
         * [1.613s][info][gc,phases      ] GC(140) Adjust Roots 0.923ms
         * [1.613s][info][gc,phases,start] GC(140) Compaction Phase
         * [1.616s][info][gc,phases      ] GC(140) Compaction Phase 2.128ms
         * [1.616s][info][gc,phases,start] GC(140) Post Compact
         * [1.616s][info][gc,phases      ] GC(140) Post Compact 0.027ms
         * [1.616s][info][gc,heap        ] GC(140) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.616s][info][gc,heap        ] GC(140) ParOldGen: 2488K(2560K)->2488K(2560K)
         * [1.616s][info][gc,metaspace   ] GC(140) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.616s][info][gc             ] GC(140) Pause Full (Ergonomics) 2M->2M(3M) 8.348ms
         * [1.616s][info][gc,cpu         ] GC(140) User=0.02s Sys=0.00s Real=0.01s
         * [1.616s][info][gc,start       ] GC(141) Pause Full (Ergonomics)
         * [1.616s][info][gc,phases,start] GC(141) Marking Phase
         * [1.621s][info][gc,phases      ] GC(141) Marking Phase 4.912ms
         * [1.621s][info][gc,phases,start] GC(141) Summary Phase
         * [1.621s][info][gc,phases      ] GC(141) Summary Phase 0.015ms
         * [1.621s][info][gc,phases,start] GC(141) Adjust Roots
         * [1.622s][info][gc,phases      ] GC(141) Adjust Roots 0.935ms
         * [1.622s][info][gc,phases,start] GC(141) Compaction Phase
         * [1.624s][info][gc,phases      ] GC(141) Compaction Phase 1.600ms
         * [1.624s][info][gc,phases,start] GC(141) Post Compact
         * [1.624s][info][gc,phases      ] GC(141) Post Compact 0.017ms
         * [1.624s][info][gc,heap        ] GC(141) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.624s][info][gc,heap        ] GC(141) ParOldGen: 2495K(2560K)->2495K(2560K)
         * [1.624s][info][gc,metaspace   ] GC(141) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.624s][info][gc             ] GC(141) Pause Full (Ergonomics) 2M->2M(3M) 7.687ms
         * [1.624s][info][gc,cpu         ] GC(141) User=0.00s Sys=0.00s Real=0.01s
         * [1.624s][info][gc,start       ] GC(142) Pause Full (Ergonomics)
         * [1.624s][info][gc,phases,start] GC(142) Marking Phase
         * [1.629s][info][gc,phases      ] GC(142) Marking Phase 4.484ms
         * [1.629s][info][gc,phases,start] GC(142) Summary Phase
         * [1.629s][info][gc,phases      ] GC(142) Summary Phase 0.016ms
         * [1.629s][info][gc,phases,start] GC(142) Adjust Roots
         * [1.629s][info][gc,phases      ] GC(142) Adjust Roots 0.589ms
         * [1.629s][info][gc,phases,start] GC(142) Compaction Phase
         * [1.631s][info][gc,phases      ] GC(142) Compaction Phase 2.235ms
         * [1.632s][info][gc,phases,start] GC(142) Post Compact
         * [1.632s][info][gc,phases      ] GC(142) Post Compact 0.030ms
         * [1.632s][info][gc,heap        ] GC(142) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.632s][info][gc,heap        ] GC(142) ParOldGen: 2499K(2560K)->2499K(2560K)
         * [1.632s][info][gc,metaspace   ] GC(142) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.632s][info][gc             ] GC(142) Pause Full (Ergonomics) 2M->2M(3M) 7.580ms
         * [1.632s][info][gc,cpu         ] GC(142) User=0.03s Sys=0.00s Real=0.01s
         * [1.632s][info][gc,start       ] GC(143) Pause Full (Ergonomics)
         * [1.632s][info][gc,phases,start] GC(143) Marking Phase
         * [1.637s][info][gc,phases      ] GC(143) Marking Phase 4.905ms
         * [1.637s][info][gc,phases,start] GC(143) Summary Phase
         * [1.637s][info][gc,phases      ] GC(143) Summary Phase 0.016ms
         * [1.637s][info][gc,phases,start] GC(143) Adjust Roots
         * [1.638s][info][gc,phases      ] GC(143) Adjust Roots 0.900ms
         * [1.638s][info][gc,phases,start] GC(143) Compaction Phase
         * [1.640s][info][gc,phases      ] GC(143) Compaction Phase 2.154ms
         * [1.640s][info][gc,phases,start] GC(143) Post Compact
         * [1.640s][info][gc,phases      ] GC(143) Post Compact 0.024ms
         * [1.640s][info][gc,heap        ] GC(143) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.640s][info][gc,heap        ] GC(143) ParOldGen: 2503K(2560K)->2503K(2560K)
         * [1.640s][info][gc,metaspace   ] GC(143) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.640s][info][gc             ] GC(143) Pause Full (Ergonomics) 2M->2M(3M) 8.240ms
         * [1.640s][info][gc,cpu         ] GC(143) User=0.00s Sys=0.00s Real=0.01s
         * [1.641s][info][gc,start       ] GC(144) Pause Full (Ergonomics)
         * [1.641s][info][gc,phases,start] GC(144) Marking Phase
         * [1.645s][info][gc,phases      ] GC(144) Marking Phase 4.525ms
         * [1.645s][info][gc,phases,start] GC(144) Summary Phase
         * [1.645s][info][gc,phases      ] GC(144) Summary Phase 0.020ms
         * [1.645s][info][gc,phases,start] GC(144) Adjust Roots
         * [1.646s][info][gc,phases      ] GC(144) Adjust Roots 0.612ms
         * [1.646s][info][gc,phases,start] GC(144) Compaction Phase
         * [1.648s][info][gc,phases      ] GC(144) Compaction Phase 2.451ms
         * [1.648s][info][gc,phases,start] GC(144) Post Compact
         * [1.648s][info][gc,phases      ] GC(144) Post Compact 0.041ms
         * [1.648s][info][gc,heap        ] GC(144) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.648s][info][gc,heap        ] GC(144) ParOldGen: 2507K(2560K)->2507K(2560K)
         * [1.648s][info][gc,metaspace   ] GC(144) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.648s][info][gc             ] GC(144) Pause Full (Ergonomics) 2M->2M(3M) 7.956ms
         * [1.649s][info][gc,cpu         ] GC(144) User=0.03s Sys=0.00s Real=0.01s
         * [1.649s][info][gc,start       ] GC(145) Pause Full (Ergonomics)
         * [1.649s][info][gc,phases,start] GC(145) Marking Phase
         * [1.654s][info][gc,phases      ] GC(145) Marking Phase 5.306ms
         * [1.654s][info][gc,phases,start] GC(145) Summary Phase
         * [1.654s][info][gc,phases      ] GC(145) Summary Phase 0.018ms
         * [1.654s][info][gc,phases,start] GC(145) Adjust Roots
         * [1.655s][info][gc,phases      ] GC(145) Adjust Roots 0.787ms
         * [1.655s][info][gc,phases,start] GC(145) Compaction Phase
         * [1.657s][info][gc,phases      ] GC(145) Compaction Phase 2.008ms
         * [1.657s][info][gc,phases,start] GC(145) Post Compact
         * [1.657s][info][gc,phases      ] GC(145) Post Compact 0.029ms
         * [1.657s][info][gc,heap        ] GC(145) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.657s][info][gc,heap        ] GC(145) ParOldGen: 2517K(2560K)->2517K(2560K)
         * [1.657s][info][gc,metaspace   ] GC(145) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.657s][info][gc             ] GC(145) Pause Full (Ergonomics) 2M->2M(3M) 8.381ms
         * [1.657s][info][gc,cpu         ] GC(145) User=0.00s Sys=0.00s Real=0.01s
         * [1.658s][info][gc,start       ] GC(146) Pause Full (Ergonomics)
         * [1.658s][info][gc,phases,start] GC(146) Marking Phase
         * [1.663s][info][gc,phases      ] GC(146) Marking Phase 5.297ms
         * [1.663s][info][gc,phases,start] GC(146) Summary Phase
         * [1.663s][info][gc,phases      ] GC(146) Summary Phase 0.017ms
         * [1.663s][info][gc,phases,start] GC(146) Adjust Roots
         * [1.664s][info][gc,phases      ] GC(146) Adjust Roots 0.611ms
         * [1.664s][info][gc,phases,start] GC(146) Compaction Phase
         * [1.666s][info][gc,phases      ] GC(146) Compaction Phase 2.269ms
         * [1.666s][info][gc,phases,start] GC(146) Post Compact
         * [1.666s][info][gc,phases      ] GC(146) Post Compact 0.027ms
         * [1.666s][info][gc,heap        ] GC(146) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.666s][info][gc,heap        ] GC(146) ParOldGen: 2521K(2560K)->2521K(2560K)
         * [1.666s][info][gc,metaspace   ] GC(146) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.666s][info][gc             ] GC(146) Pause Full (Ergonomics) 2M->2M(3M) 8.448ms
         * [1.666s][info][gc,cpu         ] GC(146) User=0.03s Sys=0.00s Real=0.01s
         * [1.666s][info][gc,start       ] GC(147) Pause Full (Ergonomics)
         * [1.667s][info][gc,phases,start] GC(147) Marking Phase
         * [1.672s][info][gc,phases      ] GC(147) Marking Phase 5.613ms
         * [1.672s][info][gc,phases,start] GC(147) Summary Phase
         * [1.672s][info][gc,phases      ] GC(147) Summary Phase 0.015ms
         * [1.672s][info][gc,phases,start] GC(147) Adjust Roots
         * [1.673s][info][gc,phases      ] GC(147) Adjust Roots 0.918ms
         * [1.673s][info][gc,phases,start] GC(147) Compaction Phase
         * [1.675s][info][gc,phases      ] GC(147) Compaction Phase 2.142ms
         * [1.675s][info][gc,phases,start] GC(147) Post Compact
         * [1.675s][info][gc,phases      ] GC(147) Post Compact 0.028ms
         * [1.675s][info][gc,heap        ] GC(147) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.675s][info][gc,heap        ] GC(147) ParOldGen: 2527K(2560K)->2527K(2560K)
         * [1.675s][info][gc,metaspace   ] GC(147) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.675s][info][gc             ] GC(147) Pause Full (Ergonomics) 2M->2M(3M) 8.965ms
         * [1.675s][info][gc,cpu         ] GC(147) User=0.03s Sys=0.00s Real=0.01s
         * [1.676s][info][gc,start       ] GC(148) Pause Full (Ergonomics)
         * [1.676s][info][gc,phases,start] GC(148) Marking Phase
         * [1.681s][info][gc,phases      ] GC(148) Marking Phase 5.209ms
         * [1.681s][info][gc,phases,start] GC(148) Summary Phase
         * [1.681s][info][gc,phases      ] GC(148) Summary Phase 0.016ms
         * [1.681s][info][gc,phases,start] GC(148) Adjust Roots
         * [1.682s][info][gc,phases      ] GC(148) Adjust Roots 0.929ms
         * [1.682s][info][gc,phases,start] GC(148) Compaction Phase
         * [1.684s][info][gc,phases      ] GC(148) Compaction Phase 2.382ms
         * [1.684s][info][gc,phases,start] GC(148) Post Compact
         * [1.685s][info][gc,phases      ] GC(148) Post Compact 0.028ms
         * [1.685s][info][gc,heap        ] GC(148) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.685s][info][gc,heap        ] GC(148) ParOldGen: 2534K(2560K)->2534K(2560K)
         * [1.685s][info][gc,metaspace   ] GC(148) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.685s][info][gc             ] GC(148) Pause Full (Ergonomics) 2M->2M(3M) 8.826ms
         * [1.685s][info][gc,cpu         ] GC(148) User=0.00s Sys=0.00s Real=0.01s
         * [1.685s][info][gc,start       ] GC(149) Pause Full (Ergonomics)
         * [1.685s][info][gc,phases,start] GC(149) Marking Phase
         * [1.690s][info][gc,phases      ] GC(149) Marking Phase 5.218ms
         * [1.690s][info][gc,phases,start] GC(149) Summary Phase
         * [1.690s][info][gc,phases      ] GC(149) Summary Phase 0.017ms
         * [1.690s][info][gc,phases,start] GC(149) Adjust Roots
         * [1.691s][info][gc,phases      ] GC(149) Adjust Roots 0.911ms
         * [1.691s][info][gc,phases,start] GC(149) Compaction Phase
         * [1.693s][info][gc,phases      ] GC(149) Compaction Phase 2.069ms
         * [1.693s][info][gc,phases,start] GC(149) Post Compact
         * [1.693s][info][gc,phases      ] GC(149) Post Compact 0.031ms
         * [1.693s][info][gc,heap        ] GC(149) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.693s][info][gc,heap        ] GC(149) ParOldGen: 2539K(2560K)->2539K(2560K)
         * [1.693s][info][gc,metaspace   ] GC(149) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.693s][info][gc             ] GC(149) Pause Full (Ergonomics) 2M->2M(3M) 8.487ms
         * [1.693s][info][gc,cpu         ] GC(149) User=0.02s Sys=0.00s Real=0.01s
         * [1.694s][info][gc,start       ] GC(150) Pause Full (Ergonomics)
         * [1.694s][info][gc,phases,start] GC(150) Marking Phase
         * [1.698s][info][gc,phases      ] GC(150) Marking Phase 4.697ms
         * [1.698s][info][gc,phases,start] GC(150) Summary Phase
         * [1.698s][info][gc,phases      ] GC(150) Summary Phase 0.020ms
         * [1.698s][info][gc,phases,start] GC(150) Adjust Roots
         * [1.699s][info][gc,phases      ] GC(150) Adjust Roots 0.941ms
         * [1.699s][info][gc,phases,start] GC(150) Compaction Phase
         * [1.702s][info][gc,phases      ] GC(150) Compaction Phase 2.116ms
         * [1.702s][info][gc,phases,start] GC(150) Post Compact
         * [1.702s][info][gc,phases      ] GC(150) Post Compact 0.029ms
         * [1.702s][info][gc,heap        ] GC(150) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.702s][info][gc,heap        ] GC(150) ParOldGen: 2545K(2560K)->2545K(2560K)
         * [1.702s][info][gc,metaspace   ] GC(150) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.702s][info][gc             ] GC(150) Pause Full (Ergonomics) 2M->2M(3M) 8.042ms
         * [1.702s][info][gc,cpu         ] GC(150) User=0.00s Sys=0.00s Real=0.01s
         * [1.702s][info][gc,start       ] GC(151) Pause Full (Ergonomics)
         * [1.702s][info][gc,phases,start] GC(151) Marking Phase
         * [1.708s][info][gc,phases      ] GC(151) Marking Phase 5.714ms
         * [1.708s][info][gc,phases,start] GC(151) Summary Phase
         * [1.708s][info][gc,phases      ] GC(151) Summary Phase 0.013ms
         * [1.708s][info][gc,phases,start] GC(151) Adjust Roots
         * [1.709s][info][gc,phases      ] GC(151) Adjust Roots 0.642ms
         * [1.709s][info][gc,phases,start] GC(151) Compaction Phase
         * [1.711s][info][gc,phases      ] GC(151) Compaction Phase 2.052ms
         * [1.711s][info][gc,phases,start] GC(151) Post Compact
         * [1.711s][info][gc,phases      ] GC(151) Post Compact 0.043ms
         * [1.711s][info][gc,heap        ] GC(151) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.711s][info][gc,heap        ] GC(151) ParOldGen: 2549K(2560K)->2549K(2560K)
         * [1.711s][info][gc,metaspace   ] GC(151) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.711s][info][gc             ] GC(151) Pause Full (Ergonomics) 2M->2M(3M) 8.711ms
         * [1.711s][info][gc,cpu         ] GC(151) User=0.03s Sys=0.00s Real=0.01s
         * [1.711s][info][gc,start       ] GC(152) Pause Full (Ergonomics)
         * [1.711s][info][gc,phases,start] GC(152) Marking Phase
         * [1.717s][info][gc,phases      ] GC(152) Marking Phase 6.010ms
         * [1.718s][info][gc,phases,start] GC(152) Summary Phase
         * [1.718s][info][gc,phases      ] GC(152) Summary Phase 0.022ms
         * [1.718s][info][gc,phases,start] GC(152) Adjust Roots
         * [1.719s][info][gc,phases      ] GC(152) Adjust Roots 1.085ms
         * [1.719s][info][gc,phases,start] GC(152) Compaction Phase
         * [1.721s][info][gc,phases      ] GC(152) Compaction Phase 2.190ms
         * [1.721s][info][gc,phases,start] GC(152) Post Compact
         * [1.721s][info][gc,phases      ] GC(152) Post Compact 0.026ms
         * [1.721s][info][gc,heap        ] GC(152) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.721s][info][gc,heap        ] GC(152) ParOldGen: 2558K(2560K)->2558K(2560K)
         * [1.721s][info][gc,metaspace   ] GC(152) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.721s][info][gc             ] GC(152) Pause Full (Ergonomics) 2M->2M(3M) 9.614ms
         * [1.721s][info][gc,cpu         ] GC(152) User=0.00s Sys=0.00s Real=0.01s
         * [1.721s][info][gc,start       ] GC(153) Pause Full (Ergonomics)
         * [1.721s][info][gc,phases,start] GC(153) Marking Phase
         * [1.727s][info][gc,phases      ] GC(153) Marking Phase 5.858ms
         * [1.727s][info][gc,phases,start] GC(153) Summary Phase
         * [1.727s][info][gc,phases      ] GC(153) Summary Phase 0.018ms
         * [1.727s][info][gc,phases,start] GC(153) Adjust Roots
         * [1.728s][info][gc,phases      ] GC(153) Adjust Roots 1.177ms
         * [1.729s][info][gc,phases,start] GC(153) Compaction Phase
         * [1.732s][info][gc,phases      ] GC(153) Compaction Phase 3.301ms
         * [1.732s][info][gc,phases,start] GC(153) Post Compact
         * [1.732s][info][gc,phases      ] GC(153) Post Compact 0.036ms
         * [1.732s][info][gc,heap        ] GC(153) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.732s][info][gc,heap        ] GC(153) ParOldGen: 2559K(2560K)->2559K(2560K)
         * [1.732s][info][gc,metaspace   ] GC(153) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.732s][info][gc             ] GC(153) Pause Full (Ergonomics) 2M->2M(3M) 10.649ms
         * [1.732s][info][gc,cpu         ] GC(153) User=0.03s Sys=0.00s Real=0.01s
         * [1.732s][info][gc,start       ] GC(154) Pause Full (Allocation Failure)
         * [1.732s][info][gc,phases,start] GC(154) Marking Phase
         * [1.738s][info][gc,phases      ] GC(154) Marking Phase 5.494ms
         * [1.738s][info][gc,phases,start] GC(154) Summary Phase
         * [1.738s][info][gc,phases      ] GC(154) Summary Phase 0.016ms
         * [1.738s][info][gc,phases,start] GC(154) Adjust Roots
         * [1.738s][info][gc,phases      ] GC(154) Adjust Roots 0.806ms
         * [1.738s][info][gc,phases,start] GC(154) Compaction Phase
         * [1.741s][info][gc,phases      ] GC(154) Compaction Phase 2.033ms
         * [1.741s][info][gc,phases,start] GC(154) Post Compact
         * [1.741s][info][gc,phases      ] GC(154) Post Compact 0.026ms
         * [1.741s][info][gc,heap        ] GC(154) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.741s][info][gc,heap        ] GC(154) ParOldGen: 2559K(2560K)->2559K(2560K)
         * [1.741s][info][gc,metaspace   ] GC(154) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.741s][info][gc             ] GC(154) Pause Full (Allocation Failure) 2M->2M(3M) 8.614ms
         * [1.741s][info][gc,cpu         ] GC(154) User=0.03s Sys=0.00s Real=0.01s
         * [1.741s][info][gc,start       ] GC(155) Pause Full (Ergonomics)
         * [1.741s][info][gc,phases,start] GC(155) Marking Phase
         * [1.747s][info][gc,phases      ] GC(155) Marking Phase 5.283ms
         * [1.747s][info][gc,phases,start] GC(155) Summary Phase
         * [1.747s][info][gc,phases      ] GC(155) Summary Phase 0.020ms
         * [1.747s][info][gc,phases,start] GC(155) Adjust Roots
         * [1.748s][info][gc,phases      ] GC(155) Adjust Roots 0.929ms
         * [1.748s][info][gc,phases,start] GC(155) Compaction Phase
         * [1.750s][info][gc,phases      ] GC(155) Compaction Phase 2.273ms
         * [1.750s][info][gc,phases,start] GC(155) Post Compact
         * [1.750s][info][gc,phases      ] GC(155) Post Compact 0.028ms
         * [1.750s][info][gc,heap        ] GC(155) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.750s][info][gc,heap        ] GC(155) ParOldGen: 2559K(2560K)->2559K(2560K)
         * [1.750s][info][gc,metaspace   ] GC(155) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.750s][info][gc             ] GC(155) Pause Full (Ergonomics) 2M->2M(3M) 8.789ms
         * [1.750s][info][gc,cpu         ] GC(155) User=0.00s Sys=0.00s Real=0.01s
         * [1.750s][info][gc,start       ] GC(156) Pause Full (Allocation Failure)
         * [1.750s][info][gc,phases,start] GC(156) Marking Phase
         * [1.756s][info][gc,phases      ] GC(156) Marking Phase 5.529ms
         * [1.756s][info][gc,phases,start] GC(156) Summary Phase
         * [1.756s][info][gc,phases      ] GC(156) Summary Phase 0.016ms
         * [1.756s][info][gc,phases,start] GC(156) Adjust Roots
         * [1.757s][info][gc,phases      ] GC(156) Adjust Roots 1.002ms
         * [1.757s][info][gc,phases,start] GC(156) Compaction Phase
         * [1.759s][info][gc,phases      ] GC(156) Compaction Phase 2.226ms
         * [1.759s][info][gc,phases,start] GC(156) Post Compact
         * [1.759s][info][gc,phases      ] GC(156) Post Compact 0.025ms
         * [1.759s][info][gc,heap        ] GC(156) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.759s][info][gc,heap        ] GC(156) ParOldGen: 2559K(2560K)->2559K(2560K)
         * [1.759s][info][gc,metaspace   ] GC(156) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.759s][info][gc             ] GC(156) Pause Full (Allocation Failure) 2M->2M(3M) 9.046ms
         * [1.759s][info][gc,cpu         ] GC(156) User=0.03s Sys=0.00s Real=0.01s
         * [1.759s][info][gc,start       ] GC(157) Pause Full (Ergonomics)
         * [1.759s][info][gc,phases,start] GC(157) Marking Phase
         * [1.765s][info][gc,phases      ] GC(157) Marking Phase 5.778ms
         * [1.765s][info][gc,phases,start] GC(157) Summary Phase
         * [1.765s][info][gc,phases      ] GC(157) Summary Phase 0.018ms
         * [1.765s][info][gc,phases,start] GC(157) Adjust Roots
         * [1.767s][info][gc,phases      ] GC(157) Adjust Roots 1.344ms
         * [1.767s][info][gc,phases,start] GC(157) Compaction Phase
         * [1.770s][info][gc,phases      ] GC(157) Compaction Phase 3.652ms
         * [1.770s][info][gc,phases,start] GC(157) Post Compact
         * [1.770s][info][gc,phases      ] GC(157) Post Compact 0.025ms
         * [1.770s][info][gc,heap        ] GC(157) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.770s][info][gc,heap        ] GC(157) ParOldGen: 2559K(2560K)->2522K(2560K)
         * [1.770s][info][gc,metaspace   ] GC(157) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.771s][info][gc             ] GC(157) Pause Full (Ergonomics) 2M->2M(3M) 11.135ms
         * [1.771s][info][gc,cpu         ] GC(157) User=0.03s Sys=0.00s Real=0.01s
         * [1.771s][info][gc,start       ] GC(158) Pause Full (Ergonomics)
         * [1.771s][info][gc,phases,start] GC(158) Marking Phase
         * [1.776s][info][gc,phases      ] GC(158) Marking Phase 5.091ms
         * [1.776s][info][gc,phases,start] GC(158) Summary Phase
         * [1.776s][info][gc,phases      ] GC(158) Summary Phase 0.018ms
         * [1.776s][info][gc,phases,start] GC(158) Adjust Roots
         * [1.777s][info][gc,phases      ] GC(158) Adjust Roots 0.994ms
         * [1.777s][info][gc,phases,start] GC(158) Compaction Phase
         * [1.779s][info][gc,phases      ] GC(158) Compaction Phase 2.300ms
         * [1.779s][info][gc,phases,start] GC(158) Post Compact
         * [1.779s][info][gc,phases      ] GC(158) Post Compact 0.029ms
         * [1.779s][info][gc,heap        ] GC(158) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.779s][info][gc,heap        ] GC(158) ParOldGen: 2523K(2560K)->2514K(2560K)
         * [1.779s][info][gc,metaspace   ] GC(158) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.780s][info][gc             ] GC(158) Pause Full (Ergonomics) 2M->2M(3M) 8.727ms
         * [1.780s][info][gc,cpu         ] GC(158) User=0.00s Sys=0.00s Real=0.01s
         * [1.780s][info][gc,start       ] GC(159) Pause Full (Ergonomics)
         * [1.780s][info][gc,phases,start] GC(159) Marking Phase
         * [1.785s][info][gc,phases      ] GC(159) Marking Phase 5.456ms
         * [1.785s][info][gc,phases,start] GC(159) Summary Phase
         * [1.785s][info][gc,phases      ] GC(159) Summary Phase 0.016ms
         * [1.785s][info][gc,phases,start] GC(159) Adjust Roots
         * [1.786s][info][gc,phases      ] GC(159) Adjust Roots 0.976ms
         * [1.786s][info][gc,phases,start] GC(159) Compaction Phase
         * [1.790s][info][gc,phases      ] GC(159) Compaction Phase 3.488ms
         * [1.790s][info][gc,phases,start] GC(159) Post Compact
         * [1.790s][info][gc,phases      ] GC(159) Post Compact 0.033ms
         * [1.790s][info][gc,heap        ] GC(159) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.790s][info][gc,heap        ] GC(159) ParOldGen: 2516K(2560K)->2485K(2560K)
         * [1.790s][info][gc,metaspace   ] GC(159) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.790s][info][gc             ] GC(159) Pause Full (Ergonomics) 2M->2M(3M) 10.245ms
         * [1.790s][info][gc,cpu         ] GC(159) User=0.03s Sys=0.00s Real=0.01s
         * [1.791s][info][gc,start       ] GC(160) Pause Full (Ergonomics)
         * [1.791s][info][gc,phases,start] GC(160) Marking Phase
         * [1.796s][info][gc,phases      ] GC(160) Marking Phase 5.387ms
         * [1.796s][info][gc,phases,start] GC(160) Summary Phase
         * [1.796s][info][gc,phases      ] GC(160) Summary Phase 0.017ms
         * [1.796s][info][gc,phases,start] GC(160) Adjust Roots
         * [1.797s][info][gc,phases      ] GC(160) Adjust Roots 0.732ms
         * [1.797s][info][gc,phases,start] GC(160) Compaction Phase
         * [1.799s][info][gc,phases      ] GC(160) Compaction Phase 2.278ms
         * [1.799s][info][gc,phases,start] GC(160) Post Compact
         * [1.799s][info][gc,phases      ] GC(160) Post Compact 0.019ms
         * [1.799s][info][gc,heap        ] GC(160) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.799s][info][gc,heap        ] GC(160) ParOldGen: 2487K(2560K)->2487K(2560K)
         * [1.799s][info][gc,metaspace   ] GC(160) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.799s][info][gc             ] GC(160) Pause Full (Ergonomics) 2M->2M(3M) 8.628ms
         * [1.799s][info][gc,cpu         ] GC(160) User=0.00s Sys=0.00s Real=0.01s
         * [1.799s][info][gc,start       ] GC(161) Pause Full (Ergonomics)
         * [1.799s][info][gc,phases,start] GC(161) Marking Phase
         * [1.804s][info][gc,phases      ] GC(161) Marking Phase 4.595ms
         * [1.804s][info][gc,phases,start] GC(161) Summary Phase
         * [1.804s][info][gc,phases      ] GC(161) Summary Phase 0.009ms
         * [1.804s][info][gc,phases,start] GC(161) Adjust Roots
         * [1.805s][info][gc,phases      ] GC(161) Adjust Roots 0.540ms
         * [1.805s][info][gc,phases,start] GC(161) Compaction Phase
         * [1.806s][info][gc,phases      ] GC(161) Compaction Phase 1.444ms
         * [1.806s][info][gc,phases,start] GC(161) Post Compact
         * [1.806s][info][gc,phases      ] GC(161) Post Compact 0.024ms
         * [1.806s][info][gc,heap        ] GC(161) PSYoungGen: 512K(1024K)->512K(1024K) Eden: 512K(512K)->512K(512K) From: 0K(512K)->0K(512K)
         * [1.806s][info][gc,heap        ] GC(161) ParOldGen: 2488K(2560K)->2488K(2560K)
         * [1.806s][info][gc,metaspace   ] GC(161) Metaspace: 985K(4864K)->985K(4864K) NonClass: 889K(4352K)->889K(4352K) Class: 95K(512K)->95K(512K)
         * [1.806s][info][gc             ] GC(161) Pause Full (Ergonomics) 2M->2M(3M) 6.777ms
         * [1.806s][info][gc,cpu         ] GC(161) User=0.03s Sys=0.00s Real=0.01s
         * [1.807s][info][gc,heap,exit   ] Heap
         * [1.807s][info][gc,heap,exit   ]  PSYoungGen      total 1024K, used 512K [0x00000000ffe80000, 0x0000000100000000, 0x0000000100000000)
         * [1.807s][info][gc,heap,exit   ]   eden space 512K, 100% used [0x00000000ffe80000,0x00000000fff00000,0x00000000fff00000)
         * [1.807s][info][gc,heap,exit   ]   from space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
         * [1.807s][info][gc,heap,exit   ]   to   space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
         * [1.807s][info][gc,heap,exit   ]  ParOldGen       total 2560K, used 2491K [0x00000000ffc00000, 0x00000000ffe80000, 0x00000000ffe80000)
         * [1.807s][info][gc,heap,exit   ]   object space 2560K, 97% used [0x00000000ffc00000,0x00000000ffe6edf0,0x00000000ffe80000)
         * [1.807s][info][gc,heap,exit   ]  Metaspace       used 994K, capacity 4537K, committed 4864K, reserved 1056768K
         * [1.807s][info][gc,heap,exit   ]   class space    used 96K, capacity 404K, committed 512K, reserved 1048576K
         * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
         */
    }
}
