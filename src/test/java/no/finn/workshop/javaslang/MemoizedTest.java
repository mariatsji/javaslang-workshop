package no.finn.workshop.javaslang;

import org.junit.Test;

import static no.finn.workshop.javaslang.LambdaAssert.assertTrue;

public class MemoizedTest {

    @Test
    public void should_speed_up_prime_check_using_memoized() {
        long testLong = 12984L;
        MemoizedTasks.isPrimeFunction().apply(testLong);//test run
        long before = System.currentTimeMillis();
        MemoizedTasks.isPrimeFunction().apply(testLong);
        long after = System.currentTimeMillis();

        long singleCheckPerformanceUntuned = after - before;

        long testPerformanceBefore = System.currentTimeMillis();
        MemoizedTasks.checkIfPrimeAWholeLot(testLong);
        long testPerformanceAfter = System.currentTimeMillis();

        long performance = testPerformanceAfter - testPerformanceBefore;
        assertTrue(singleCheckPerformanceUntuned, l -> l * 10 > performance,
                String.format("Tuning does not seem to be suffiient for single prime check milliseconds %d and 100-time-invokation-ms-duration of %d", singleCheckPerformanceUntuned, performance));
    }
}
