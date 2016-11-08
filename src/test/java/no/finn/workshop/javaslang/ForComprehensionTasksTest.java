package no.finn.workshop.javaslang;

import java.util.function.Function;

import javaslang.collection.List;
import javaslang.control.Either;
import javaslang.control.Option;
import javaslang.control.Try;
import javaslang.test.Gen;
import javaslang.test.Property;
import no.finn.workshop.javaslang.things.Triangle;
import org.junit.Test;

import static javaslang.API.For;
import static no.finn.workshop.javaslang.LambdaAssert.assertTrue;

public class ForComprehensionTasksTest {

    @Test
    public void should_concatenate_string_value_of_success_right_and_some() {
        String actual = ForComprehensionTasks.concatenate(Try.of(() -> "t"), Either.right("e"), Option.of("o"));

        assertTrue(actual, "teo"::equals, "Expected Success(t), Right(e), Option(o) to form 'teo'");
    }

    @Test
    public void should_ignore_failure_left_and_none_when_concatenating() {
        String actual = ForComprehensionTasks.concatenate(Try.failure(new RuntimeException()), Either.left(0), Option.none());

        assertTrue(actual, ""::equals, "Expected Failure, Left and None to form a blank String");
    }

    @Test
    public void should_find_at_least_one_triangle() {
        Iterable<Triangle> actual = ForComprehensionTasks.combinations(List.rangeClosed(1, 10).map(Double::valueOf),
                List.rangeClosed(1, 10).map(Double::valueOf),
                List.rangeClosed(1, 10).map(Double::valueOf));

        assertTrue(actual, a -> a.iterator().hasNext(), "Expected at least 1 triangle to meet the criterias listed in the task");
    }

    @Test
    public void should_find_all_right_rectangles_with_circumference_lt_or_eq_to_25() {
        Gen<Double> a = Gen.choose(0, 10).map(Double::valueOf);
        Gen<Double> b = Gen.choose(0, 10).map(Double::valueOf);
        Gen<Double> c = Gen.choose(0, 10).map(Double::valueOf);

        Gen<Iterable<Triangle>> triangles = a.flatMap(a1 ->
                b.flatMap(b1 ->
                        c.map(c1 ->
                                ForComprehensionTasks.combinations(List.of(a1), List.of(b1), List.of(c1)))));

        Property.def("is a right triangle (a^2 + b^2 = c^2)")
                .forAll(triangles.arbitrary())
                .suchThat(this::allArePythagorasFriendly)
                .check()
                .assertIsSatisfied();

        Property.def("has circumference <= 25")
                .forAll(triangles.arbitrary())
                .suchThat(this::allAreBelow25)
                .check()
                .assertIsSatisfied();

        Property.def("all sides > 0")
                .forAll(triangles.arbitrary())
                .suchThat(this::allPositiveSides)
                .check()
                .assertIsSatisfied();

    }

    private Boolean allArePythagorasFriendly(Iterable<Triangle> triangles) {
        return For(triangles)
                .yield(Function.identity())
                .forAll(t -> new Double(Math.pow(t.a(), 2) + Math.pow(t.b(), 2)).equals(Math.pow(t.c(), 2)));
    }

    private Boolean allAreBelow25(Iterable<Triangle> triangles) {
        return For(triangles)
                .yield(Function.identity())
                .forAll(t -> t.circumference() <= 25);
    }

    private Boolean allPositiveSides(Iterable<Triangle> triangles) {
        return For(triangles)
                .yield(Function.identity())
                .forAll(t -> t.a() > 0 && t.b() > 0 && t.c() > 0);
    }



}
