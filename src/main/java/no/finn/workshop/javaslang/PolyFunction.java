package no.finn.workshop.javaslang;

import java.util.function.Function;

import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.collection.Map;
import javaslang.collection.Seq;

public class PolyFunction {

    Map<Integer, Double> poly;

    public PolyFunction(Map<Integer, Double> poly) {
        this.poly = poly;
    }

    public PolyFunction(Seq<Tuple2<Integer, Double>> poly) {
        this(poly.toMap(Function.identity()));
    }

    Integer degree() {
        return poly.fold(Tuple.of(0,0d), (curr, acc) -> curr._2() > acc._2 ? curr : acc)._1;
    }

    Double nr(Integer i) {
        return poly.get(i).getOrElse(0d);
    }

    @Override
    public String toString() {
        return this.poly.map(t -> (t._2 > 0 ? "+" : "-") + t._2 + "x^" + t._1).mkString();
    }

}
