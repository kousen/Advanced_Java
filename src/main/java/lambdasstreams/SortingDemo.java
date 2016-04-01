package lambdasstreams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingDemo {
    private List<String> sampleStrings =
            Arrays.asList("this", "is", "a", "list", "of", "strings");

    // Default sort from Java 7-
    public List<String> alphaSort() {
        Collections.sort(sampleStrings);
        return sampleStrings;
    }

    // Java 7- using Comparator
    public List<String> lengthReverseSortWithComparator() {
        Collections.sort(sampleStrings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        return sampleStrings;
    }

    // Using a lambda as a Comparator
    public List<String> lengthSortWithLambda() {
        Collections.sort(sampleStrings,
                (s1, s2) -> s1.length() - s2.length());
        return sampleStrings;
    }

    // Verbose syntax for length sort
    public List<String> lengthSortVerbose() {
        Collections.sort(sampleStrings,
                (String s1, String s2) -> {
                    return Integer.compare(s1.length(), s2.length());
                });
        return sampleStrings;
    }

    // Length sort with comparingInt
    public List<String> lengthSortComparator() {
        Collections.sort(sampleStrings,
                Comparator.comparingInt(String::length));
        return sampleStrings;
    }

    // Length sort, then alphabetical
    public List<String> lengthSortThenAlphaSort() {
        Collections.sort(sampleStrings,
                Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()));
        return sampleStrings;
    }

    // Use sorted to stop modifying collection
    public List<String> alphaSortUsingSorted() {
        return sampleStrings.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // Sort by length with sorted
    public List<String> lengthSortUsingSorted() {
        return sampleStrings.stream()
                .sorted( (s1, s2) -> s1.length() - s2.length() )
                .collect(Collectors.toList());
    }

    // Sort by length then alpha using sorted
    public List<String> lengthSortThenAlphaSortUsingSorted() {
        return sampleStrings.stream()
                .sorted( Comparator.comparing(String::length)
                    .thenComparing(Comparator.naturalOrder()) )
                .collect(Collectors.toList());
    }
}
