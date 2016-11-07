package no.finn.workshop.javaslang;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaAssert {

    public static final String NEWLINE = System.getProperty("line.separator");

    public static <X> void assertTrue(X parameter, Function<X, Boolean> assertion, String errorMsg) {
        assert assertion.apply(parameter) : errorMsg;
    }

    public static <X> void assertEquality(X expected, X actual, BiFunction<X,X,Boolean> equalityPredicate, String errorMsg) {
        assert equalityPredicate.apply(expected, actual) : String.format("[%s] : " + NEWLINE +
                "expected  : [%s]" + NEWLINE +
                "but found : [%s]", errorMsg, expected, actual);
    }
}
