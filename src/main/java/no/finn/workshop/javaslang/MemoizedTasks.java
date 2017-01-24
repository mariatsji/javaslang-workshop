package no.finn.workshop.javaslang;

import javaslang.Function1;
import javaslang.collection.List;
import javaslang.collection.Stream;

public class MemoizedTasks {

    // Say you just wrote a primitive find-prime-function, like the one in isPrimeFunction()
    // Say it is applied a lot of times with the same argument, it would be a good idea to cache the result
    // this is called Memoization
    // modify this method to speed it up, using the concept of memoization
    public static Long checkIfPrimeAWholeLot(Long l) {
        Function1<Long, Boolean> primeFunction = isPrimeFunction(); //modify only this line
        Stream.rangeClosed(0, 10).forEach(i -> primeFunction.apply(l));
        return l;
    }

    // leave this unmodified
    public static Function1<Long, Boolean> isPrimeFunction() {
        return i -> {
            try {
                Thread.sleep(2);
            } catch (Exception ignore) {
            }
            return i % 2 == 1 && List.rangeClosed(2, ((i / 2) + 1)).find(x -> i % x == 0).isEmpty();
        };
    }

}
