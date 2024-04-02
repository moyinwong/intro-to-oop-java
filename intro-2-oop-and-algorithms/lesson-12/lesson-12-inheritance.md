# Lesson 12. Inheritance

## Super()

- the subclass constructor doesn't inherit the content of the superclass constructor
- to avoid repeated code, use `super()` to call the superclass constructor method
- if no `super()` call is found in child constructor, java will auto invokes a parameterless constructor of the superclass at the start of child's constructor

## final

- make a class/method/variable constant
- make a class `final` mean it cannot be extended into another subclass
- make a method `final` mean it cannot be overriden in any subclass
- rule of thumb: make a method `final` if it involves data-sensitive operation/highly optimized that should not be changed

## abstract

- abstract method is method that have declaration but not definition
- if a class have an abstract method, it should also be declared abstract (which mean a class extending `abstract` class without defining abstract method should also be declared abstract)
- it represents `generic concepts or things`, that applied to a group of things but with difference among them
- enforce subclasses to provide their own implementation of the abstract methods
