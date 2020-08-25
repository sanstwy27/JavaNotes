### Understanding Thread Pool in Java
1. In terms of performance, creating a new thread is an expensive operation because it requires the operating system allocates resources need for the thread. Therefore, in practice thread pool is used for large-scale applications that launch a lot of short-lived threads in order to utilize resources efficiently and increase performance.
2. Instead of creating new threads when new tasks arrive, a thread pool keeps a number of idle threads that are ready for executing tasks as needed. After a thread completes execution of a task, it does not die. Instead it remains idle in the pool waiting to be chosen for executing new tasks.
3. You can limit a definite number of concurrent threads in the pool, which is useful to prevent overload. If all threads are busily executing tasks, new tasks are placed in a queue, waiting for a thread becomes available.

### The java.util.concurrent package

contains the following interfaces:
- Executor, ExecutorService, etc.

contains the following classes:
- Executors, ThreadPoolExecutor, etc.

supports the following types of thread pools:
- ```java
  ExecutorService threadPool = Executors.newFixedThreadPool(5);
  
  public static ExecutorService newFixedThreadPool(int nThreads) {
          return new ThreadPoolExecutor(nThreads, nThreads,
                                        0L, TimeUnit.MILLISECONDS,
                                        new LinkedBlockingQueue<Runnable>());
      }
  ```
- ```java
  ExecutorService threadPool = Executors.newSingleThreadExecutor();
  
  public static ExecutorService newSingleThreadExecutor() {
          return new FinalizableDelegatedExecutorService
              (new ThreadPoolExecutor(1, 1,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>()));
      }
  ```

- ```java
  ExecutorService threadPool = Executors.newCachedThreadPool();
  
  public static ExecutorService newCachedThreadPool() {
          return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                        60L, TimeUnit.SECONDS,
                                        new SynchronousQueue<Runnable>());
      }
  ```
  
### ThreadPoolExecutor
```java
public ThreadPoolExecutor(int corePoolSize,
                          int maximumPoolSize,
                          long keepAliveTime,
                          TimeUnit unit,
                          BlockingQueue<Runnable> workQueue,
                          ThreadFactory threadFactory,
                          RejectedExecutionHandler handler)
Creates a new ThreadPoolExecutor with the given initial parameters.
Parameters:
corePoolSize - the number of threads to keep in the pool, even if they are idle, unless allowCoreThreadTimeOut is set
maximumPoolSize - the maximum number of threads to allow in the pool
keepAliveTime - when the number of threads is greater than the core, this is the maximum time that excess idle threads will wait for new tasks before terminating.
unit - the time unit for the keepAliveTime argument
workQueue - the queue to use for holding tasks before they are executed. This queue will hold only the Runnable tasks submitted by the execute method.
threadFactory - the factory to use when the executor creates a new thread
handler - the handler to use when execution is blocked because the thread bounds and queue capacities are reached
Throws:
IllegalArgumentException - if one of the following holds:
corePoolSize < 0
keepAliveTime < 0
maximumPoolSize <= 0
maximumPoolSize < corePoolSize
NullPointerException - if workQueue or threadFactory or handler is null
```
  
### ThreadPool Executor workflow
- Adding tasks to the thread pool automatically creates thead to handle tasks when the number of tasks is less than corePoolSize.
- When the number of added tasks is greater than corePoolSize and less than maximmPoolSize, instead of creating threads, these tasks are placed in a blocked queue, waiting to be executed.
- Connect the condition of the above 2, and when the blocking queue is full, continue to create threads to speed up the processing of the blocking queue.
- When adding tasks larger than maximmPoolSize, the saturation policy decides whether to allow adding tasks to the thread pool or not. The default saturation policy is AbortPolicy (discarded directly).  
  
### RejectedExecutionHandler
- AbortPolicy: A handler for rejected tasks that throws a RejectedExecutionException.
- CallerRunsPolicy: A handler for rejected tasks that runs the rejected task directly in the calling thread of the execute method, unless the executor has been shut down, in which case the task is discarded.
- DiscardOldestPolicy: A handler for rejected tasks that discards the oldest unhandled request and then retries execute, unless the executor is shut down, in which case the task is discarded.
- DiscardPolicy: A handler for rejected tasks that silently discards the rejected task.

### Which to choose?

None, it's highly recommended customizing one.

Here are the reasons:
- FixedThreadPool, SingleThreadPool: the upper bound length of LinkedBlockingQueue is Integer.MAX_VALUE, it might be "Out of memory (OOM)".
- CachedThreadPool, ScheduledThreadPool: the upper bound number of Threads is Integer.MAX_VALUE, it might be "Out of memory (OOM)".
  
### Performance tuning

    core processors = Runtime.getRuntime(),availableProcessors()
- CPU bound: threads = core processors + 1
- I/O bound: 
  1. threads = core processors * 2
  2. threads = core processors / (1 - coefficient), where coefficient between 0.8~0.9
  
### Reference:
1. http://www.atguigu.com/
2. https://www.codejava.net/java-core/concurrency/java-concurrency-understanding-thread-pool-and-executors
3. https://developpaper.com/summary-of-threadpool-executor-common-sense-in-java/