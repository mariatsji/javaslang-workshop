package no.finn.workshop.javaslang;

import javaslang.test.Gen;
import javaslang.test.Property;
import org.junit.Test;

public class MemoizedTasksTest {

    @Test
    public void should_speed_up_prime_check_using_memoized() {
        Gen<Long> longGen = Gen.choose(10000L, 100000L).filter(x -> x % 2 != 0);
        Property.def("Prime calculation should be memoized")
                .forAll(longGen.arbitrary())
                .suchThat(this::memoizedShouldBeFaster)
                .check()
                .assertIsSatisfied();
    }

    private Boolean memoizedShouldBeFaster(Long testLong) {
        System.out.println("Number to check: " +testLong);
        long before = System.currentTimeMillis();
        MemoizedTasks.isPrimeFunction().apply(testLong);//test run
        long after = System.currentTimeMillis();
        MemoizedTasks.isPrimeFunction().apply(testLong);

        long singleCheckPerformanceUntuned = after - before;

        long testPerformanceBefore = System.currentTimeMillis();
        MemoizedTasks.checkIfPrimeAWholeLot(testLong);
        long testPerformanceAfter = System.currentTimeMillis();
        long performance = testPerformanceAfter - testPerformanceBefore;
        System.out.println("For number: " +testLong + " time spent memoized: " +performance + " \t time spent unmemoized: " +singleCheckPerformanceUntuned);
        return singleCheckPerformanceUntuned * 10 > performance;
    }
}

