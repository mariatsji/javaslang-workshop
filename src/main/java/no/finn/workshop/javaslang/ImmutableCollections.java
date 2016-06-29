package no.finn.workshop.javaslang;

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

    //Tuple

    //Either - Try - Option

    public static void main(String[] args) {

    }





}
