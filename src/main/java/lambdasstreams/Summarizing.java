package lambdasstreams;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Summarizing {
    public static void main(String[] args) {
        DoubleSummaryStatistics stats = Stream.generate(Math::random)
                .limit(1000)
                .collect(Collectors.summarizingDouble(Double::doubleValue));
        System.out.println(stats);
    }
}
