# Lesson 15. Introduction to Polymorphism

## Declared type & Object type

- Declared type is the type declared when creating a variable
- Object type is the actual class the object is instantiated as

```java
  // Caine is the declared type while Poodle is the object type
  // Caine is the superclass of Poodle
  Caine peggy = new Poodle()
```

When compiling, the compiler checks:

1. **can the object of some class be assigned to a reference variable in some declared type**
   1.1 If the declared type is a **class**, then it checks whether the object type is the class or subclass
   1.2 If the declared type is an **interface**, then it checks whether the object type or any ancestors implement that interface
2. **is every method and variable we try to access in a reference variable available in its declared type**

If no, then compile error occurs

p.s: if ever needed to access methods available **only in object type** but not in declared type, need to **cast** the variable into the object type

## Casting (Runtime)

- at runtime, JVM will use the object being referenced to check if the casting is legal
- "is a" test is performed

```java
  Dog peggy = new Dog("Peggy")

  // This will cause runtime error, as peggy is not a Poodle
  ((Poodle) peggy).somethingPoodle();

  // Even changing it to a method that defined on Dog, runtime error is stil occur because of the casting
  ((Poodle) peggy).somethingDog();
```

## Dynamic binding, late-binding, or runtime resolution

This is thehe process where JVM would check up the inheritance tree, level by level to match a method call in a statement to its actual definition.

```java
class Canine {
  void bark() {
    //...
  }
}
class Dog extends Canine {
  void bark() {
    //....
  }
}

/**
 * JVM will look up the tree level by level until it finds the object class or its'superclass for the method definition.
 *
 * If the Poodle class defined a bark method, then that version is executed.
 * If the Dog class (Poodle’s parent) defined a bark method, then that version is executed.
 * If not, the JVM checks the Canine (Dog’s parent) and performs its version.
**/
class Poodle extends Dog {
  void bark() {
    //....
  }
}
```
