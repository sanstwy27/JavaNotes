# JVM Questions

#### 0. Outline

- ClassLoader
- Classloading Mechanism
- Run-Time Data Areas
- Stack-Heap-MethodArea Relationship
- Garbage Collection Scope
- Anatomy of GC Logs
- How to Define Garbage?
- GC roots
- JVM Params
- References
- Out of Memory (OOM)
- Garbage Collections.
- Garbage Collector Types.
- Garbage Collectors.
- JVM Params and GC
- Running Services with JVM Parameters

#### 1. ClassLoader

- Bootstrap Class Loader
- Extension Class Loader (Platform Class Loader)
- System Class Loader
- User-Defined Class Loader * n

#### 2. Classloading Mechanism

The delegation model requires that any request for a class loader to load a given class is first delegated to its parent class loader before the requested class loader tries to load the class itself. 
The parent class loader, in turn, goes through the same process of asking its parent. 
This chain of delegation continues through to the bootstrap class loader (also known as the primordial or system class loader). 
If a class loader's parent can load a given class, it returns that class. Otherwise, the class loader attempts to load the class itself.

Ref:
https://www.ibm.com/support/knowledgecenter/en/SSB23S_1.1.0.14/com.ibm.java.lnx.80.doc/diag/understanding/cl_delegation.html

#### 3. Run-Time Data Areas

- The pc Register
- Java Virtual Machine Stacks
  - Each Java Virtual Machine thread has a private Java Virtual Machine stack, created at the same time as the thread.
    A Java Virtual Machine stack stores frames.
    A Java Virtual Machine stack is analogous to the stack of a conventional language such as C:
    it holds local variables and partial results, and plays a part in method invocation and return.
    Because the Java Virtual Machine stack is never manipulated directly except to push and pop frames, frames may be heap allocated.
    The memory for a Java Virtual Machine stack does not need to be contiguous.
- Heap
  - The Java Virtual Machine has a heap that is shared among all Java Virtual Machine threads.
    The heap is the run-time data area from which memory for all class instances and arrays is allocated.
    - Young Generation Space (Young/New)
      - Eden Space
      - Survivor 0 Space (from <-> to)
      - Survivor 1 Space (to <-> from)
    - Tenure Generation Space (Old/Tenure)
    - Permanent/Meta Space (Perm/Meta since 1.8)
- Method Area
  - The Java Virtual Machine has a method area that is shared among all Java Virtual Machine threads.
    The method area is analogous to the storage area for compiled code of a conventional language or analogous to the "text" segment in an operating system process.
    It stores per-class structures such as the run-time constant pool, field and method data, and the code for methods and constructors, including the special methods used in class and instance initialization and interface initialization.
- Native Method Stacks

Ref:
https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-2.html

#### 4. Stack-Heap-MethodArea Relationship

Stack -> (A pointer to the instance pointer in the heap) ->
Heap -> (A pointer to the class data had been created) ->
MethodArea (ClassLoader loads Class to the Method Area)

#### 5. Garbage Collection Scope

- Affect
  - Method Area
  - Heap
- Unaffected
  - Java Stack
  - Native Method Stack
  - Program Counter Register

#### 6. Anatomy of GC Logs

```shell script
2014-11-18T16:39:25.512-0800: 76.592: [Full GC [PSYoungGen: 26560K->0K(233024K)] [PSOldGen: 632024K->658428K(699072K)] 658584K->658428K(932096K) [PSPermGen: 2379K->2379K(21248K)], 3.0978612 secs] [Times: user=3.09 sys=0.00, real=3.10 secs] 
2014-11-18T16:39:31.536-0800: 82.616: [Full GC [PSYoungGen: 116544K->0K(233024K)] [PSOldGen: 658428K->684832K(699072K)] 774972K->684832K(932096K) [PSPermGen: 2379K->2379K(21248K)], 3.2582136 secs] [Times: user=3.23 sys=0.03, real=3.26 secs] 
2014-11-18T16:39:37.728-0800: 88.808: [Full GC [PSYoungGen: 116544K->12164K(233024K)] [PSOldGen: 684832K->699071K(699072K)] 801376K->711236K(932096K) [PSPermGen: 2379K->2379K(21248K)], 3.4230220 secs] [Times: user=3.40 sys=0.02, real=3.42 secs] 
:
:
Heap
 PSYoungGen total 233024K, used 116544K [0x00000000eaab0000, 0x0000000100000000, 0x0000000100000000)
 eden space 116544K, 100% used [0x00000000eaab0000,0x00000000f1c80000,0x00000000f1c80000)
 from space 116480K, 0% used [0x00000000f1c80000,0x00000000f1c80000,0x00000000f8e40000)
 to space 116480K, 0% used [0x00000000f8e40000,0x00000000f8e40000,0x0000000100000000)
 PSOldGen total 699072K, used 699071K [0x00000000c0000000, 0x00000000eaab0000, 0x00000000eaab0000)
 object space 699072K, 99% used [0x00000000c0000000,0x00000000eaaafff0,0x00000000eaab0000)
 PSPermGen total 21248K, used 2409K [0x00000000bae00000, 0x00000000bc2c0000, 0x00000000c0000000)
 object space 21248K, 11% used [0x00000000bae00000,0x00000000bb05a740,0x00000000bc2c0000)
```

