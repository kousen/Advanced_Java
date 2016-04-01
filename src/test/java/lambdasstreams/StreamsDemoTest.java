package lambdasstreams;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static spock.util.matcher.HamcrestMatchers.closeTo;

public class StreamsDemoTest {
    private StreamsDemo demo = new StreamsDemo();

    @Test
    public void testJoinStream() {
        assertEquals("this is a stream of strings", demo.joinStream());
    }

    @Test
    public void testJoinUpperCase() throws Exception {
        assertEquals("THIS IS A LIST OF STRINGS", demo.joinUpperCase());
    }

    @Test
    public void testGetTotalLength() throws Exception {
        assertEquals(20, demo.getTotalLength());
    }

    @Test
    public void testSumFirstNBigDecimals() throws Exception {
        assertThat(demo.sumFirstNBigDecimals(10), is(closeTo(
                1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10, 0.00001
        )));
    }

    @Test
    public void testSumRandoms1() throws Exception {
        int num = 1000;
        double err = num * 0.05;
        assertThat(demo.sumRandoms1(num), is(closeTo(num/2, err)));
    }

    @Test
    public void testSumRandoms2() throws Exception {
        int num = 1000;
        double err = num * 0.05;
        assertThat(demo.sumRandoms2(num), is(closeTo(num/2, err)));
    }

    @Test
    public void demoReduceWithAccumulator() {
        demo.sumRandoms2(10);
    }

    @Test
    public void testSumRandoms3() throws Exception {
        int num = 1000;
        double err = num * 0.05;
        assertThat(demo.sumRandoms3(num), is(closeTo(num / 2, err)));
    }
}