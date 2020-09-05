package aqs1;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author Sanstwy27
 * @create 9/5/2020
 */

public class Sync extends AbstractQueuedSynchronizer {

    public void lock() {
        acquire(1);
    }

    public boolean unlock() {
        return release(1);
    }

    public boolean tryLock() {
        return tryAcquire(1);
    }

    public boolean isLocked() {
        return isHeldExclusively();
    }

    @Override
    protected boolean tryAcquire(int arg) {
        if (compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        if (getState() == 0) {
            throw new IllegalMonitorStateException();
        }
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    @Override
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }
}
