## Javaslang Tuple

What if you want to return two things?


## Javaslang Tuple

~~~java
    Tuple2<String, Integer> filesInDir(String dir, String fileExtension) {
        Integer fileCount = getCount(dir, fileExtension).length();
        return Tuple.of(currDir() + fileExtension, fileCount);
    }
    
    Tuple<String, Integer> pathAndCount = filesInDir("/", "*.txt");
    String path = pathAndCount._1
    Integer count = pathAndCount._2;
~~~


## Javaslang Tuple
Widely used in FP because a pure function should receive all values it works on, 
and hence return all values that other (chained functions) need