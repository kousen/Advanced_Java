package junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ListTestsWithExceptions {
    private List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void defaultListHasSixStrings() {
        assertThat(strings.size(), is(6));
    }

    @Test // old JUnit 3.8
    public void nullListThrowsNPEOldStyle() {
        strings = null;
        try {
            strings.add("hello");
            fail("Should have thrown an NPE");
        } catch (NullPointerException e) {
            assertNull(strings);
        }
    }

    @Test(expected = NullPointerException.class)
    public void nullListThrowsNPE() {
        strings = null;
        strings.add("hello");
    }

    @Test
    public void nullListThrowsNPEUsingRule() {
        String[] stringArray = strings.toArray(new String[0]);
        thrown.expect(ArrayIndexOutOfBoundsException.class);
        thrown.expectMessage("7");
        System.out.println(stringArray[7]);
    }
}
