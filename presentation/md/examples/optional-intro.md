## Good old null-check

~~~java
if (value != null) {
    doSomething(value);
}
~~~

- - -

"**Safe region**" **within** the '**```{}```**' of the ```if```-test

It is the **```if```-test** that **"protects"**


## Optional

Avoid NullPointerException

**Actively think**  about the **handling** of **absent values**

Generic Null Object Pattern


## Have you seen Optional?

~~~java
if (optional.isPresent()) {
    doSomething(optional.get());
}
~~~

- - -

"**Safe region**" **within** the '**```{}```**' of the ```if```-test

It is the **```if```-test** that **"protects"**


## Any significant difference?

~~~java
if (value != null) {
    doSomething(value);
}
~~~
~~~java
if (optional.isPresent()) {
    doSomething(optional.get());
}
~~~

- - -

...not so much


## So... Why Optional?

```Function```-s you pass to your ```Optional``` are **promised** to be passed a **non-```null``` input**

- - -

The notion of **promise** comes from the fact that ```Optional``` is a **monad** and **operates within** a "**monadic domain**"s"<sup style="font-size:10pt">(1)</sup>

<p style="font-size:12pt;margin-top:100px;">(1): <a href="http://logicaltypes.blogspot.no/2011/09/monads-in-java.html">http://logicaltypes.blogspot.no/2011/09/monads-in-java.html</a></p>


## Monadic domain

It is the **space where** the **promise** of the monad **applies**

- - -

```Optional``` : **space where non-```null``` input** is **guaranteed**

~~~java
Optional.map( monadic domain here )

Optional.flatMap( monadic domain here )

Optional.filter( monadic domain here )

Optional.ifPresent( monadic domain here )
~~~


## Monadic domain & Optional

~~~java
optional.map(input -> doSomething(input))

optional.flatMap(input -> doSomething(input))

optional.filter(input -> doSomething(input))

optional.ifPresent(input -> doSomething(input))
~~~

- - -

```doSomething()``` is promised to be passed  **non-```null input```**
