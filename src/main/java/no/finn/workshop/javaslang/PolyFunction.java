package no.finn.workshop.javaslang;

import java.util.function.Function;

import javaslang.Function1;
import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.collection.HashMap;
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

    public static void main(String[] args) {
        Map<Integer, Double> map = HashMap.of(2, 5d, 1, 3d, 0, 2d);
        PolyFunction polyFunction = new PolyFunction(map);

        System.out.println(polyFunction.degree());
        System.out.println(polyFunction);

        Function1<PolyFunction, PolyFunction> derive =
                (PolyFunction p) ->
                        new PolyFunction(
                                polyFunction.poly.map(
                                        (Tuple2<Integer, Double> t) -> Tuple.of(t._1 > 0 ? t._1 - 1 : 0, t._2 * t._1)));


        System.out.println(derive.apply(polyFunction));

    }

}
