## Instantiate nullable

~~~java
Optional<User> user = Optional.ofNullable(db.fetchUserById(42L));
~~~

- - -

Javadoc clearly states that the method can return ```null```

Code within the method shows it returns ```null```

Otherwise we must assume the value is not nullable


## Instantiate non-nullable

~~~java
 1  Optional<URI> uri = Optional.of("http://example.com");
 2  service.fetchSomething(42L, uri);
~~~

- - -

When the value is known to never be null


## Instantiate empty

~~~java
 1  Optional<URI> uri = Optional.empty();
 2  service.fetchSomething(42L, uri);
~~~
~~~java
 1  if (someCondition) {
 2      return Optional.empty();
 3  }
~~~

- - -

Instead of passing in ```null```

Instead of returning ```null```

(and thus avoid potential NPEs in the callee or caller code)


## Default value

~~~java
 1  String getDefault() {
 2      return "default";
 3  }
 4
 5  Optional<String> opt = Optional.ofNullable(aString);
 6
 7  String result = opt.orElse(getDefault());
~~~

- - -

With ```orElse()```, the method ```getDefault()``` is **always** called


## Default value supplier

~~~java
 1  String getDefault() {
 2      return restService.getRequest("http://example.com");
 3  }
 4
 5  Optional<String> opt = Optional.ofNullable(aString);
 6
 7  String result = opt.orElseGet(this::getDefault);
~~~

- - -

With ```orElseGet()```, the method ```getDefault()``` is called **only when not present**


## No default value possible

~~~java
 1  Optional<A> opt = Optional.ofNullable(a);
 2
 3  A result = opt.orElseThrow(
 4    () -> new IllegalStateException("Terrible fail"));
~~~

- - -

or bubble up your ```Optional```


## Transform value

~~~java
 1   // User ===> Account
 2  Account findAccount(User user) {
 3      return db.fetchAccountByUser(user); // may be null
 4  }
 5
 6  Optional<User> user = Optional.ofNullable(db.fetchUserById(42L));
 7
 8  Optional<Account> account = user.map((User user) -> findAccount(user));
~~~

- - -

if ```db.fetchAccountByUser(user)``` returned ```null```, then ```account``` will be ```Optional.empty()```, not ```null```!


## Transform value (bis)

~~~java
 1  // User ===> Optional<Account>
 2  Optional<Account> findAccount(User user) {
 3      return Optional.ofNullable(db.fetchAccountByUser(user));
 4  }
 5
 6  Optional<User> optUser = Optional.ofNullable(db.fetchUserById(42L));
 7
 8  Optional<Optional<Account>> account = 
 9     optUser.map((User user) -> findAccount(user));
10
11  Optional<Account> account = 
12     optUser.flatMap((User user) -> findAccount(user));
~~~

- - -

```flatMap()``` removes one-level of ```Optional``` while mapping

~~~java
    Optional<Optional<A>>        ===flatten==>       Optional<A>

                        A      ===map(f:A->X)==>     X

    Optional<Optional<A>>    ===flatMap(f:A->X)==>   Optional<X>
~~~


## Execute when present

~~~java
 1  void writeToFile(A a) { /* ... */ }
 2
 3  Optional<A> opt = Optional.ofNullable(a);
 4
 5  opt.ifPresent(a -> writeToFile(a)); // side-effect for I/O
~~~


## Filter value

~~~java
 1  void writeToFile(String str) { /* ... */ }
 2
 3  Optional<String> opt = Optional.ofNullable(aString)
 4                                 .filter(str -> !str.trim().isEmpty());
 5
 6  opt.ifPresent(str -> writeToFile(str));
~~~


## Chaining

chains as much as you’d like
~~~java
B f(A a) { /* ...may return null... */ } // function A ===> B
C g(B b) { /* ...may return null... */ } // function B ===> C
D h(C c) { /* ...may return null... */ } // function C ===> D
E i(D d) { /* ...may return null... */ } // function D ===> E

// E e = i(h(g(f(a))));

Optional<A> opt = Optional.ofNullable(a);
Optional<E> optE = opt.map(this::f).map(this::g).map(this::h).map(this::i);
//                  A    ===>    B    ===>    C    ===>    D    ===>    E
~~~

- - -

**Stay** and **compute within** the **monadic domain**, i.e. we benefit all along of the promise of ```Optional```

Acts as if there were null-checks between each method call


## Chaining flatMap

chains as much as you’d like
~~~java
Optional<B> f(A a) { /* ... */ } // function A ===> Optional<B>
Optional<C> g(B b) { /* ... */ } // function B ===> Optional<C>
Optional<D> h(C c) { /* ... */ } // function C ===> Optional<D>

Optional<A> opt = Optional.ofNullable(a);
Optional<D> optD = opt.flatMap(this::f).flatMap(this::g).flatMap(this::h);
//                  A      ===>      B      ===>      C      ===>      D
~~~
