package aqs2;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Sanstwy27
 * @create 9/5/2020
 */

public class AqsLock {
    private static final Unsafe unsafe = UnsafeInstance.reflectGetUnsafe();
    private static long stateOffset;
    private volatile int state = 0;
    private Thread lockHolder;
    private ConcurrentLinkedQueue<Thread> waiters = new ConcurrentLinkedQueue<>();

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(AqsLock.class.getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Thread getLockHolder() {
        return lockHolder;
    }

    public void setLockHolder(Thread lockHolder) {
        this.lockHolder = lockHolder;
    }

    public final boolean compareAndSwapState(int except, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, except, update);
    }

    public boolean acquire() {
        Thread current = Thread.currentThread();
        int c = getState();
        if(c == 0) {
            if((waiters.size() == 0 || current == waiters.peek()) && compareAndSwapState(0,1)) {
                setLockHolder(current);
                return true;
            }
        }
        return false;
    }

    public void lock() {
        if(acquire()) {
            return;
        }

        Thread current = Thread.currentThread();
        waiters.add(current);

        while(true) {
            if(current == waiters.peek() && acquire()) {
                waiters.poll();
                return;
            }
            LockSupport.park(current);
        }
    }

    public void unlock() {
        if(Thread.currentThread() != lockHolder) {
            throw new RuntimeException("lockholder is not current thread");
        }
        int state = getState();
        if(compareAndSwapState(state,0)) {
            setLockHolder(null);
            Thread first = waiters.peek();
            if(first != null) {
                LockSupport.unpark(first);
            }
        }
    }
}
