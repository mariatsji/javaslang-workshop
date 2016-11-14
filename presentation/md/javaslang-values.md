## Functional Programming

> The key to a better Java is to use immutable values paired with referential transparent functions.

Rich Hickey


## Why not mutate values?
~~~java
    void sort(List<Float> floats);
~~~
- Anyone with a reference to the list can change it
- Maybe it's allready sorted?
- Maybe someone needs a pre-sort-snapshot of it?
- Maybe it's half-way sorted?
- You need to know every LoC to know if the List is sorted or not..


## Why not mutate values?

- Because a value is a fact, and a fact should not change
- But new facts can be appended


## Why not mutate values?
~~~java
    Key myKey = new Key(12);
    Key otherKey = new Key(13);
    Map<Key, String> map = new HashMap<Key, String>() {{
        put(myKey, "awesomesauce");
        put(otherKey, "bad");
    }};
    myKey.setInteger(13);
    System.out.println(map.get(myKey));
~~~    


## Javaslang collection

~~~java
    List<Integer> list = List.of(1, 2);
    list.append(3);
    System.out.println(list.length());
~~~


## Immutable Values are essential for FP

- easier to reason about
- need not be cloned
- are reliable hash-keys
- reliable in equality-checks
- thread-safe
- only yours AND you can share them freely


## Value instances has powerful eq()

checks:
> congruence of structures AND equality of contained values.
- congruence: noun, agreement or harmony; compatibility.

~~~java
final Value<?> i1 = List.of(List.of(1, 2), Arrays.asList(List.of(3)));
final Value<?> i2 = Queue.of(Stream.of(1, 2), List.of(Lazy.of(() -> 3)));
System.out.println(i1.eq(i2));
~~~


## Javaslang control structures
- Try, Either, Option, Future, Lazy, Validation
- Can be used in For-comprehension
- Can be used in eq()-checks
