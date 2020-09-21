1. When does direct buffer released?
    - DirectByteBuffer does not use old Java finalizers. Instead, it uses internal sun.misc.Cleaner API. It creates new thread and stores a PhantomReference to every DirectByteBuffer created (except duplicates and slices which refer to the primary buffer). When the DirectByteBuffer becomes phantom-reachable (that is, no strong, soft or weak references to the byte buffer exist anymore) and garbage collector sees this, it adds this buffer to the ReferenceQueue which is processed by Cleaner thread. So three events should occur:
        1. DirectByteBuffer becomes phantom-reachable.
        2. Garbage collection is performed (in separate thread), DirectByteBuffer Java object is collected and an entry is added to the ReferenceQueue.
        3. Cleaner thread reaches this entry and runs the registered clean-up action (in this case, it's java.nio.DirectByteBuffer.Deallocator object), this action finally frees the native memory.


Demo Ref:
https://blog.csdn.net/zxm1306192988/article/details/60581173