package lambdasstreams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionsDemo {
    private List<Integer> nums = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5,
            3, 5, 8, 9, 7, 9, 3, 2, 3, 8, 4, 6, 2, 6, 4, 3, 3);

    private Function<Integer, Integer> doubler = n -> n * 2;

    private Function<Integer, Integer> doublerWithSleep = n -> {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        return n * 2;
    };

    public void printNums(Function<Integer, Integer> function) {
        System.out.println(nums.stream()
                .map(function)
                .collect(Collectors.toList()));
    }

    public void printNumsParallel(Function<Integer, Integer> function) {
        System.out.println(nums.parallelStream()
                .map(function)
                .collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        CollectionsDemo demo = new CollectionsDemo();

        long start = System.nanoTime();
        demo.printNums(demo.doubler);
        long end = System.nanoTime();
        System.out.println("Time taken: " + (end - start)/1e9);

        start = System.nanoTime();
        demo.printNums(demo.doublerWithSleep);
        end = System.nanoTime();
        System.out.println("Time taken: " + (end - start)/1e9);

        start = System.nanoTime();
        demo.printNumsParallel(demo.doublerWithSleep);
        end = System.nanoTime();
        System.out.println("Time taken: " + (end - start)/1e9);
    }
}
