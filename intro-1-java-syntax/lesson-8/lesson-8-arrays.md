# Lesson 8. Arrays

## Initializing arrays

- Different ways to do it

1. `elementType[] identifier`
2. `elementType identifier[]`

- e.g.

```java
  int[] temperature = new int[7];

  String[] names = new String[12];
```

- For numeric values, the default value is `0` (or `0.0` for double) for each elemenet
- For boolean, the default is `false`
- For object/reference type, the default is `null` for the address that each element in the array is pointing to

### Use own value in initializing

- using literal array, the assignment must be paired with the array’s declaration
- e.g.

```java
  double[] weekHighs = {80, 70, 75, 69, 72, 74, 90};
```

## Iterating through the array

- for each loop, prevent out of bound

```java
for (arrayType element : array) {
    bodyStatement1;
    bodyStatement1;
    ...
}
```

- e.g.

```java
  double[] weekHighs = {80, 70, 75, 69, 72, 74, 90};
  for (double dayHigh: weekHighs) {
    // do something
  }
```

## Wrapper class

- java provides wrapper class that wrap the corresponding primitive type to provide additional methods for ease of development
- e.g.

```java
  Integer num = 10
  Double decimal = 5.0
  Boolean isTrue = false
```

### Pros of using wrapper class

- can store `null`. Primitive type cannot store `null`
- additional methods such as `parse[Type]`. E.g. `Double.parseDouble(someString)`
- Be used with collection such as `List` or `HashMap` where only object is allowed

### Autoboxing & Unboxing

- We can use wrapper classes & primitive types interchangable because of **Autoboxing** & **Unboxing**

#### Autoboxing

- The automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes. <br />

  For example, converting an int to an Integer, a double to a Double, etc. If you assign a primitive value to an object of the corresponding wrapper class, the Java compiler **automatically boxes** (wraps) the primitive value in an object.

```java
  Interger num = 10 // Autoboxing: the int 10 is boxed into an Integer object
```

#### Unboxing

- The automatic conversion the java complier makes from the wrapper class to the primitive type. If wrapper is used at where a primitive value is expected, the complier **unboxes** the object to extract the primitive value

```java
  int myInt = myInteger;  // Unboxing: the Integer object myInteger is automatically unboxed into an int
```
