## Functional Programming

"The key to a better Java is to use immutable values paired with referential transparent functions."
- Rich Hickey, Author of Clojure


## How to model a Coffee Maker in java?

∼∼∼java
Class CoffeeMaker{ 
    Water water;
    CoffeeBeans beans;
    CoffeeFilter filter;
    
    Coffee makeCoffee() { .. }
     
} 
∼∼∼


## Hint : How to model a Coffee Filter 

A CoffeeFilter is a function from liquid to liquid

∼∼∼java
    Function1<Liquid, Liquid> coffeeFilter = l -> l;
    Function3<CoffeeBean, Water, Function<Liquid,Liquid>, Coffee> coffeeMaker =
            (bean, liquid, filter) -> new Coffee();
∼∼∼


## So..

A CoffeeMaker is a function from (water, coffeeBeans, coffeefilter) ➔ coffee

## Lamda
The interface of Functions in javaslang

Can be
- Curried
- Reversed
- Composed
- Memoized
- Lifted


