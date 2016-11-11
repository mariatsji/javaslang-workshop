## java.util.stream
- - - 
"Classes to support functional-style operations on streams of elements,
such as map-reduce transformations on collections."


## On streams
- - - 
- Conveys elements (not storage)
- Functional
- Lazy
- Unbounded
- Consumable


## The stream pipeline
- - - 
An operation on a stream consists of

* Creating it
* Intermadiate operations
* Terminal operations


## Creating it
- - - 
~~~java
Stream<Integer> s = Arrays.asList(1, 2, 3).stream();~~~
~~~java
Stream<Integer> p = Arrays.asList(1, 2, 3).parallelStream();~~~
~~~java
Stream<int[]> ints = Stream.of(new int[3]);~~~
~~~java
IntStream nums = IntStream.range(0, 10);~~~
~~~java
DoubleStream doubs = DoubleStream.iterate(0, (Double d) -> d + 1d);~~~
~~~java
IntStream rnds = (new Random()).ints();~~~
~~~java
Stream<Path> paths = Files.walk(myPath, myOptions);~~~


## Intermediate operations
- - - 
Means invoking methods on a stream that return a stream

~~~java
int sum = widgets.stream()
    .filter((Widget w) -> w.getColor() == RED) // intermediate
    .mapToInt((Widget w) -> w.getWeight()) // intermediate
    .sum();
~~~ 


## Intermediate operations examples
- - -
~~~java
map // run f(e) on all elements e ~~~
~~~java
flatMap // run f(e) on all elements e ~~~
~~~java
boxed // int -> Integer etc ~~~
~~~java 
peek // run void f(e) on all e ~~~
~~~java
filter // only keep certain e ~~~
~~~java
skip // drop first n ~~~


## Terminal operations
- - -

~~~java
collection.forEach() // run void f(e) on all e ~~~
~~~java
stream.forEach() // terminal: run void f(e) on all e ~~~
~~~java
IntStream.sum() ~~~
~~~java
.max()~~~
~~~java
.count()~~~
~~~java
.reduce()~~~
~~~java
.collect() // aggregate all to some collection ~~~


## Sneak-a-peek
~~~java
Arrays.asList(1, 2, 3).stream()
        .peek((Integer i) -> LOG.info("hello, log"))
        .peek((Integer i) -> someService.doSomething(i))
        .forEach(System.out::println);
~~~                


## Collecting
- - - 
Use an implementation of Collector to collect

~~~java
List<Integer> l = Arrays.asList(1, 2, 3);
Set<Integer> set = l.stream().collect(Collectors.toSet());
Map<Integer, Integer> mymap =
        l.stream().collect(toMap((Integer k) -> k, (Integer v) -> v));
~~~


## Grouping by
- - - 
Use Collectors.groupingBy to group

~~~java
List<Integer> l = Arrays.asList(1, 2, 3, 4, 5, 6);
Map<Integer, List<Integer>> collected =
        l.stream()
         .collect(Collectors.groupingBy((Integer i) -> i % 2));

collected.keySet()
         .forEach(
            (Integer k) -> 
                System.out.println(k + " " + collected.get(k)));
~~~

~~~
0 [2, 4, 6]
1 [1, 3, 5]
~~~
