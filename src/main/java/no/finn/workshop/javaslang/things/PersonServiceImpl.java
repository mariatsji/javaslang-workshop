package no.finn.workshop.javaslang.things;

import java.util.Random;

import javaslang.control.Either;
import javaslang.control.Option;

public class PersonServiceImpl {

    public Either<String, Option<Person>> getPerson(Long personId) {
        if(personId < 0L) {
            return Either.left("Invalid personId");
        } else if (personId < 101L) {
            return Either.right(Option.of(new Person("John Doe " + new Random().nextInt())));
        } else {
            return Either.right(Option.none());
        }
    }

    public String getAddress(Person person) {
        return "Osloveien 1, 0150 OSLO";
    }

}
