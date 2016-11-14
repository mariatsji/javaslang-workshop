## Functional Programming

> The key to a better Java is to use immutable values paired with referential transparent functions.

Rich Hickey


## Referential Transparency

- pure
- no side effects
- means it can be Memoized (cached)
- the result is always the same for every input
- not like new Random().nextInt()


## void

- a void method has only one purpose: to execute side effects
- a void method can never be referentially transparent
- try to separate pure functions from side effects in your application


## How to model a Coffee Maker in java?

~~~java
Class CoffeeMaker{ 
    Water water;
    Beans beans;
    CoffeeFilter filter;
    
    Coffee makeCoffee() { .. }
     
} 
~~~


## Hint : How to model a Coffee Filter 

A CoffeeFilter is a function
liquid ➔ liquid

~~~java
    Function1<Liquid, Liquid> coffeeFilter = l -> l;
~~~


## So..

A CoffeeMaker is a function 
(water, beans, coffeefilter) ➔ coffee

~~~java
    Function3<Beans, Water, Function<Liquid,Liquid>, Coffee> coffeeMaker =
            (bean, liquid, filter) -> new Coffee();
~~~


## Lamda
The interface of Functions in javaslang

Can be
- Curried
- Reversed
- Composed
- Memoized
- Lifted
