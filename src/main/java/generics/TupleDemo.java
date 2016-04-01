package generics;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TupleDemo {
    public static void main(String[] args) {
        Tuple<Integer, String> tuple = new Tuple<>(1, "hello");
        System.out.println(tuple);

        Tuple<LocalDate, List<String>> tuple1 =
                new Tuple<>(LocalDate.now(), Arrays.asList("a", "b", "c"));
        System.out.println(tuple1);
    }
}
