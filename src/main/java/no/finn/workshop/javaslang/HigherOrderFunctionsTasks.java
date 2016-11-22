package no.finn.workshop.javaslang;

import java.util.function.Function;

import javaslang.Function2;
import javaslang.collection.List;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class HigherOrderFunctionsTasks {

    // Currying (named after Haskell Curry) is the transformation of a FunctionN (that is, has N arguments, or arity N)
    // into a nested Function1 (that is, has only one argument)
    // this makes it possible to partially apply a Function
    // e.g. call a method that take 3 arguments with only 2 arguments, because they are all you know at the moment.
    // Given a Function2 and its first argument, return the curried and partially applied function
    public static Function<Integer, Integer> applyCurried(Function2<Integer, Integer, Integer> func, Integer firstArgument) {
        throw new NotImplementedException();
    }

    // Higher Order Functions are when you either return Functions or accept Functions as arguments
    // Function composition F . G with an initial argument (x) is defined as F.apply(G.apply(x))
    // Given a Function of type X -> Y and one Y -> Z use compose to return a Function X -> Z
    public static <X,Y,Z> Function<X,Z> compose(Function<X,Y> first, Function<Y,Z> second) {
        throw new NotImplementedException();
    }

    // using a javaslang List of Functions of type X -> X, compose them all using a fold
    // what is the zero operator for function composition? (for multiplication it would be 1, for addition it would be 0..)
    public static <X> Function<X,X> composeAll(List<Function<X, X>> functions) {
        throw new NotImplementedException();
    }

    // Derive a polynomial function (represented by the PolyFunction class). e.g. : 3.0x^2 + 2.0bx + 1.0 = 0 would be created like this :
    // new PolyFunction(HashMap.of(2, 3.0, 1, 2.0, 0, 1.0));
    // Note that you are returning a Function here, (not just the derived PolyFunction)
    // This can be achieved by wrapping it all in a lambda
    public static Function<PolyFunction, PolyFunction> derive(PolyFunction p) {
        throw new NotImplementedException();
    }

}
