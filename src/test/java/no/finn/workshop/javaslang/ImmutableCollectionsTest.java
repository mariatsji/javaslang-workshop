package no.finn.workshop.javaslang;

import java.util.Arrays;

import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.collection.List;
import no.finn.workshop.javaslang.things.Age;
import org.junit.Test;

import static no.finn.workshop.javaslang.LambdaAssert.assertEquality;
import static no.finn.workshop.javaslang.LambdaAssert.assertTrue;

public class ImmutableCollectionsTest {

    @Test
    public void should_create_javaslang_list_from_list() {
        java.util.List<Integer> rawList = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = ImmutableCollections.createFrom(rawList);
        assertTrue(result, l -> l != null && l.nonEmpty(), "createFrom should return a nonempty javaslang List");
        assertTrue(result, l -> l.equals(List.of(1, 2, 3, 4)), "createFrom should return a javaslang List containing 1,2,3,4");
        assertEquality(
                ImmutableCollections.createFrom(rawList),
                List.of(1,2,3,4),
                Object::equals,
                "createFrom should return a javaslang List containing 1,2,3,4"
        );
    }

    @Test
    public void should_map_all_integers_to_age_in_a_list() {
        List<Integer> rawList = List.of(18, 20, 37);
        List<Age> result = ImmutableCollections.transfomElements(rawList);
        assertTrue(result, l -> l != null && l.nonEmpty(), "transformElements should create a List<Age> from List<Integer>");
        assertEquality(
                ImmutableCollections.transfomElements(rawList),
                List.of(new Age(18), new Age(20), new Age(37)),
                Object::equals,
                "transformElements should create List<Age> where each Age match the original Integer"
        );
    }

    @Test
    public void should_check_that_list_of_strings_with_different_caseing_corresponds() {
        List<String> first = List.of("a", "b", "C", "D");
        List<String> second = List.of("A", "B", "c", "d");
        assertTrue(ImmutableCollections.checkSameStringsIgnoreCase(first, second), b -> b,
                "checkSameStringsIgnoreCase should return true when two lists contain equal Strings whith casing ignored");
    }

    @Test
    public void should_create_tuple_from_string_and_int() {
        Tuple2<String, Integer> yo = ImmutableCollections.createTupleFrom("yo", 5);
        assertEquality(new Tuple2<>("yo", 5), yo, Tuple2::equals, "createTupleFrom should create a Tuple2<String, Integer> containing the parameters of the method");
    }

    @Test
    public void should_flip_every_other_tuple_in_a_list_of_tuple2() {
        List<Tuple2<Integer, Integer>> list = List.of(Tuple.of(1, 2), Tuple.of(3, 1), Tuple.of(1, 9), Tuple.of(0, -1));
        List<Tuple2<Integer, Integer>> result = ImmutableCollections.flipEveryOther(list);

        List<Tuple2<Integer, Integer>> expected = List.of(Tuple.of(2, 1), Tuple.of(3, 1), Tuple.of(9, 1), Tuple.of(0, -1));
        assertEquality(expected, result, List::equals, "flipEveryOther should flip every other Tuple2<Integer, Integer> (starting from the first) in a List");
    }




}
