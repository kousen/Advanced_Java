package concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UseExecutors {
    public static void main(String[] args) {
        List<MyRunnable> runnables = Stream.iterate(0, n -> n + 1)
                .map(MyRunnable::new)
                .limit(10)
                .collect(Collectors.toList());

        ExecutorService service = Executors.newCachedThreadPool();
        runnables.forEach(service::execute);

        service.shutdown();
    }
}
