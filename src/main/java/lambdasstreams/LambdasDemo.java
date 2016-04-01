package lambdasstreams;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdasDemo {
    public static void main(String[] args) {
        // forEach takes a Consumer
        Stream.of(3, 1, 4, 1, 5, 9)
                .forEach(n -> System.out.println(n));

        Stream.of(3, 1, 4, 1, 5, 9)
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer);
                    }
                });

        // Define Consumer separately
        Consumer<Integer> printer = n -> System.out.println(n);
        Stream.of(3, 1, 4, 1, 5, 9)
                .forEach(printer);

        System.out.println();
        // Predicate returns boolean
        Predicate<Integer> mod3 = n -> n % 3 == 0;
        Stream.of(3, 1, 4, 1, 5, 9)
                .filter(mod3)
                .forEach(printer);


        System.out.println();
        // Function of one type, returns one type
        Function<Integer, Integer> doubler = n -> n * 2;
        Stream.of(3, 1, 4, 1, 5, 9)
                .map(doubler)
                .filter(mod3)
                .forEach(printer);
    }
}
