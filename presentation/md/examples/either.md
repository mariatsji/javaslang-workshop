## Either

~~~java
Either<LEFT, RIGHT> aLeftOrRight;
~~~

- - -

**Disjoint union** (left and right) of values of **two types**

**Guarantee** : left **type** when left **side**, right type when right side.

Forces **handling** of **both** possibilities (at the same time)

*Available through FINN's lambda-companion lib v0.8*


## Disjoint union

~~~java
 1  Either<PhoneNumber, EMailAddress> contact;
 2
 3  String sendingNumber = contact.fold(phone -> sendSms(phone, message),
 4                                      email -> sendEmail(email, message));
~~~

- - -

Both sides require specific handling from developer


## Fold

~~~java
 1  Either<L, R> aLeftOrRight;
 2
 3  // L or R =====fold===> X
 4
 5  X x = aLeftOrRight.fold(left -> leftToX(left),     // L ===> X
 6                          right -> rightToX(right)); // R ===> X
~~~

- - -

Make a single value out of each of both possibilities


## Projection

~~~java
 1  Either<L, R> aLeftOrRight;
 2
 3  LeftProjection<L, R> l = aLeftOrRight.left().... // work only on left
 4
 5  RightProjection<L, R> r = aLeftOrRight.right().... // work only on right
~~~

- - -

 ```*Projection<L, R>``` is still the **same** ```Either<L, R>``` **with both** left and right but guarantees working on the **chosen side**


## Projection operations - 1

~~~java
 1  Either<L, R> either;
 2
 3
 4  // transform left value into somthing else; ex: L ===> X
 5  Either<X, R> mapped = either.left().map(left -> toX(left));
 6
 7  // return a default value
 8  L value = either.left().orElse(defaultValue);
 9
10  // supply a default value
11  L value = either.left().orElseGet(() -> supplier());
12
13  // make an Optional of it
14  Optional<L> opt = either.left().toOptional();
~~~


## Projection operations - 2

~~~java
 1  Either<L, R> either;
 2
 3
 4  // executes the side effect; returns the either
 5  Either<L, R> same = either.left().peek(left -> log(left));
 6
 7  // executes the side effect; returns void
 8  either.left().forEach(left -> log(left));
 9
10  // filter based on the value of the left side
11  Optional<Either<L, R>> maybe = either.left()
12                                       .filter(left -> predicate(left));
~~~
