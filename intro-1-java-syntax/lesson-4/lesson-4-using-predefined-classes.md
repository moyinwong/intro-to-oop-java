# Lesson 4. Using predefined classes

## Primitive types vs Reference types

### Primitive types

The variable stores the actual value in memory

- boolean
- byte, short, int, long
- double, float
- char

### Reference types

As reference variables are complicated than primitive type values, the data is stored separately managed part of memeory called **the heap**. It holds the **address** that reference to the location of where the object is actaully stored

- class

## Invoking method

pass by value for method, from **actual parameters** (the parameter passed when invoking the method on the instacne)to **formal parameters** (the parameter as defind in the class's method signature)

## String is immutable

- A lot of sensitive data, such as usernames, passwords, and permissions, are often stored as Strings. If Strings were easily modifiable, it would open the door to vulnerabilities that change Strings to gain the ability to access some resource or execute some behavior. For example, imagine if it were easy to mutate the String “User” to the String “Admin” before the code executes code to access some files.
- The JVM stores several critical values, including the names of classes it will load, as Strings. If it were easy to dynamically change the contents of such values at runtime, some untrustworthy code could cause the JVM to load unintended classes at runtime, introducing opportunities to exploit the behavior of the program to modify or extract sensitive data from it.

There are also other reasons to favor immutable String. For example:

- Having immutable Strings opens the door to several runtime optimizations that can improve the execution time on operations involving Strings.
- Immutable String enables the JVM to use a String Constant Pool to reuse String literals that appear in source code. We will explore this further in Lesson 6.

## Import package

### Two different package that contains the same Class name

- Java will throw exception because of conflicting definition
- To solve this, be specific when importing package or use the `package.class_name` directly
- e.g. `java.util.Scanner scanner = new Scanner(System.in)`
