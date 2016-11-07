package no.finn.workshop.javaslang;

import javaslang.Function1;
import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.collection.HashMap;
import javaslang.collection.HashSet;
import javaslang.collection.List;
import no.finn.workshop.javaslang.things.Age;

public class ImmutableCollectionsTasks {

    //List
    public static <T> List<T> createFrom(java.util.List<T> aList) {
        return List.ofAll(aList);
    }

    //List
    public static <T> List<T> createFromAll(T... objects) {
        return List.of(objects);
    }

    //turn every element of the list into an Age-object
    public static List<Age>  transfomElements(List<Integer> list) {
        return list.map(Age::new);
    }

    //use the corresponds-method to check that two lists contain the same String when ignoring case
    public static Boolean checkSameStringsIgnoreCase(List<String> first, List<String> second) {
        return first.corresponds(second, String::equalsIgnoreCase);
    }

    //create a new Tuple2 from arguments
    public static Tuple2<String, Integer> createTupleFrom(String a, Integer b) {
        return Tuple.of(a, b);
    }

    //how to call a function for every entry?
    public static List<Integer> doubleEveryInt(List<Integer> ints) {
        return ints.map(i -> i * 2);
    }

    //how to keep some values and drop some values based on a predicate?
    public static List<Integer> retainOddNumbers(List<Integer> ints) {
        return ints.filter(i -> i % 2 == 1);
    }

    //flip every other (element that has even index (0 based)) tuple in a list. zipWithIndex might come in handy.
    public static List<Tuple2<Integer, Integer>> flipEveryOther(List<Tuple2<Integer, Integer>> ints) {
        return ints.zipWithIndex()
                .map(t -> t._2 % 2 == 0 ? flip(t._1) : t._1);
    }

    //flip a tuple
    private static <A,B> Tuple2<B,A> flip(Tuple2<A,B> t) {
        return Tuple.of(t._2, t._1);
    }

    //Make this function return a Tuple2(a,b+10) (keep first element (String) and add 10 to second element (Integer))
    public static Tuple2<String, Integer> transformTuple(Tuple2<String, Integer> theTuple) {
        return theTuple.map((a, b) -> Tuple.of(a, b + 10));
    }

    //create a javaslang HashMap
    public static <A,B> HashMap<A,B> toJavaslangMap(java.util.Map<? extends A, ? extends B> map) {
        return HashMap.ofAll(map);
    }

    //create a javaslang HashSet
    public static <A> javaslang.collection.HashSet<A> toJavaslangSet(java.util.Set<A> set) {
        return HashSet.ofAll(set);
    }

    //create a java.util.List
    public static <A> java.util.List<A> toJavaList(List<A> list) {
        return list.toJavaList();
    }

    // Should return a Function1 from Value V to Boolean. True when V exists in set, False otherwise
    public static <V> Function1<V, Boolean> toFunction(javaslang.collection.HashSet<V> set) {
        return set;
    }

    // Should return a Function1 from Value V to Key K
    public static <K,V> Function1<K,V> toFunction(javaslang.collection.HashMap<K,V> map) {
        return map;
    }

    // Sum ints in a javaslang HashSet
    public static Integer sum(javaslang.collection.HashSet<Integer> ints) {
        return ints.sum().intValue();
    }

    // make a javaslang list from a javaslang set
    public static <A> List<A> toList(javaslang.collection.HashSet<A> set) {
        return set.toList();
    }

}
