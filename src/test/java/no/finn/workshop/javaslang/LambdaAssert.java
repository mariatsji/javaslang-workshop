package no.finn.workshop.javaslang;

import javaslang.Function1;

public class LambdaAssert {

    public static final String NEWLINE = System.getProperty("line.separator");

    public static <X> void assertTrue(X parameter, Function1<X, Boolean> assertion, String errorMsg) {
        assert assertion.apply(parameter) : errorMsg;
    }

    public static <X,Y> void assertThatEquals(X parameter, Function1<X, Y> theFunctionTested, Y expectedResult, String errorMsg) {
        assert theFunctionTested.apply(parameter).equals(expectedResult) : String.format("[%s] : " + NEWLINE +
                "expected  : [%s]" + NEWLINE +
                "but found : [%s]", errorMsg, expectedResult, theFunctionTested.apply(parameter));
    }
}
