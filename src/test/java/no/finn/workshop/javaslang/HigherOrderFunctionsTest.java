package no.finn.workshop.javaslang;

import java.util.function.Function;

import javaslang.collection.List;
import org.junit.Test;

import static no.finn.workshop.javaslang.LambdaAssert.assertEquality;

public class HigherOrderFunctionsTest {

    @Test
    public void should_compose_two_functions() {
        Function<Integer, Integer> xyFunction = i -> i + 1;
        Function<Integer, String> yzFunction = String::valueOf;
        Function<Integer, String> composed = HigherOrderFunctions.compose(xyFunction, yzFunction);

        assertEquality("2", composed.apply(1), String::equals, "expected a successor function and a String.valueOf function to return 2 given 1");
    }

    @Test
    public void should_compose_a_bunch_of_functions() {
        List<Function<Integer, Integer>> add1Functions = List.fill(10, () -> (i -> i + 1));

        Function<Integer, Integer> add1tenTimes = HigherOrderFunctions.composeAll(add1Functions);

        assertEquality(10, add1tenTimes.apply(0), Integer::equals, "Expected 10 add 1 functions composed to add 10");
    }
}
