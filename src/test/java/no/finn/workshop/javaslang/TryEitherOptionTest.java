package no.finn.workshop.javaslang;

import javaslang.Function1;
import javaslang.collection.List;
import javaslang.collection.Seq;
import javaslang.control.Either;
import javaslang.control.Option;
import javaslang.control.Try;
import org.junit.Test;

import static no.finn.workshop.javaslang.LambdaAssert.assertEquality;
import static no.finn.workshop.javaslang.LambdaAssert.assertTrue;

public class TryEitherOptionTest {

    @Test
    public void should_create_a_left_with_empty_option() {
        Either<Option<String>, Option<Integer>> options = TryEitherOptionTasks.weirdEither();
        assertTrue(options, Either::isLeft, "expected Either to be a Left");
        assertEquality(Option.none(), options.getLeft(), Option::equals,
                "expected Left to contain Option.none()");
    }

    @Test
    public void should_create_a_try_containing_option_4_value() {
        Try<Option<Integer>> attempt = TryEitherOptionTasks.maybeIntegerAttempt();
        assertTrue(attempt, Try::isSuccess, "expected try to be a success");
        assertEquality(Try.success(Option.of(4)), attempt, Try::equals,
                "expected Try to be a Success of Option<4> (Integer)");
    }

    @Test
    public void should_create_an_option_from_a_try() {
        Option<Object> absent = TryEitherOptionTasks.toOption(Try.failure(new Exception()));
        assertEquality(Option.none(), absent, Option::equals, "Expected Failure to result in empty Option");
    }

    @Test
    public void should_create_a_try_seq_from_a_seq_try(){
        List<Try<?>> tries = List.of(Try.success(1), Try.failure(new Exception()), Try.success(3));
        Try<Seq<Object>> seq = TryEitherOptionTasks.superTry(tries);
        assertTrue(seq, Try::isFailure, "Expected List(Success,Failure,Success) to be a Failure after sequencing");

        List<Try<?>> seq2 = List.of(Try.success(1), Try.success(2));
        Try<Seq<Object>> seqs = TryEitherOptionTasks.superTry(seq2);
        assertTrue(seqs, Try::isSuccess, "Expected List(Success,Success) to be a Sucess after sequencing");
    }

    @Test
    public void should_map_two_tries() {
        Function1<Integer, Integer> a = i -> i / 0;
        Function1<Integer, String> b = String::valueOf;
        Try<String> string = TryEitherOptionTasks.combineUnsafeFunctions(a, b, 10);

        assertTrue(string, Try::isFailure, "Expected Failure for a function that divides by zero");
    }

    @Test
    public void should_map_two_tries_again() {
        Function1<Integer, Integer> a = i -> i / 2;
        Function1<Integer, String> b = String::valueOf;
        Try<String> string = TryEitherOptionTasks.combineUnsafeFunctions2(a, b, 10);

        assertTrue(string, Try::isSuccess, "Expected Success for a function that divides by 2 and a function String::valueOf");
        assertEquality("5", string.get(), String::equals, "Expected Success for a function that divides by two and a function String::valueOf");
    }


}
