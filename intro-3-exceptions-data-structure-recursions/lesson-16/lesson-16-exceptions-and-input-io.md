# Lesson 16. Exceptions and File I/O

## Exception

An exception is an error that occurs at runtime. Or more specifically, an object thrown after an error occurs.

## The call stack

JVM uses a **stack-based** data structure to store the state info of a method call. When new methods is called within in another method, the new method is **\*pushed** on top of the stack. When that method completes, it's **popped off** the stack and continue to the original execution of the caller function

The process repeats until all methods are complete and popped off the stack

## Error

A subclass of the `Error` class represents a kind of error that **generally can’t be recovered** from -- like when the JVM has no more memory to continue executing your program. `Exception`, on the other hand, are the kind of errors that **offer more flexibility in how they are handled**.
![alt text](https://courses.edx.org/assets/courseware/v1/719a3a4496005b8544fe04adc21e4cd0/asset-v1%3AGTx%2BCS1331xIII%2B2T2023%2Btype%40asset%2Bblock/throwablehierarchy.png)

## Why exception

- It separate the error handling code from the actual codes that have core logic.
- easier to read & write
- help organise if multiple exceptions would be thrown by ordering the catch block

## Declaring exception

- If an exception may be thrown in particular line of codes but there's no try catch block. Compile will fail
- We need to add try/catch block or **declaring the exception in method header** after paramter
- using `throws`

```java

class A {
  public static void main(String[] args) throws FileNotFoundException{
    String filename = args[0];

    File file = new File(filename);
    // FileNotFoundException maybe thrown, compile fail
    Scanner scanner = new Scanner(file);

  }
}
```

### Unchecked and checked exception

- **unchecked**. `Exception` has an immediate subclass called `RuntimeException`. Below `RuntimeExceptions` are a familiar set of exception types that we have not had to catch or specify (with a throws clause) in our past code. These exceptions are called unchecked exceptions. Too cumbersome to check, e.g. `NullPointerException`
- **checked**. Outside of the RuntimeException hierarchy are a set of other subclasses of the `Exception` class known as checked exceptions. These are are the exceptions that we must either catch or specify. `IOException` and its subclass of `FileNotFoundException` is one example.
