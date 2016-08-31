package no.finn.workshop.javaslang;

import java.util.function.Predicate;

import javaslang.Function2;
import javaslang.control.Option;

import static javaslang.API.$;
import static javaslang.API.Case;
import static javaslang.API.Match;

public class PatternMatching {

    public static void main(String[] args) {
        String id = new PatternMatching().identifyNumeric(new Double(3));

        System.out.println(id);
    }

    public String identifyNumeric(Object o) {
        Function2<Integer, Integer, Integer> func = (a, b) -> a + b;
        Function2<Integer, Integer, Option<Integer>> lifted = Function2.lift(func);


        Predicate<Object> isInteger = x -> x instanceof Integer;
        Predicate<Object> isDouble = x -> x instanceof Double;
        Predicate<Object> isLong = x -> x instanceof Long;
        Predicate<Object> isFloat = x -> x instanceof Float;


        return Match(o).of(
                Case(isInteger, "Integer"),
                Case(isDouble, "Double"),
                Case(isLong, "Long"),
                Case(isFloat, "Float"),
                Case($(), "not numeric")
        );

    }
}
