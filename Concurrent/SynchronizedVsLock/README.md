## Synchronized vs. Lock

#### 1. Stack

    (1). Synchronized
    
      - JVM level (monitorenter, monitorexit)
      - wait/notify (older Lock) also depends monitor instance
      
    (2). Lock
      - API level
      - java.util.concurrent.locks.Lock

#### 2. Usage

    (1). Synchronized
      - implicit unlock (automatic)
      
    (2). Lock
      - explicit unlock
    
#### 3. Interrupt?

    (1). Synchronized
      - no, unless exception
     
    (2). Lock
      - yes
    
#### 4. Fair?

    (1). Synchronized
      - unfair lock
      
    (2). Lock
      - unfair (default) or fair lock
    
#### 5. Wakeup (Condition)

    (1). Synchronized
      - random or all
      
    (2). Lock
      - specific one, group or all