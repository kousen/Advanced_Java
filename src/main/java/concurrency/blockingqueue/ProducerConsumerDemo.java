package concurrency.blockingqueue;

import java.util.concurrent.*;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        Producer p1 = new Producer(1, queue);
        Producer p2 = new Producer(2, queue);
        Consumer c1 = new Consumer(1, queue);
        Consumer c2 = new Consumer(2, queue);

        ExecutorService service = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors());
        service.execute(p1);
        service.execute(p2);
        service.execute(c1);
        service.execute(c2);
        service.shutdown();
    }
}
