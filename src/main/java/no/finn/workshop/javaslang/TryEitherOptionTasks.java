package no.finn.workshop.javaslang;

import java.util.function.Function;

import javaslang.collection.List;
import javaslang.collection.Seq;
import javaslang.control.Either;
import javaslang.control.Option;
import javaslang.control.Try;

public class TryEitherOptionTasks {

    //Create an Either.Left of an empty Option<String>
    public static Either<Option<String>, Option<Integer>> weirdEither() {
        return Either.left(Option.none());
    }

    //Create a Success (Try) of type Option(4) (Option<Integer>)
    public static Try<Option<Integer>> maybeIntegerAttempt() {
        return Try.success(Option.of(4));
    }

    //Transform a Try to an Option that is Present on Success and absent on Failure
    public static <A> Option<A> toOption(Try<A> tryy) {
        return tryy.toOption();
    }

    // apply two unsafe functions and return the Try of the result (first apply seed to unsafeFunction1, then apply result to unsafeFunction2)
    public static Try<String> combineUnsafeFunctions(Function<Integer, Integer> unsafeFunction1, Function<Integer, String> unsafeFunction2, Integer seed) {
        return Try.of(() -> unsafeFunction1.apply(seed))
                .map(unsafeFunction2);
    }

    // Do the exact same thing, but now use flatMap() if you used map() earlier (or vice versa)
    public static Try<String> combineUnsafeFunctions2(Function<Integer, Integer> unsafeFunction1, Function<Integer, String> unsafeFunction2, Integer seed) {
        return Try.of(() -> unsafeFunction1.apply(seed))
                .flatMap(i -> Try.of(() -> unsafeFunction2.apply(i)));
    }

    //Given a bunch of tries, construct a Try of a Seq (javaslang sequence) that is a success if the whole bunch is a success,
    // or short-circuits to a Failure if one or more in the bunch is a Failure
    public static <A> Try<Seq<A>> superTry(List<Try<? extends A>> tries) {
        return Try.sequence(tries);
    }
}
