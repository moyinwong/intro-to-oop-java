# Lesson 14. More about interfaces

## `default` method

After Java 8, it's possible to provide implementation/concrete method in interface. This is to solve backward compatibility issue when trying to add functionality to a standard library

- `default` keyword allow interface method to have default implementation if implementing classes do not provide one.
- Only the interface need to be **re-compiled** after the change. All classes would automatically gain that definition.

E.g.

```java
public interface Groomable {
  void groom();

  default void pay() {
    System.out.println("No money!");
  }
}
```

## `static` method

## Constant in interface

Any variable that is declared in an interface is **inherently public, static, and final** regardless of the modifiers used or omitted.

E.g.

```java
public interface Groomable {
  int GROOM_SECOND = 10;

  // same as
  public static final int GROOM_SECOND = 10;
}
```
