package no.finn.workshop.javaslang;

import java.util.function.Function;

import javaslang.collection.List;

public class HigherOrderFunctions {

    // Higher Order Functions are when you either return Functions or accept Functions as arguments
    // Function composition F . G with an initial argument (x) is defined as F.apply(G.apply(x))
    // Given a Function of type X -> Y and one Y -> Z use compose to return a Function X -> Z
    public static <X,Y,Z> Function<X,Z> compose(Function<X,Y> first, Function<Y,Z> second) {
        return second.compose(first);
    }

    // using a javaslang List of Functions of type X -> X, compose them all using a fold
    // what is the zero operator for function composition? (for multiplication it would be 1, for addition it would be 0..)
    public static <X> Function<X,X> composeAll(List<Function<X, X>> functions) {
        return functions.fold(Function.identity(), Function::compose);
    }
}
