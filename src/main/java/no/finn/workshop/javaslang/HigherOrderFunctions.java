package no.finn.workshop.javaslang;

import java.util.function.Function;

import javaslang.Function1;
import javaslang.Tuple;
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

    // Derive a polynomial function (represented by the PolyFunction class). e.g. : 3.0x^2 + 2.0bx + 1.0 = 0 would be created like this :
    // new PolyFunction(HashMap.of(2, 3.0, 1, 2.0, 0, 1.0));
    public static Function1<PolyFunction, PolyFunction> derive(PolyFunction p) {
        return po -> new PolyFunction(
                p.poly.map(
                        t -> Tuple.of(t._1 > 0 ? t._1 - 1 : 0, t._2 * t._1)));
    }

}
