## Motivation
- - -
![motivational poster](http://localhost:8000/img/where-discomfort-happens.png "You now feel motivated")


## Motivation
- - - 
* Java 7 end-of-life Q2 2015
* 96% of Finn java-processes on Java 8 (oct)
* Nice to still be able to read and write Java (*)
* More fun (*)
* Better code (*) 

(*) ``[citation needed]``


## Lambda
- - - 

Java 8 introduces a new syntax for defining functions, using an arrow ->


## A function vs a lambda
- - - 

~~~java
int d(int i) {
    return i * 2;       
}
~~~

~~~java
i -> i * 2;
~~~


## Lambda with multiple LoC
- - - 

~~~java
(Integer i) -> {
    ;
    ;
    return "";
};
~~~


## Lambda with type inference
- - - 
~~~java
a -> a * 2;
~~~


## Lambda stored as a variable
- - - 
Functions are objects, and objects can be stored in a variable

~~~java
Function<Integer, Integer> dbl = (Integer a) -> a * 2;
Integer eight = dbl.apply(4);
~~~


## New interfaces I
- - - 
~~~java
Function<Integer, Integer> dbl = (Integer a) -> a * 2;
~~~

~~~java
BiFunction<Integer, String, Integer> wat = 
    (Integer i, String str) -> i * str.length();
~~~


## New interfaces II 
- - - 
~~~java
Consumer<String> c = (String s) -> {};
~~~

~~~java
Supplier<Integer> xkcdRnd = () -> 4;
xkcdRnd.get();
~~~

![random number](http://localhost:8000/img/random_number.png "Random!")


## New interfaces III
- - - 
~~~java
BiConsumer<Float, Byte> blackHole = (Float f, Byte b) -> {};
~~~

~~~java
// super-fast and thoroughly tested for i <= 7
Predicate<Integer> isPrime = 
    (Integer i) -> i != 2 && i % 2 != 0; 
isPrime.test(7)
~~~


## Pointing at methods
- - - 
```MyClass::myMethod```

~~~java
class MyClass {
    Boolean isPrime(Integer i) {
        return i != 2 && i % 2 != 0;
    }
    void run() {
        Predicate<Integer> predicate = this::isPrime;
    }
}
~~~


## Pointing at static methods
- - -
~~~java
Consumer<String> myConsumer = System.out::println;
~~~


## Pointing at constructors
- - -
~~~java
Arrays.asList("Knoll", "Tott").stream().map(Person::new);
~~~