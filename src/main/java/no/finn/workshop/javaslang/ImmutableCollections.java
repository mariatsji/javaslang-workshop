package no.finn.workshop.javaslang;

import java.util.function.BiFunction;

import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.collection.List;
import no.finn.workshop.javaslang.things.Age;

public class ImmutableCollections {

    //List
    public static <T> List<T> createFrom(java.util.List<T> aList) {
        return List.ofAll(aList);
    }

    //turn every element of the list into an Age-object
    public static List<Age>  transfomElements(List<Integer> list) {
        return list.map(Age::new);
    }

    //use the corresponds-method to check that two lists contain the same String when ignoring case
    public static Boolean checkSameStringsIgnoreCase(List<String> first, List<String> second) {
        return first.corresponds(second, String::equalsIgnoreCase);
    }

    public static Tuple2<String, Integer> createTupleFrom(String a, Integer b) {
        return new Tuple2<String, Integer>(a, b);
    }

    //flip every other (element that has even index (0 based)) tuple in a list. zipWithIndex might come in handy.
    public static List<Tuple2<Integer, Integer>> flipEveryOther(List<Tuple2<Integer, Integer>> ints) {
        return ints.zipWithIndex()
                .map(t -> t._2 % 2 == 0 ? flip(t._1) : t._1);
    }

    private static <A,B> Tuple2<B,A> flip(Tuple2<A,B> t) {
        return Tuple.of(t._2, t._1);
    }
    //

    //Make this function return a Tuple2(a,b+10) (keep first element (String) and add 10 to second element (Integer))
    public static Tuple2<String, Integer> transformTuple(Tuple2<String, Integer> theTuple) {
        return theTuple.map((a, b) -> Tuple.of(a, b + 10));
    }

    //Provide a function that returns a Tuple2(10,10)
    public static Tuple2<Integer, Integer> mapTupleWith(BiFunction<Integer, Integer, Tuple2<Integer, Integer>> func) {
        Tuple2<Integer, Integer> theOrigoTuple = Tuple.of(0, 0);
        return theOrigoTuple.map(func);
    }

    //Immutable map, set

    //Either - Try - Option

    public static void main(String[] args) {

    }





}
