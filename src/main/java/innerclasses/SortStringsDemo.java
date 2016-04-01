package innerclasses;

import java.util.Arrays;
import java.util.List;

public class SortStringsDemo {
    public static void main(String[] args) {
        StringSorter ss = new StringSorter();
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
        ss.setStrings(strings);
        System.out.println(strings);
        System.out.println("After sorting:");
        System.out.println(ss.lengthSort());
        System.out.println("After reverse sorting:");
        System.out.println(ss.lengthReverseSortWithStreams());

    }
}
