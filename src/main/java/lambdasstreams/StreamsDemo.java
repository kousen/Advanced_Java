package lambdasstreams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.math.BigDecimal.ONE;

public class StreamsDemo {
    private List<String> strings = Arrays.asList("this", "is", "a",
            "list", "of", "strings");

    public String joinStream() {
        return Stream.of("this", "is", "a", "stream", "of", "strings")
                .collect(Collectors.joining(" "));
    }

    public String joinUpperCase() {
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(" "));
    }

    public int getTotalLength() {
        return strings.stream()
                .collect(Collectors.summingInt(String::length));
    }

    public double sumFirstNBigDecimals(int num) {
        return Stream.iterate(ONE, val -> val.add(ONE))
                .limit(num)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();
    }

    public Double sumRandoms1(int num) {
        return Stream.generate(Math::random)
                .limit(num)
                .reduce(Double::sum)
                .orElse(0.0);
    }

    public Double sumRandoms2(int num) {
        return Stream.generate(Math::random)
                .limit(num)
                .reduce((acc, n) -> {
                    System.out.printf("Acc=%s, n=%s%n", acc, n);
                    return acc + n;
                })
                .orElse(0.0);
    }

    public Double sumRandoms3(int num) {
        Random r = new Random();
        return r.doubles()
                .limit(num)
                .sum();
    }
}
