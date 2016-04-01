package concurrency.callables;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FileLinesCounter {
    private Path dir = Paths.get("src", "main", "java", "concurrency");

    public long computeTotalNumberOfLines() {
        long total = 0;
        try {
            total = executeCounters().stream()
                    .mapToLong(this::extractValueFromFuture)
                    .sum();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return total;
    }

    private List<Future<Long>> executeCounters()
            throws InterruptedException, IOException {

        ExecutorService service = Executors.newCachedThreadPool();
        List<Future<Long>> futures = service.invokeAll(getFileLineCounters());
        service.shutdown();

        return futures;
    }

    private List<Callable<Long>> getFileLineCounters() throws IOException {
        return Files.list(dir)
                .filter(Files::isRegularFile)
                .map(this::callablePrintingCounter)
                .collect(Collectors.toList());
    }

    private Callable<Long> callableCounter(Path p) {
        return () -> Files.lines(p).count();
    }

    private Callable<Long> callablePrintingCounter(Path p) {
        return () -> {
            long count = Files.lines(p).count();
            System.out.printf("%s has %d lines%n", p, count);
            return count;
        };
    }

    // Future get() throws exceptions, so catch them here
    private <T> T extractValueFromFuture(Future<T> future) {
        T val = null;
        try {
            val = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return val;
    }

    public static void main(String[] args) {
        FileLinesCounter demo = new FileLinesCounter();
        System.out.printf("Total number of lines: %d%n",
                demo.computeTotalNumberOfLines());
    }
}
