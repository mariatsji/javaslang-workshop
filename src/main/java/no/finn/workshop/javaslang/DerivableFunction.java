package no.finn.workshop.javaslang;

import java.util.function.*;

import javaslang.collection.List;

public class DerivableFunction implements Function<Double,Double> {

    public final List<Double> poly;

    public DerivableFunction(Double... n) {
        poly = List.of(n);
    }

    public Double apply(Double x) {
        return poly.reverse().zipWithIndex().reverse().map(t -> t._1 * Math.pow(x, t._2)).sum().doubleValue();
    }

}
