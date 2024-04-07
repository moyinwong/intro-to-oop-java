# Lesson 19. Intro to JavaFX

## Annoymous inner class

Instead of declaring private class within a class. We can declaring a annoymous inner class and assign it a variable directly

```java
EventHandler<ActionEvent> handler = new EventHandler<>() {
  public static void handle(ActionEvent e) {
    System.out.println("Hello World")
  }
}

button.setOnAction(handler);
```

## Lambda Expressions

We can even use a Lambda expression to achieve the same in just one line if the method `setOnAction` is only expecting an functional interface (interface with only 1 abstract method)

So that developer can focus on **provide implementation of functional interface**, thus less boilerplate of declaring a class which implements the functional interface

```java
button.setOnAction(e -> System.out.println("Hello World"))

List<String> list=new ArrayList<String>();
list.add("ankit");
list.add("mayank");
list.add("irfan");
list.add("jai");

list.forEach(
    (n)->System.out.println(n)
);

interface Sayable{
    public String say(String name);
}

// Lambda expression with single parameter.
Sayable s1=(name)->{
    return "Hello, "+name;
};
System.out.println(s1.say("Sonoo"));

// You can omit function parentheses
Sayable s2= name ->{
    return "Hello, "+name;
};
System.out.println(s2.say("Sonoo"));
```
