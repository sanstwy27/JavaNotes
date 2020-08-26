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







