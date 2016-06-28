package no.finn.workshop.javaslang;

import javaslang.Function1;
import javaslang.Function2;

public class LambdaAssert {

    public static final String NEWLINE = System.getProperty("line.separator");

    public static <X> void assertTrue(X parameter, Function1<X, Boolean> assertion, String errorMsg) {
        assert assertion.apply(parameter) : errorMsg;
    }

    public static <X> void assertEquality(X expected, X actual, Function2<X,X,Boolean> equalityPredicate, String errorMsg) {
        assert equalityPredicate.apply(expected, actual) : String.format("[%s] : " + NEWLINE +
                "expected  : [%s]" + NEWLINE +
                "but found : [%s]", errorMsg, expected, actual);
    }
}
