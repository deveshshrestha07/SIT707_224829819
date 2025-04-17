package sit707_week6;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LoopCoverageUtilsTest {

    @Test
    public void testSumUpToN5() {
        assertEquals(15, LoopCoverage.sumUpToN(5));
    }

    @Test
    public void testSumUpToN0() {
        assertEquals(0, LoopCoverage.sumUpToN(0));
    }

    @Test
    public void testSumUpToN1() {
        assertEquals(1, LoopCoverage.sumUpToN(1));
    }

    @Test
    public void testCountEvenInMixedArray() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        assertEquals(3, LoopCoverage.countEvenNumbers(arr));
    }

    @Test
    public void testCountEvenInAllOddArray() {
        int[] arr = {1, 3, 5, 7};
        assertEquals(0, LoopCoverage.countEvenNumbers(arr));
    }

    @Test
    public void testCountEvenInEmptyArray() {
        int[] arr = {};
        assertEquals(0, LoopCoverage.countEvenNumbers(arr));
    }
}
