# Lesson 17. Lists

## Generics

- To create a class/interface which accept generic type parameter, add `<T>` to class header. `T` stand for type

```java
class Bin<T> {

}
```

- If there's need for multiple generic type, naming conventions is letter `T` with incrementing number

```java
class Bin<T1, T2, T3> {

}
```

- Can further use the `extends` keyword to **restrict** what kind of type (class/interface) it accepts
- just need the same keyword for extending both class and interace

```java
Bin<T extends Insect>
Bin<T extends Comparable>
Bin<T extends Insect && Comparable && Groomable>
```

## List interface

- when using generic type without actual type parameter, it's called **raw type**
- When provide type parameter, it's called **parameterized type**

### ArrayList class

- when creating an `ArrayList` without specifying size, the default size is 10

```java
ArrayList<elementType> aList = new ArrayList<elementType>();
// this is legal and same as above
ArrayList<elementType> aList = new ArrayList<>();
```

## LinkedList

ArrayList still have fundamental limitation of array. That is, an ArrayList can grow beyond its set capacity if needed but that **growth is still constrained by the fixed size of an array**. If we need a larger list (i.e. internal array), we cannot avoid the resources spent **creating a new array and copying elements over**.

It has the benefit of only consuming **just enough space to store its actual contents** rather than some default/projected size which can be larger than what it needs.

## Call stack and methods with return value

- each method call create a new frame and when destroyed when method complete. Frames are allocated from the JVM stack of the thread creating the frame. Each frame has its own local variables and operand stack.
- return values are separately from the call stack, it's stored in the [**current frame** (ref to java doc)](https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-2.html#jvms-2.6) and being returned to its' caller if any.
