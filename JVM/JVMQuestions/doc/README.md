# JVM Questions

#### 1. How to Define Garbage?

- Reference Counting Algorithm
- Reachability Analysis Algorithm

#### 2. GC roots

- Objects referenced in the virtual machine (VM) stack, that is the local variable table in the stack frame
- Objects referenced by class static attributes in the method area
- Objects referenced by constants in the method area
- Objects referenced by JNI (the Native method) in the native method stack

#### 3. JVM Params

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

#### 4. References

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


#### 5. Out of Memory (OOM)

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

#### 6. Garbage Collections.

- Reference counting
- Copying garbage collection
- Mark-sweep garbage collection
- Mark-compact garbage collection

#### 7. Garbage Collector Types.

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
  
#### 8. Garbage Collectors.

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

  |         | +UseSerialGC   | +UseParallelGC *1   | +UseParNewGC   |
  | ------- | -----------    | ------------------- | -------------- |
  | Young   | UseSerialGC    | UseParallelGC       | UseParNewGC    |
  | Old     | UseSerialOldGC | UseParallelOldGC    | UseSerialOldGC |

  |         | +UseParallelOldGC                                               | +UseConcMarkSweepGC   |
  | ------- | --------------------------------------------------------------- | --------------------- |
  | Young   | UseParallelOldGC                                                | UseParNewGC           |
  | Old     | UseParallelOldGC(since JDK1.8) or UseSerialOldGC(before JDK1.6) | UseConcMarkSweepGC *2 |
      
  
  > 1. Different Between UseParNewGC and UseParallelGC: UseParallelGC is Adaptive Throughput and PauseTime(-XX:MaxGCPauseMillis) Parallel Collector.
  > 2. UseConcMarkSweepGC will switch to UseSerialOldGC when CMS is running out of memory


      
#### 9. JVM Params and GC

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
  
#### 10. Running Services with JVM Parameters

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
  
  