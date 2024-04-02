# Lesson 11. Writing class part 2

## Constructor chaining

- a less specific calling a more specific constructor for initializing the instance by using `this()`
- therefore **reduce** duplicate logic in constructor

```java

public static final int DEFAULT_X = 10;
public static final int DEFAULT_Y = 10;
public static final int population = 0;

public Insect(int intWeight) {
  this(intWeight, DEFAULT_X, DEFAULT_Y)
}

public Insect(int intWeight, int initX, int initY) {
  weight = intWeight
  x = initX
  y = initY
  population++
}

/**
 * instead of
  public Insect(int intWeight) {
    weight = intWeight
    x = DEFAULT_X
    y = DEFAULT_Y
    population++
  }

  public Insect(int intWeight, int initX, int initY) {
    weight = intWeight
    x = initX
    y = initY
    population++
  }
 */
```

## Object.toString

- By default, all java object inherit a `toString()` method which can be overriden
- In addition, if a non-string object is input to print line, Java will automatically call the object's toString() method and use a return string as the actual parameter for that print line call. The same thing happens with print.

```java
public class Insect {
  public String toString() {
    // some print logic
  }
}

public class Client {
  Insect bug = new Insect();
  // this would call bug.toString() method
  System.out.println(bug)
}
```
