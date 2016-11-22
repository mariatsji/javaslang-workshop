package no.finn.workshop.javaslang;

import java.util.function.Function;

import javaslang.collection.List;
import javaslang.collection.Seq;
import javaslang.control.Either;
import javaslang.control.Option;
import javaslang.control.Try;
import no.finn.workshop.javaslang.things.PersonServiceImpl;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class TryEitherOptionTasks {

    //Create an Either.Left of an empty Option<String>
    public static Either<Option<String>, Option<Integer>> weirdEither() {
        throw new NotImplementedException();
    }

    //Create a Success (Try) of type Option(4) (Option<Integer>)
    public static Try<Option<Integer>> maybeIntegerAttempt() {
        throw new NotImplementedException();
    }

    //Transform a Try to an Option that is Present on Success and absent on Failure
    public static <A> Option<A> toOption(Try<A> tryy) {
        throw new NotImplementedException();
    }

    //From a List of personId, use a new PersonService() to return a list of corresponding Addresses (a String)
    //Use an empty String for every missing or failing Address
    public static List<String> getAddresses(List<Long> personIds) {
        PersonServiceImpl personService = new PersonServiceImpl();

        throw new NotImplementedException();
    }

    // apply two unsafe functions and return the Try of the result (first apply seed to unsafeFunction1, then apply result to unsafeFunction2)
    public static Try<String> combineUnsafeFunctions(Function<Integer, Integer> unsafeFunction1, Function<Integer, String> unsafeFunction2, Integer seed) {
        throw new NotImplementedException();
    }

    // Do the exact same thing, but now use flatMap() if you used map() earlier (or vice versa)
    public static Try<String> combineUnsafeFunctions2(Function<Integer, Integer> unsafeFunction1, Function<Integer, String> unsafeFunction2, Integer seed) {
        throw new NotImplementedException();
    }

    //Given a bunch of tries, construct a Try of a Seq (javaslang sequence) that is a success if the whole bunch is a success,
    // or short-circuits to a Failure if one or more in the bunch is a Failure
    public static <A> Try<Seq<A>> superTry(List<Try<? extends A>> tries) {
        throw new NotImplementedException();
    }
}
