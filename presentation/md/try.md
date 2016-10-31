## Why Try?
- - -

* ```Try```  is an  ```Either``` that is leaning to the right
* It is right-biased
* Convenient for representing a value or a failure
* e.g. thrift-calls
* ```no.finntechlambda-companion```


## How Try works
- - -
* ```Try<T>```  is a  ```Success<T>```  or a  ```Failure<? extends Throwable>```
* Avoids a lot of curly brackets
* Allows you to postpone failure handling
* Short Circuited computations in the monadic domain


## Try API
- - -
* ```Try.of(r, params)``` creates a ```Try``` from a method or lambda throwing an Exception
* ```new Success<>("Radio voices")```
* ```new Failure<>(new MidiUnavailableException())```


## Try API II
- - -
* Familiar methods like ```map()```, ```flatMap()```, ```forEach()```, ```peek()```
* Can be chained
* These do not evaluate expression when ```Failure```
* has ```toEither()``` and ```toOption()```
* ```recover(v -> v, e -> handleFailure(e))```


## Monadic properties
- - -

~~~java
String myString = Try.of(URL::new, "http://www.google.com")
        .map(URL::openConnection) // Throws IOException
        .map(URLConnection::getInputStream) // Throws IOException
        .peek(is -> System.out.println("Do we have an InputStream here? " + is))
        .map(Scanner::new)
        .map(Scanner::next)
        .recover(a -> a, this::handleFailure);
~~~