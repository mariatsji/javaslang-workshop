## FP - Lambdas

> The key to a better Java is to use immutable values paired with referential transparent functions.

<small>Rich Hickey</small>


## Referential Transparency

- pure
- no side effects
- means it can be Memoized (cached)
- the result is always the same for every input
- not like new Random().nextInt()


## void

- a void method has only one purpose: to execute side effects
- can thus never be referentially transparent
- try to separate pure functions from side effects in your application


## How to model a Coffee Maker in java?

~~~java
class CoffeeMaker{

    Water water;
    Beans beans;
    CoffeeFilter filter;
    
    Coffee makeCoffee() { .. }
    
} 
~~~


## Hint : How to model a Coffee Filter 

A CoffeeFilter is a function
*liquid* ➔ *liquid*

~~~java
    Function1<Liquid, Liquid> coffeeFilter = l -> l;
~~~


## So..

A CoffeeMaker is a function 
(*water*, *beans*, *coffeefilter*) ➔ *coffee*

~~~java
    Function3<Beans, Water, Function<Liquid,Liquid>, Coffee> coffeeMaker =
            (bean, liquid, filter) -> new Coffee();
~~~


## Lamda
The interface of Functions in javaslang

- Reversed
- Curried
- Composed
- Memoized
- Lifted


## Reverse

(*a*,*b*) ➔ *c*<br />
=><br />
(*b*,*a*) ➔ *c*


## Currying I

(*a*, *b*) ➔ *c* <br />
=><br />
*a* ➔ (*b* ➔ *c*)


## Currying II

~~~java
    Function2<Integer, Integer, Integer> f = (a,b) -> a + b;
    Function1<Integer, Integer> addOne = f.apply(1);
    Integer five = addOne.apply(4);
~~~


## Currying III

~~~java
   Function2<Integer, Integer, Integer> f = (a,b) -> a + b;
   Function1<Integer, Function1<Integer, Integer>> curried = f.curried();
   Function1<Integer, Integer> addOne = curried.apply(1);
   Integer five = addOne.apply(4);
~~~


## Composition I

(*b* ➔ *c*) *.* (*a* ➔ *b*)<br />
=> <br />
(*a* ➔ *c*)


## Composition II

~~~java
    Function1<Integer, String> f = String::valueOf;
    Function1<Integer, Integer> g = i -> i * 2;
    Function1<Integer, String> composed = f.compose(g);

~~~


## Memoization

~~~java
    Function0<Integer> rand = () -> new Random().nextInt();
    Function0<Integer> memoized = rand.memoized();
    Stream.fill(3, memoized)
            .forEach(System.out::println);
~~~

~~~text
1882257724
1882257724
1882257724
~~~


## Lift

~~~java
    Function2<Integer, Object[], Object> raw = 
        (index, array) -> array[index];

    Function2<Integer, Object[], Option<Object>> lifted =
            Function2.lift(raw);

    Character[] array = {'a', 'b'};
    Object found = raw.apply(2, array);
    Option<Object> foundMaybe = lifted.apply(2, array);
~~~