package no.finn.workshop.javaslang;

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

    //

    //Tuple

    //Either - Try - Option

    public static void main(String[] args) {

    }





}
