## Movitation


Java collections are
* mutable
* not lifted


## Javaslang

* Functional, coherent collections
* Lots of methods on collections
* Functional, coherent control values (Either, Try, Option)
* Tuples, Lazy, Currying, Lifting, Composition
* Validation, Pattern Matching


## Javaslang-collections

~~~java
import static javaslang.collection.*;

List.of(1,2,3);
List.ofAll(myJavaUtilList);
List.rangeBy('a', 'z', 2).mkString();
HashMap.of(1, "one", 2, "two");
HashSet.fill(5, () -> new Random().nextInt());

~~~

## javaslang.collection.Seq
- - - 

![javaslang-collections-seq](http://localhost:8000/img/collections-seq.png "Javaslang collections seq")



## javaslang.collection.Set / Map
- - - 

![javaslang-collections](http://localhost:8000/img/javaslang-collections.png "Javaslang collections")