> 2014-11-18T16:39:37.728-0800: 88.808: [Full GC [PSYoungGen: 116544K->12164K(233024K)] [PSOldGen: 684832K->699071K(699072K)] 801376K->711236K(932096K) [PSPermGen: 2379K->2379K(21248K)], 3.4230220 secs] [Times: user=3.40 sys=0.02, real=3.42 secs]

Let’s pick apart this log statement and examine each field in it:

- 2014-11-18T16:39:37.728-0800 – Time stamp at which GC ran.

- Full GC – Type of GC. It could be either ‘Full GC’ or ‘GC’.

- [PSYoungGen: 116544K->12164K(233024K)] – After the GC ran the young generation, space came down from 116544k (i.e. 113mb) to 12164k (i.e. 12mb). Total allocated young generation space is 233024k (i.e.227mb).

- [PSOldGen: 684832K->699071K(699072K)] – After the GC ran the old generation space increased from 684832k (i.e. 669mb) to 699071k (i.e. 682mb) and total allocated old generation space is 669072k (i.e. 682mb). In this case after the GC event, old generation's space increased and didn't decrease, which isn't the case always. Here size has increased because all objects in Old generation are actively referenced + objects from young generation are promoted to old generation. Thus you are seeing the increase in the old generation size.

- 801376K->711236K(932096K) – After the GC ran, overall memory came down from 801376k to 711236k. Total allocated memory space is 932096k (i.e. 910mb).

- [PSPermGen: 2379K->2379K(21248K)] – After the GC ran, there was no drop in perm generation space.

- 3.4230220 secs – the GC took 3.42 seconds to complete.

- [Times: user=3.40 sys=0.02, real=3.42 secs] – Real is wall clock time (time from start to finish of the call). This is all elapsed time including time slices used by other processes and time the process spends blocked (for example if it is waiting for I/O to complete).
  - User is the amount of CPU time spent in user-mode code (outside the kernel) within the process. This is only actual CPU time used in executing the process. Other processes, and the time the process spends blocked, do not count towards this figure.
  - Sys is the amount of CPU time spent in the kernel within the process. This means executing CPU time spent in system calls within the kernel, as opposed to library code, which is still running in user-space. Like user, this is only CPU time used by the process.
  - In your case, if the CPU time (3.4 sec) is considerably higher than the real time passed (3.42 Sec), we can conclude that the GC was run using multiple threads.

Ref:
https://dzone.com/articles/understanding-garbage-collection-log

#### 7. How to Define Garbage?

- Reference Counting Algorithm
- Reachability Analysis Algorithm

#### 8. GC roots

- Objects referenced in the virtual machine (VM) stack, that is the local variable table in the stack frame
- Objects referenced by class static attributes in the method area
- Objects referenced by constants in the method area
- Objects referenced by JNI (the Native method) in the native method stack

#### 9. JVM Params

- Params
    - standrad params
      - -version
      - -help
      - -showversion
      - ...
    - X params
      - -Xint
      - -Xcomp
      - -Xmixed
      - ...
    - **XX params**
      - boolean (+: on, -: off)
        - -XX:+PrintGCDetails
        - -XX:-PrintGCDetails
        - -XX:+UseSerialGC
        - -XX:-UseSerialGC
        - ...
      - K-V (-XX:key=value)
        - -XX:MetaspaceSize=128m
        - -XX:MaxTenuringThreshold=15
        - ...
  
