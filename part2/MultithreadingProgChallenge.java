import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

class MultithreadingChallenge {
  static final class SharedInteger {
    private ReadWriteLock lock;
    private Lock writeLock;
    private Lock readLock;

    private int i;

    SharedInteger() {
      this.lock = new ReentrantReadWriteLock();
      this.writeLock = this.lock.writeLock();
      this.readLock = this.lock.readLock();
      i = 0;
    }

    void increment() {
      this.writeLock.lock();
      try {
        i++;
      }
      finally {
        this.writeLock.unlock();
      }
    }

    int get() {
      this.readLock.lock();
      try {
        return this.i;
      }
      finally {
        this.readLock.unlock();
      }
    }

  }

  static final class LockOrdering {
    private final ReentrantLock a;
    private final ReentrantLock b;

    LockOrdering() {
      a = new ReentrantLock();
      b = new ReentrantLock();
    }

    void opA() throws InterruptedException {
      try {
        // Solution always accquire locks with lower value first
        a.lock();
        Thread.sleep(5_000);
        b.lock();
        assert a.isHeldByCurrentThread() && b.isHeldByCurrentThread();
      } finally {
        b.unlock();
        a.unlock();
      }
    }

    void opB() throws InterruptedException {
      try {
        // Solution always accquire locks with lower value first
        a.lock();
        Thread.sleep(5_000);
        b.lock();
        assert a.isHeldByCurrentThread() && b.isHeldByCurrentThread();
      } finally {
        a.unlock();
        b.unlock();
      }
    }
  }

  static void problem1() throws InterruptedException {
    final int threads = 10;
    final int incrementsPerThread = 1_000_000;
    final int expected = threads * incrementsPerThread;
    final CountDownLatch cdl = new CountDownLatch(threads);
    final SharedInteger x = new SharedInteger();
    for (int i = 0; i < threads; i++) {
      (new Thread(
              new Runnable() {
                @Override
                public void run() {
                  try {
                    for (int i = 0; i < incrementsPerThread; i++) {
                      x.increment();
                    }
                  } finally {
                    cdl.countDown();
                  }
                }
              }))
          .start();
    }
    cdl.await();
    assert expected == x.get();
  }

  static void problem2() throws InterruptedException {
    final CountDownLatch cdl = new CountDownLatch(2);
    final LockOrdering lo = new LockOrdering();
    (new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  lo.opA();
                } catch (final InterruptedException e) {
                } finally {
                  cdl.countDown();
                }
              }
            }))
        .start();
    (new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  lo.opB();
                } catch (final InterruptedException e) {
                } finally {
                  cdl.countDown();
                }
              }
            }))
        .start();
    cdl.await();
  }

  public static void main(final String[] args) throws InterruptedException {
    problem1();
    problem2();
  }
}
