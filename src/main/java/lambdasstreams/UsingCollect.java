package lambdasstreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingCollect {
    public static void main(String[] args) {
        int x = 2;
        Stream.of(3, 1, 4, 1, 5, 9)
                .mapToInt( n -> {
                    return n * x;
                } )
                .forEach(System.out::println);

        List<String> strings = Arrays.asList(
                "this", "is", "a", "list", "of", "strings");

        // Side effects --> not what we want
        List<String> evenLengths = new ArrayList<>();
        strings.stream()
                .filter(s -> s.length() % 2 == 0)
                .forEach(evenLengths::add);
        System.out.println(evenLengths);

        // No side-effects
        List<String> evens = strings.stream()
                .filter(s -> s.length() % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evens);
    }
}
