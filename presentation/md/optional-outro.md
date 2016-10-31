## Elegance & Readability?

~~~java
 1  Optional<OtherType> method(Type nullableOther) {
 2  	OtherType opt = Optional.ofNullable(nullableOther);
 3      if (opt.isPresent()) {
 4          other = doSomething(opt.get());
 5      }
 6      return Optional.ofNullable(other);
 7  }
~~~

~~~java
 1  @Nullable
 2  OtherType method(@Nullable Type val) {
 3  	OtherType other = null;
 4      if (val != null) {
 5          other = doSomething(val);
 6      }
 7      return other;
 8  }
~~~


## Elegance & Readability

~~~java
 1  Optional<OtherType> method(Type nullableOther){
 2  	return Optional.ofNullable(nullableOther).map(this::doSomething);
 3  }
~~~

- - -

```Optional``` never was about readability but making **robust code**

**Elegance** is in the **using** of the **monadic properties**


## Craft your code

methods assume non-null input

methods never return null (Optional or empty lists, etc) NOP

wrap external calls in Optionals when they're known nullable

- - -

~~~java
 1 Optional<String> getUsername(final Key key) {
 2     // assume key is not-null - no defensive programming
 3     // javadoc says extService#getUser(Key) may return null
 4     return Optional.ofNullable(extService.getUser(key))
 5                    .map(User::getName);
 6 }
 7
 8 List<User> listUsersByName(final String name) {
 9     // assume name is not-null - no defensive programming
10     // javadoc says extService#listAllUsers() may return null
12     return Optional.ofNullable(extService::listAllUsers)
13                    .filter(user -> name.equals(user.getName()))
14                    .orElseGet(Collections::emptyList);
15 }
~~~


## Howto prevent

**Stay** on the safe-side: **within** the **monadic domain**

* **transform value** : ```optional.map()``` or ```optional.flatMap()```

* **execute side-effect** : ```optional.ifPresent()```

* **get default value** : ```optional.orElse()```, ```optional.orElseGet()``` or ```optional.orElseThrow()```

- - -
[60% of the time, it works every time](https://www.youtube.com/watch?v=pjvQFtlNQ-M)