- Display
    - by CMD
      - list processes: jps -l
      - specific param: jinfo -flag [param] [PID]
      - display params: 
        - jinfo -flags [PID]
        - **java -XX:+PrintFlagsInitial -version**
          - -> default list (`:=` are changed params)
        - **java -XX:+PrintFlagsFinal -version**
          - -> final list (`:=` are changed params)
        - java -XX:+PrintCommandLineFlags
      - ...
    - by Code
      ```java
      //-Xms, default is (Main Memory * 1/64)
      Runtime.getRuntime().totalMemory();
      //-Xmx, default is (Main Memory * 1/4)
      Runtime.getRuntime().maxMemory();
      ```
     
- **Common Use Params**
  - -Xms === -XX:InitialHeapSize, default is (Main Memory * 1/64). 
  - -Xmx === -XX:MaxHeapSzie, default is (Main Memory * 1/4).
  - -Xss, thread stack size, default is "0", depends on platform.
  - -Xmn, young gen size.
  - -XX:MetaspaceSize, meta space size.
  - -XX:+PrintGCDetails, display GC info.
  - -XX:SurvivorRatio, eden:S0:S1 is 8:1:1 if default else SurvivorRatio:1:1.
  - -XX:NewRatio, YoungGen:OldGen is 2:1 if default else NewRatio:1.
  - -XX:MaxTenuringThreshold, survival times in S0/S1, default is 15, must be between 0 and 15.
  - ...

#### 10. References

- Type
    - Strong Reference
      - This is the default type/class of Reference Object. This kind of reference makes the referenced object not eligible for GC. That is, whenever an object is referenced by a chain of strong Reference Objects, it cannot be garbage collected.
    - Soft Reference
      - All soft references to softly reachable objects are guaranteed to have been cleared before the virtual machine throws an OutOfMemoryError.
    - Weak Reference
      - Weak reference objects do not prevent their referents from being made finalizable, finalized, and then reclaimed.
    - Phantom Reference
      - Phantom reference objects are enqueued after the collector determines that their referents may otherwise be reclaimed. Phantom references are most often used for scheduling pre-mortem cleanup actions in a more flexible way than is possible with the Java finalization mechanism. Unlike soft and weak references, phantom references are not automatically cleared by the garbage collector as they are enqueued. An object that is reachable via phantom references will remain so until all such references are cleared or themselves become unreachable.
- FAQ
  - scenario of soft Reference and weak Reference
    - ex: photo cahce
    ```java
    Map<String, SoftReference<Bitmap>>
    ```

Ref:
- https://stackoverflow.com/questions/9809074
- https://dzone.com/articles/weak-soft-and-phantom-references-in-java-and-why-they-matter


#### 11. Out of Memory (OOM)

- java.lang.StackOverflowError
  - Thrown when a stack overflow occurs because an application recurses too deeply.
- java.lang.OutOfMemoryError: Java heap space
  - It will be triggered when the application attempts to add more data into the heap space area, but there is not enough room for it.
- java.lang.OutOfMemoryError: GC overhead limit exceeded
  - It is the JVM’s way of signalling that your application spends too much time doing garbage collection with too little result. By default the JVM is configured to throw this error if it spends more than 98% of the total time doing GC and when after the GC only less than 2% of the heap is recovered.
- java.lang.OutOfMemoryError: Direct buffer memory
  - The actual memory buffers managed by DirectByteBuffer are not allocated in the heap. They are allocated using Unsafe.allocateMemory which allocates "native memory". So increasing or decreasing the heap size won't help.
- java.lang.OutOfMemoryError: unable to create new native thread
  - Java application has hit the limit of how many Threads it can launch.
- java.lang.OutOfMemoryError: Metaspace
  - When the amount of native memory needed for a class metadata exceeds MaxMetaSpaceSize, a java.lang.OutOfMemoryError exception with a detail MetaSpace is thrown.

Ref:
- https://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/memleaks002.html
- https://plumbr.io/outofmemoryerror

#### 12. Garbage Collections.

- Reference counting
- Copying garbage collection
- Mark-sweep garbage collection
- Mark-compact garbage collection

#### 13. Garbage Collector Types.

- Serial
  - It use a single thread to handle heap, and perform stop-the-world pause during any gc. Just see it as toy.
  - This is default for client-class machine (32bit jvm on windows or single-cpu machine).
- Parallel
  - It uses multiple gc threads to handle heap, and perform stop-the-world pause during any gc.
  - Java 8, this is default for server-class machine (multi-cpu unix-like machine or any 64bit jvm).
- CMS (Concurrent-Mark-Sweep)
  - It use 1 or more gc threads to scan the old generation periodically, and discard unused objects, the pause is very short, but use more cpu time.
    1. CMS initial mark
    2. CMS concurrent mark
    3. CMS remark
    4. CMS concurrent sweep
  - Warning: since Java 14, it's removed.
