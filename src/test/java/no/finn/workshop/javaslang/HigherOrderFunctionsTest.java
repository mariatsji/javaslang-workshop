package no.finn.workshop.javaslang;

import java.util.function.Function;

import javaslang.Function1;
import javaslang.collection.HashMap;
import javaslang.collection.List;
import org.junit.Test;

import static no.finn.workshop.javaslang.LambdaAssert.assertEquality;
import static no.finn.workshop.javaslang.LambdaAssert.assertTrue;

public class HigherOrderFunctionsTest {

    @Test
    public void should_compose_two_functions() {
        Function<Integer, Integer> xyFunction = i -> i + 1;
        Function<Integer, String> yzFunction = String::valueOf;
        Function<Integer, String> composed = HigherOrderFunctionsTasks.compose(xyFunction, yzFunction);

        assertEquality("2", composed.apply(1), String::equals, "expected a successor function and a String.valueOf function to return 2 given 1");
    }

    @Test
    public void should_compose_a_bunch_of_functions() {
        List<Function<Integer, Integer>> add1Functions = List.fill(10, () -> (i -> i + 1));

        Function<Integer, Integer> add1tenTimes = HigherOrderFunctionsTasks.composeAll(add1Functions);

        assertEquality(10, add1tenTimes.apply(0), Integer::equals, "Expected 10 add 1 functions composed to add 10");
    }

    @Test
    public void should_derive_a_poly_function() {
        PolyFunction polyFunction = new PolyFunction(HashMap.of(2, 3.0, 1, 2.0, 0, 1.0));

        Function1<PolyFunction, PolyFunction> derive = HigherOrderFunctionsTasks.derive(polyFunction);

        PolyFunction derived = derive.apply(polyFunction);

        System.out.println(polyFunction);
        System.out.println(derived);

        assertTrue(derived.degree(), i -> polyFunction.degree() - i == 1, "Expected derived function of poly with degree n to be of degree n - 1");
        assertTrue(derived, p -> p.nr(1) == 6d, "Expected 6.0 x ^ 1 after deriving 3.0x^2 + 2.0x + 1");
        assertTrue(derived, p -> p.nr(0) == 2d, "Expected 2.0 x ^ 0 after deriving 3.0x^2 + 2.0x + 1");
    }
}
