package no.finn.workshop.javaslang;

import javaslang.collection.List;
import javaslang.control.Validation;
import no.finn.workshop.javaslang.things.Ad;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ValidationTasks {

    // The Validation object looks like an Either, but does not short-circut on first left.
    // (This is because a Validation is not a Monad, but an Applicative Functor)
    // return a Validation object of type <List<String>> (errors) or a valid Ad object
    // do this by comining the Validation-objects from the private hejlper methods used on the input parameters
    public static Validation<List<String>, Ad> validateAd(Long adId, String text, Long userId) {
        throw new NotImplementedException();
    }

    // use this on adId and userId
    private static Validation<String, Long> positive(Long x) {
        return x != null && x > 0 ? Validation.valid(x) : Validation.invalid("Expected value to be positive");
    }

    // use this on text
    private static Validation<String, String> nonEmpty(String text) {
        return text != null && !text.isEmpty() ? Validation.valid(text) : Validation.invalid("Text must not be blank");
    }

}
