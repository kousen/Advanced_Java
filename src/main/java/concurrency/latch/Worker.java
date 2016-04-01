package concurrency.latch;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
    private int id;
    private CountDownLatch startSignal;
    private CountDownLatch endSignal;

    public Worker(int id, CountDownLatch startSignal, CountDownLatch endSignal) {
        this.id = id;
        this.startSignal = startSignal;
        this.endSignal = endSignal;
    }

    @Override
    public void run() {
        try {
            System.out.printf("%d waiting to start...%n", id);
            startSignal.await();
            System.out.printf("%d running to completion%n", id);
            endSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
