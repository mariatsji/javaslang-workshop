package no.finn.workshop.javaslang;

import java.util.function.Predicate;

import javaslang.Function1;
import javaslang.Tuple2;
import javaslang.collection.Array;
import javaslang.collection.HashMap;
import javaslang.collection.List;
import javaslang.collection.Stream;
import javaslang.collection.TreeSet;
import javaslang.collection.Vector;
import no.finn.workshop.javaslang.things.Age;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ImmutableCollectionsTasks {

    //List
    public static <T> List<T> createFrom(java.util.List<T> aList) {
        throw new NotImplementedException();
    }

    //List
    public static <T> List<T> createFromAll(T... objects) {
        throw new NotImplementedException();
    }

    //turn every element of the list into an Age-object
    public static List<Age>  transfomElements(List<Integer> list) {
        throw new NotImplementedException();
    }

    //use the corresponds-method to check that two lists contain the same String when ignoring case
    public static Boolean checkSameStringsIgnoreCase(List<String> first, List<String> second) {
        throw new NotImplementedException();
    }

    //create a new Tuple2 from arguments
    public static Tuple2<String, Integer> createTupleFrom(String a, Integer b) {
        throw new NotImplementedException();
    }

    //how to call a function for every entry?
    public static List<Integer> doubleEveryInt(List<Integer> ints) {
        throw new NotImplementedException();
    }

    //how to keep some values and drop some values based on a predicate?
    public static List<Integer> retainOddNumbers(List<Integer> ints) {
        throw new NotImplementedException();
    }

    //flip every other (element that has even index (0 based)) tuple in a list. zipWithIndex might come in handy.
    public static List<Tuple2<Integer, Integer>> flipEveryOther(List<Tuple2<Integer, Integer>> ints) {
        throw new NotImplementedException();
    }

    //flip a tuple
    private static <A,B> Tuple2<B,A> flip(Tuple2<A,B> t) {
        throw new NotImplementedException();
    }

    //Make this function return a Tuple2(a,b+10) (keep first element (String) and add 10 to second element (Integer))
    public static Tuple2<String, Integer> transformTuple(Tuple2<String, Integer> theTuple) {
        throw new NotImplementedException();
    }

    //create a javaslang HashMap
    public static <A,B> HashMap<A,B> toJavaslangMap(java.util.Map<? extends A, ? extends B> map) {
        throw new NotImplementedException();
    }

    //create a javaslang HashSet
    public static <A> javaslang.collection.HashSet<A> toJavaslangSet(java.util.Set<A> set) {
        throw new NotImplementedException();
    }

    //create a java.util.List
    public static <A> java.util.List<A> toJavaList(List<A> list) {
        throw new NotImplementedException();
    }

    //create a javaslang Stream of increasing integers from (inclusive) to (inclusive) given start and end-points
    public static Stream<Integer> createStream(Integer fromInclusive, Integer toInclusive) {
        throw new NotImplementedException();
    }

    //create a javaslang List from a java.util.streamStream
    public static <V> List<V> toJavaslangList(java.util.stream.Stream<V> stream) {
        throw new NotImplementedException();
    }

    // Should return a Function1 from Value V to Boolean. True when V exists in set, False otherwise
    public static <V> Function1<V, Boolean> toFunction(javaslang.collection.HashSet<V> set) {
        throw new NotImplementedException();
    }

    // Should return a Function1 from Value V to Key K
    public static <K,V> Function1<K,V> toFunction(javaslang.collection.HashMap<K,V> map) {
        throw new NotImplementedException();
    }

    // Sum ints in a javaslang HashSet
    public static Integer sum(javaslang.collection.HashSet<Integer> ints) {
        throw new NotImplementedException();
    }

    // make a javaslang list from a javaslang set
    public static <A> List<A> toList(javaslang.collection.HashSet<A> set) {
        throw new NotImplementedException();
    }

    // make a javaslang Vector of doubles
    // Vectors - are balanced when it comes to performance of insert, delete and query
    public static Vector<Double> toVector(Double... doubles) {
        throw new NotImplementedException();
    }

    // make a javaslang Array of the english alfabet
    // Arrays, unlike List can insert and delete values in constant time
    public static Array<Character> alfabet() {
        throw new NotImplementedException();
    }

    // Sort characters using the javaslang TreeSet
    public static List<Character> sort(Character... chars) {
        throw new NotImplementedException();
    }

    // Find the intersection between two trees
    public static <X> TreeSet<X> intersection(TreeSet<X> first, TreeSet<X> second) {
        throw new NotImplementedException();
    }

    // split a tree using a predicate
    public static <X> Tuple2<TreeSet<X>, TreeSet<X>> split(TreeSet<X> tree, Predicate<X> predicate) {
        throw new NotImplementedException();
    }

}