- G1 (Garbage first)
  - Similar as CMS, it use multiple background gc threads to scan & clear heap.
  - It divide old generation into parts, it could clean old generation by copy from 1 part to another.
    Thus it's less possible to get fragmentation.
  - Since Java 9, this is default for server-class machine (multi-cpu unix-like machine or any 64bit jvm).
  - Why use G1 as default?
    - The main reason is to reduce the gc pause time, though the overall throughput might be reduced.

Ref:
https://stackoverflow.com/questions/54615916/when-to-choose-serialgc-parallelgc-over-cms-g1-in-java
  
#### 14. Garbage Collectors.

- Total
    - UseSerialGC (serial copying)
    - UseParallelGC (parallel scavenge)
    - UseConcMarkSweepGC
    - UseParNewGC
    - UseParallelOldGC (parallel compacting)
    - UseG1GC
    - UseSerialOldGC (deprecated)

- By Generations
    - Young Gen
      - UseSerialGC, UseParallelGC, UseParNewGC
    - Old Gen
      - UseSerialOldGC (deprecated), UseParallelOldGC, UseConcMarkSweepGC
    - ALL
      - UseG1GC
      
- For use with

  |           | +UseSerialGC   | +UseParallelGC *1   | +UseParNewGC   |
  | --------- | -----------    | ------------------- | -------------- |
  | YoungGC   | UseSerialGC    | UseParallelGC       | UseParNewGC    |
  | OldGC     | UseSerialOldGC | UseParallelOldGC    | UseSerialOldGC |

  |           | +UseParallelOldGC                                               | +UseConcMarkSweepGC   |
  | --------- | --------------------------------------------------------------- | --------------------- |
  | YoungGC   | UseParallelOldGC                                                | UseParNewGC           |
  | OldGC     | UseParallelOldGC(since JDK1.8) or UseSerialOldGC(before JDK1.6) | UseConcMarkSweepGC *2 |
      
  
  > 1. Different Between UseParNewGC and UseParallelGC: UseParallelGC is Adaptive Throughput and PauseTime(-XX:MaxGCPauseMillis) Parallel Collector.
  > 2. UseConcMarkSweepGC will switch to UseSerialOldGC when CMS is running out of memory


      
#### 15. JVM Params and GC

- display flag of params
    ```shell
    > java -XX:+PrintCommandLineFlags -version
    ```
    ```shell
    -XX:G1ConcRefinementThreads=8
    -XX:GCDrainStackTargetSize=64
    -XX:InitialHeapSize=535965120
    -XX:MaxHeapSize=8575441920
    -XX:MinHeapSize=6815736
    -XX:+PrintCommandLineFlags
    -XX:ReservedCodeCacheSize=251658240
    -XX:+SegmentedCodeCache
    -XX:+UseCompressedClassPointers
    -XX:+UseCompressedOops
    -XX:+UseG1GC
    -XX:-UseLargePagesIndividualAllocation
    java version "13.0.1" 2019-10-15
    Java(TM) SE Runtime Environment (build 13.0.1+9)
    Java HotSpot(TM) 64-Bit Server VM (build 13.0.1+9, mixed mode, sharing)
    ```
- Server/Client mode
  - 32-bit Windows，default is "Client" mode.
  - 32-bit other OS, "Server" mode if ram > 2G and processors > dual-core else "Client" mode.
  - 64-bit, "Server" mode.
  
- -Xlog:gc*
    - DefNew -> Default New Generation (Serial)
    - Tenured -> Old (Serial)
    - ParNew -> Parallel New Generation
    - PSYoungGen -> Parallel Scavenge
    - ParOldGen -> Parallel Old Generation
      
- Parallel GC useful params
  - -XX:ParallelGCThreads
  
#### 16. Running Services with JVM Parameters

- commend
    ```$shell
    > java -server [jvm params] -jar [service]
    ```
- ex:
    ```shell script
    > java -server -Xms1024m -Xmx1024m -XX:+UseG1GC -jar -springbootxxx-1.0-SNAPSHOT.war 
    ```
- check flags
  1. list pid
  ```
  > jps -l
  [pid 1] application 1
  [pid 2] application 2
  ...
  [pid n] application n
  ```
  2. list flags
  ```shell script
  > jinfo -flags [pid]
  ...
  Command line: -Xms1024m -Xmx1024m -XX:+UseG1GC
  ```
  
  