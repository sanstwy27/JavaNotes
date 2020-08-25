package com.sanstwy27.deadlock;


public class DeadLockApplication {

    public static void main(String[] args) {
        String lock1 = "lockA";
        String lock2 = "lockB";

        new Thread(new HoldLockThread(lock1, lock2),"ThreadA").start();
        new Thread(new HoldLockThread(lock2, lock1),"ThreadB").start();

        /**
         * ThreadB gets lockB, trying to get lockA
         * ThreadA gets lockA, trying to get lockB
         */

        /******************************************
         * ---- Debug ----
         ******************************************
         * 1. Find PID
         ******************************************
         * > C:\Program Files\Java\jdk-14.0.1\bin>jps -l
         * 35472 org.jetbrains.jps.cmdline.Launcher
         * 38384 com.sanstwy27.deadlock.DeadLockApplication
         * 17268
         * 11436
         * 19276
         * 24508 org.jetbrains.idea.maven.server.RemoteMavenServer36
         * 34892 jdk.jcmd/sun.tools.jps.Jps
         *******************************************
         * 2. Get Java stack information
         *******************************************
         * > C:\Program Files\Java\jdk-14.0.1\bin>jstack 38384
         * 2020-08-25 10:20:50
         * Full thread dump OpenJDK 64-Bit Server VM (14.0.1+7 mixed mode, sharing):
         *
         * Threads class SMR info:
         * _java_thread_list=0x00000193fba7c220, length=14, elements={
         * 0x00000193fafaf000, 0x00000193fafb0000, 0x00000193fb8eb800, 0x00000193fb8ef800,
         * 0x00000193fb8f0800, 0x00000193fb8f1800, 0x00000193fb8f3000, 0x00000193fb909000,
         * 0x00000193fba1d800, 0x00000193fba83800, 0x00000193fbd10000, 0x00000193fbd12800,
         * 0x00000193fbd13000, 0x00000193fbd22800
         * }
         *
         * "Reference Handler" #2 daemon prio=10 os_prio=2 cpu=0.00ms elapsed=351.30s tid=0x00000193fafaf000 nid=0x8f44 waiting on condition  [0x00000014664ff000]
         *    java.lang.Thread.State: RUNNABLE
         *         at java.lang.ref.Reference.waitForReferencePendingList(java.base@14.0.1/Native Method)
         *         at java.lang.ref.Reference.processPendingReferences(java.base@14.0.1/Reference.java:241)
         *         at java.lang.ref.Reference$ReferenceHandler.run(java.base@14.0.1/Reference.java:213)
         *
         * "Finalizer" #3 daemon prio=8 os_prio=1 cpu=0.00ms elapsed=351.30s tid=0x00000193fafb0000 nid=0x9610 in Object.wait()  [0x00000014665fe000]
         *    java.lang.Thread.State: WAITING (on object monitor)
         *         at java.lang.Object.wait(java.base@14.0.1/Native Method)
         *         - waiting on <0x0000000620a0b1b8> (a java.lang.ref.ReferenceQueue$Lock)
         *         at java.lang.ref.ReferenceQueue.remove(java.base@14.0.1/ReferenceQueue.java:155)
         *         - locked <0x0000000620a0b1b8> (a java.lang.ref.ReferenceQueue$Lock)
         *         at java.lang.ref.ReferenceQueue.remove(java.base@14.0.1/ReferenceQueue.java:176)
         *         at java.lang.ref.Finalizer$FinalizerThread.run(java.base@14.0.1/Finalizer.java:170)
         *
         * "Signal Dispatcher" #4 daemon prio=9 os_prio=2 cpu=0.00ms elapsed=351.24s tid=0x00000193fb8eb800 nid=0x9564 runnable  [0x0000000000000000]
         *    java.lang.Thread.State: RUNNABLE
         *
         * "Attach Listener" #5 daemon prio=5 os_prio=2 cpu=46.88ms elapsed=351.24s tid=0x00000193fb8ef800 nid=0x83a0 waiting on condition  [0x0000000000000000]
         *    java.lang.Thread.State: RUNNABLE
         *
         * "Service Thread" #6 daemon prio=9 os_prio=0 cpu=0.00ms elapsed=351.24s tid=0x00000193fb8f0800 nid=0x506c runnable  [0x0000000000000000]
         *    java.lang.Thread.State: RUNNABLE
         *
         * "C2 CompilerThread0" #7 daemon prio=9 os_prio=2 cpu=78.13ms elapsed=351.24s tid=0x00000193fb8f1800 nid=0x8014 waiting on condition  [0x0000000000000000]
         *    java.lang.Thread.State: RUNNABLE
         *    No compile task
         *
         * "C1 CompilerThread0" #10 daemon prio=9 os_prio=2 cpu=93.75ms elapsed=351.24s tid=0x00000193fb8f3000 nid=0x7fb0 waiting on condition  [0x0000000000000000]
         *    java.lang.Thread.State: RUNNABLE
         *    No compile task
         *
         * "Sweeper thread" #11 daemon prio=9 os_prio=2 cpu=0.00ms elapsed=351.24s tid=0x00000193fb909000 nid=0x99ac runnable  [0x0000000000000000]
         *    java.lang.Thread.State: RUNNABLE
         *
         * "Common-Cleaner" #12 daemon prio=8 os_prio=1 cpu=0.00ms elapsed=351.17s tid=0x00000193fba1d800 nid=0x9020 in Object.wait()  [0x0000001466cfe000]
         *    java.lang.Thread.State: TIMED_WAITING (on object monitor)
         *         at java.lang.Object.wait(java.base@14.0.1/Native Method)
         *         - waiting on <0x0000000620abcf38> (a java.lang.ref.ReferenceQueue$Lock)
         *         at java.lang.ref.ReferenceQueue.remove(java.base@14.0.1/ReferenceQueue.java:155)
         *         - locked <0x0000000620abcf38> (a java.lang.ref.ReferenceQueue$Lock)
         *         at jdk.internal.ref.CleanerImpl.run(java.base@14.0.1/CleanerImpl.java:148)
         *         at java.lang.Thread.run(java.base@14.0.1/Thread.java:832)
         *         at jdk.internal.misc.InnocuousThread.run(java.base@14.0.1/InnocuousThread.java:134)
         *
         * "Monitor Ctrl-Break" #13 daemon prio=5 os_prio=0 cpu=15.63ms elapsed=351.02s tid=0x00000193fba83800 nid=0x8cc8 runnable  [0x0000001466dfe000]
         *    java.lang.Thread.State: RUNNABLE
         *         at sun.nio.ch.SocketDispatcher.read0(java.base@14.0.1/Native Method)
         *         at sun.nio.ch.SocketDispatcher.read(java.base@14.0.1/SocketDispatcher.java:46)
         *         at sun.nio.ch.NioSocketImpl.tryRead(java.base@14.0.1/NioSocketImpl.java:261)
         *         at sun.nio.ch.NioSocketImpl.implRead(java.base@14.0.1/NioSocketImpl.java:312)
         *         at sun.nio.ch.NioSocketImpl.read(java.base@14.0.1/NioSocketImpl.java:350)
         *         at sun.nio.ch.NioSocketImpl$1.read(java.base@14.0.1/NioSocketImpl.java:803)
         *         at java.net.Socket$SocketInputStream.read(java.base@14.0.1/Socket.java:982)
         *         at sun.nio.cs.StreamDecoder.readBytes(java.base@14.0.1/StreamDecoder.java:297)
         *         at sun.nio.cs.StreamDecoder.implRead(java.base@14.0.1/StreamDecoder.java:339)
         *         at sun.nio.cs.StreamDecoder.read(java.base@14.0.1/StreamDecoder.java:188)
         *         - locked <0x0000000620940d90> (a java.io.InputStreamReader)
         *         at java.io.InputStreamReader.read(java.base@14.0.1/InputStreamReader.java:181)
         *         at java.io.BufferedReader.fill(java.base@14.0.1/BufferedReader.java:161)
         *         at java.io.BufferedReader.readLine(java.base@14.0.1/BufferedReader.java:326)
         *         - locked <0x0000000620940d90> (a java.io.InputStreamReader)
         *         at java.io.BufferedReader.readLine(java.base@14.0.1/BufferedReader.java:392)
         *         at com.intellij.rt.execution.application.AppMainV2$1.run(AppMainV2.java:61)
         *
         * "Notification Thread" #14 daemon prio=9 os_prio=0 cpu=0.00ms elapsed=351.02s tid=0x00000193fbd10000 nid=0x742c runnable  [0x0000000000000000]
         *    java.lang.Thread.State: RUNNABLE
         *
         * "ThreadA" #15 prio=5 os_prio=0 cpu=15.63ms elapsed=351.02s tid=0x00000193fbd12800 nid=0x9878 waiting for monitor entry  [0x00000014670ff000]
         *    java.lang.Thread.State: BLOCKED (on object monitor)
         *         at com.sanstwy27.deadlock.HoldLockThread.run(HoldLockThread.java:27)
         *         - waiting to lock <0x0000000620909e60> (a java.lang.String)
         *         - locked <0x0000000620909e30> (a java.lang.String)
         *         at java.lang.Thread.run(java.base@14.0.1/Thread.java:832)
         *
         * "ThreadB" #16 prio=5 os_prio=0 cpu=31.25ms elapsed=351.02s tid=0x00000193fbd13000 nid=0x86c4 waiting for monitor entry  [0x00000014671ff000]
         *    java.lang.Thread.State: BLOCKED (on object monitor)
         *         at com.sanstwy27.deadlock.HoldLockThread.run(HoldLockThread.java:27)
         *         - waiting to lock <0x0000000620909e30> (a java.lang.String)
         *         - locked <0x0000000620909e60> (a java.lang.String)
         *         at java.lang.Thread.run(java.base@14.0.1/Thread.java:832)
         *
         * "DestroyJavaVM" #17 prio=5 os_prio=0 cpu=250.00ms elapsed=351.02s tid=0x00000193fbd22800 nid=0x91e0 waiting on condition  [0x0000000000000000]
         *    java.lang.Thread.State: RUNNABLE
         *
         * "VM Thread" os_prio=2 cpu=0.00ms elapsed=351.30s tid=0x00000193fafae000 nid=0x9a4c runnable
         *
         * "GC Thread#0" os_prio=2 cpu=0.00ms elapsed=351.33s tid=0x00000193eaaa3000 nid=0x5e14 runnable
         *
         * "G1 Main Marker" os_prio=2 cpu=0.00ms elapsed=351.32s tid=0x00000193eaac5800 nid=0x270 runnable
         *
         * "G1 Conc#0" os_prio=2 cpu=0.00ms elapsed=351.32s tid=0x00000193eaac7800 nid=0x6d84 runnable
         *
         * "G1 Refine#0" os_prio=2 cpu=0.00ms elapsed=351.32s tid=0x00000193faf35000 nid=0x8e2c runnable
         *
         * "G1 Young RemSet Sampling" os_prio=2 cpu=0.00ms elapsed=351.32s tid=0x00000193faf36000 nid=0x9734 runnable
         * "VM Periodic Task Thread" os_prio=2 cpu=0.00ms elapsed=351.02s tid=0x00000193fbd11000 nid=0x5b68 waiting on condition
         *
         * JNI global refs: 16, weak refs: 0
         *
         *
         * Found one Java-level deadlock:
         * =============================
         * "ThreadA":
         *   waiting to lock monitor 0x00000193fafb8480 (object 0x0000000620909e60, a java.lang.String),
         *   which is held by "ThreadB"
         *
         * "ThreadB":
         *   waiting to lock monitor 0x00000193fafb6a80 (object 0x0000000620909e30, a java.lang.String),
         *   which is held by "ThreadA"
         *
         * Java stack information for the threads listed above:
         * ===================================================
         * "ThreadA":
         *         at com.sanstwy27.deadlock.HoldLockThread.run(HoldLockThread.java:27)
         *         - waiting to lock <0x0000000620909e60> (a java.lang.String)
         *         - locked <0x0000000620909e30> (a java.lang.String)
         *         at java.lang.Thread.run(java.base@14.0.1/Thread.java:832)
         * "ThreadB":
         *         at com.sanstwy27.deadlock.HoldLockThread.run(HoldLockThread.java:27)
         *         - waiting to lock <0x0000000620909e30> (a java.lang.String)
         *         - locked <0x0000000620909e60> (a java.lang.String)
         *         at java.lang.Thread.run(java.base@14.0.1/Thread.java:832)
         *
         * Found 1 deadlock.
         */
    }

}
