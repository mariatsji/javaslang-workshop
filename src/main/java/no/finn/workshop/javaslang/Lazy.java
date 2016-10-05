package no.finn.workshop.javaslang;

import javaslang.collection.List;

public class Lazy {

    public static void main(String[] args) {
        Lazy lazy = new Lazy();
        lazy.go();

    }

    private void go() {
        List<Integer> take = List.fill(0, () -> 1).take(10);
        take.forEach(System.out::println);
    }
}
