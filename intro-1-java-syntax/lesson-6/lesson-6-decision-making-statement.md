# Lesson 4. Decision-Making Statements

## String interning (optimization process)

- The first time Java see the string literal, there's no existing object so a new instance is created
- Java then put the string object in a special part of the heap called **string constant pool**
- if it later see a literal with the same content as a string in the pool, it will recycle/reuse the one in the pool by making an alias
- e.g.

```java
String a = "park";
String b = "parK";

// true as both a & b point to the same string object in the pool
a === b
```

- On the other hand, using String constructor would always create a new object

```java
String a = new String("park");
String b = new String("park");

// false
a === b
```
