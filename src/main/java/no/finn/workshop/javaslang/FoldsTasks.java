package no.finn.workshop.javaslang;

import java.util.function.BiFunction;

import javaslang.collection.List;

public class FoldsTasks {

    public static Double sumAListUsingFold(List<Double> list) {
        return list.fold(0d, Double::sum);
    }

    //Reverse a list using foldRight
    public static <X> List<X> reverseRight(List<X> original) {
        BiFunction<X, List<X>, List<X>> f = (X curr, List<X> acc) -> acc.append(curr);
        return original.foldRight(List.empty(), f);
    }

    //Reverse a list using foldLeft
    public static <X> List<X> reverseLeft(List<X> original) {
        BiFunction<List<X>, X, List<X>> f = (List<X> acc, X curr) -> acc.prepend(curr);
        return original.foldLeft(List.empty(), f);
    }

}
