package concurrency;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UseMyThread {
    public static void main(String[] args) {
        List<MyThread> threads = Stream.iterate(0, n -> n + 1)
                .map(MyThread::new)
                .limit(10)
                .collect(Collectors.toList());

        threads.forEach(MyThread::start);
    }
}
