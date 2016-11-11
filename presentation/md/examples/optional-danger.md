## isPresent() + get()

~~~java
if (optional.isPresent()) {
    doSomething(optional.get());
}
~~~

- - -

"Safe region" within the '```{}```' of the ```if```-test

It is the ```if```-test that "protects"

What is the **monadic property** of Optional we make use of here?


## Evolution

"IllegalStateException is the new NullPointerException"™©®

- - -

The ```isPresent``` check is too often / too fast overlooked / forgotten.

Because it is too easy to just call ```.get()```

~~~java
optional.get().getProperty()
~~~


## Example

![example](http://localhost:8000/img/opt-diff1.png)


## Examples m.finn master

![m.finn example](http://localhost:8000/img/opt-diff2.png)


## Examples m.finn master

![m.finn example](http://localhost:8000/img/opt-diff3.png)


## Examples m.finn master

![m.finn example](http://localhost:8000/img/opt-diff4.png)


## Rotting code

What happens when **code** is **changed** by **multiple** **different** developers **overtime**?

In case of too fast copy/paste? In case of refactoring?

Will the **compiler warn** you?
