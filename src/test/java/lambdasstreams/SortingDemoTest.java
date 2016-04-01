package lambdasstreams;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class SortingDemoTest {
    private SortingDemo demo = new SortingDemo();

    private void checkAlphabetical(List<String> strings) {
        strings.stream()
                .reduce( (prev, curr) -> {
                            assertTrue(prev.compareTo(curr) <= 0);
                            return curr;
                        }
                );
    }

    private void checkLength(List<String> strings) {
        strings.stream()
                .reduce( (prev, curr) -> {
                            assertTrue(prev.length() <= curr.length());
                            return curr;
                        }
                );
    }

    @Test
    public void testAlphaSort() throws Exception {
        checkAlphabetical(demo.alphaSort());
    }

    @Test
    public void testLengthReverseSortWithComparator() throws Exception {
        List<String> strings = demo.lengthReverseSortWithComparator().stream()
                .sorted((s1, s2) -> -1)
                .collect(Collectors.toList());
        checkLength(strings);
    }

    @Test
    public void testLengthSortWithLambda() throws Exception {
        checkLength(demo.lengthSortWithLambda());
    }

    @Test
    public void testLengthSortUsingCompare() throws Exception {
        checkLength(demo.lengthSortWithLambda());
    }

    @Test
    public void testLengthSortVerbose() throws Exception {
        checkLength(demo.lengthSortWithLambda());
    }

    @Test
    public void testLengthSortComparator() throws Exception {
        checkLength(demo.lengthSortWithLambda());
    }

    @Test
    public void testLengthSortThenAlphaSort() throws Exception {
        demo.lengthSortThenAlphaSort().stream()
                .reduce( (prev, curr) -> {
                    if (prev.length() != curr.length()) {
                        assertTrue(prev.length() <= curr.length());
                    } else {
                        assertTrue(prev.compareTo(curr) <= 0);
                    }
                    return curr;
                });
    }

    @Test
    public void testAlphaSortUsingSorted() throws Exception {
        checkAlphabetical(demo.alphaSortUsingSorted());
    }

    @Test
    public void testLengthSortUsingSorted() throws Exception {
        checkLength(demo.lengthSortWithLambda());
    }

    @Test
    public void testLengthSortThenAlphaSortUsingSorted() throws Exception {
        demo.lengthSortThenAlphaSortUsingSorted().stream()
                .reduce( (prev, curr) -> {
                    if (prev.length() != curr.length()) {
                        assertTrue(prev.length() <= curr.length());
                    } else {
                        assertTrue(prev.compareTo(curr) <= 0);
                    }
                    return curr;
                });
    }
}