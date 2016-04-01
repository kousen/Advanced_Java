package concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class LocksDemo {
    private Counter counter = new Counter();
    private SyncCounter scounter = new SyncCounter();
    private AtomicCounter acounter = new AtomicCounter();
    private LockedCounter lcounter = new LockedCounter();

    public void demoCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(counter::increment));
        service.shutdown();
        System.out.println("Counter count=" + counter.getCount());
    }

    public void demoSyncCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(scounter::increment));
        service.shutdown();
        System.out.println("SynchCounter count=" + scounter.getCount());
    }

    public void demoAtomicCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(acounter::increment));
        service.shutdown();
        System.out.println("AtomicCounter count=" + acounter.getCount());
    }

    public void demoLockedCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(lcounter::increment));
        service.shutdown();
        System.out.println("LockedCounter count=" + lcounter.getCount());
    }
    public static void main(String[] args) {
        LocksDemo demo = new LocksDemo();
        demo.demoCounter();
        demo.demoSyncCounter();
        demo.demoLockedCounter();
        demo.demoAtomicCounter();
    }
}
