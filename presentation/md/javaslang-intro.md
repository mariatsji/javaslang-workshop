## Movitation
- - -
Pure Java Functional Programming

- Poor Function-representation
- CheckedExceptions
- Only one (broken) Functional Control Structure (not Serializable, not Iterable)


Java collections are

- mutable
- not lifted (NPE)
- inconsistent (Stream vs Optional..)
- list.stream().map(..).collect(Collectors.toList()) 


## Javaslang
- - -
- Functional, coherent collections
- LOTS of useful methods on collections
- Functional, coherent control values (Either, Try, Option)
- Tuples, Lazy, Currying, Lifting, Composition
- Validation, Pattern Matching


## Javaslang-collections
- - -
~~~java
import static javaslang.collection.*;

List.of(1,2,3);
List.of("a", "b").toJavaList();
List.ofAll(myJavaUtilList);
List.rangeBy('a', 'z', 2).mkString();
HashMap.of(1, "one", 2, "two");
HashSet.fill(5, () -> new Random().nextInt());
~~~


## javaslang overview
- - -

![javaslang-overview](img/javaslang-overview.png "Javaslang overview")

- Tuple
- λ
- Value


## javaslang.collection.Seq
- - -
![javaslang-collections-seq](img/collections-seq.png "Javaslang collections seq")


## javaslang.collection.Set / Map
- - -
![javaslang-collections](img/javaslang-collections.png "Javaslang collections")



## javaslang usage guide

[javaslang-usage-guide](http://www.javaslang.io/javaslang-docs/#_usage_guide)

