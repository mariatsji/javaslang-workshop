## Javaslang Tuple

What if you want to return two things?


## Javaslang Tuple

~~~java
    private Tuple<String, Integer> filesInPath(
            String basePath, 
            String fileExtension) {
        Integer fileCount = findAllIn(basePath, fileExtension).length();
        return Tuple.of(basePath, fileCount);
    }
    
    String count = filesInPath("/", "*.txt")._2;
~~~
