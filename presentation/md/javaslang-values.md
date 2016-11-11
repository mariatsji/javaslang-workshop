## Functional Programming

"The key to a better Java is to use immutable values paired with referential transparent functions."
- Rich Hickey, Author of Clojure


## Value
- - -
Values are essential for FP

Values that are immutable are
- easier to reason about
- need not be cloned
- are reliable hash-keys
- reliable in equality-checks
- thread-safe
- behave type-safe when used in unchecked covariant casts (Java-specific)


# Value instances has powerful eq()

checks:
congruence(*) of structures AND equality of contained values.
* noun, agreement or harmony; compatibility.


~~~java
final Value<?> i1 = List.of(List.of(1, 2), Arrays.asList(List.of(3)));
final Value<?> i2 = Queue.of(Stream.of(1, 2), List.of(Lazy.of(() -> 3)));
System.out.println(i1.eq(i2));
~~~




- Control-Structures (Try, Either, Option, Future, Lazy, Validation)
- CheckedExceptions
- Only one (broken) Functional Control Structure (not Serializable, not Iterable)


Java collections are