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
  
- Diaplay
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


