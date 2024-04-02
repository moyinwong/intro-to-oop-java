# Lesson 10. Intro to writing class

## Constructor

- each class is default given a hidden constructor which default set the values of instance variables.
- `0` for numeric values, e.g. `int/double`
- `false` for `boolean`
- `null` for object

- to override default constructor, define custom constructor function
- the default constructor is **removed** once custom constructor is provided
- It should contain only a method name same as class name and formal parameters in the signature

```java
public class Insect {
  int x
  int y
  double weight

  public Insect(int x, int y, double weight) {
    weight = weight
    x = x
    y = y
  }
}
```

## Static

- methods that do not represent actions that would be performed on the **specific object** of a class should be static.
- instance variable that is static is shared among every instance of the class, thus saving memories
- a static method cannot directly access non-static members (instance variable/method) since it can be called without instance being created
