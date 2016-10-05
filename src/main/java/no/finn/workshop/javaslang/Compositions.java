package no.finn.workshop.javaslang;

import java.util.function.Function;

import javaslang.Function2;
import javaslang.collection.List;

public class Compositions {

    public static <X,Y,Z> Function<X,Z> compose(Function<X,Y> first, Function<Y,Z> second) {
        return second.compose(first);
    }

    public <X> Function<X,X> composeAll(List<Function<X, X>> functions) {
        return functions.fold(Function.identity(), Function::compose);
    }

    public static void main(String[] args) {

        Function2<Integer, Integer, Integer> pluss = (a, b) -> a + b;

//        Function2.lift()

        Function<List<String>, String> f = (List<String> s) -> s.fold("", String::concat);
        Function<String, String> g = String::toUpperCase;

        String res = compose(f, g).apply(List.of("a", "b", "c"));

        System.out.println(res);


        Function<Character, Character> h = c -> (char)((int)c + 1);
        Function<Character, Character> res2 = List.of(h, h, h, h, h).fold(Function.identity(), Function::compose);

        System.out.println(res2.apply('a'));

    }

}
