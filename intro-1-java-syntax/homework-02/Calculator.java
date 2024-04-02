import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    System.out.println("List of operations: add subtract multiply divide alphabetize");
    System.out.println("Enter an operation:");

    Scanner scanner = new Scanner(System.in);
    String[] allowedOperations = { "add", "subtract", "multiply", "divide", "alphabetize" };
    String operation = scanner.next().toLowerCase();
    boolean isOperationValid = false;
    for (int i = 0; i < allowedOperations.length; i++) {
      if (operation.equals(allowedOperations[i])) {
        isOperationValid = true;
      }
    }

    Calculator calculator = new Calculator();

    if (!isOperationValid) {
      calculator.showError();
      return;
    }

    switch (operation) {
      case "add":
        System.out.println("Enter two integers:");
        if (!scanner.hasNextInt()) {
          calculator.showError();
          return;
        }
        int a = scanner.nextInt();
        if (!scanner.hasNextInt()) {
          calculator.showError();
          return;
        }
        int b = scanner.nextInt();
        calculator.add(a, b);
        break;

      case "subtract":
        System.out.println("Enter two integers:");
        if (!scanner.hasNextInt()) {
          calculator.showError();
          return;
        }
        int c = scanner.nextInt();
        if (!scanner.hasNextInt()) {
          calculator.showError();
          return;
        }
        int d = scanner.nextInt();
        calculator.substract(c, d);
        break;

      case "multiply":
        System.out.println("Enter two doubles:");
        if (!scanner.hasNextDouble()) {
          calculator.showError();
          return;
        }
        double e = scanner.nextDouble();
        if (!scanner.hasNextDouble()) {
          calculator.showError();
          return;
        }
        double f = scanner.nextDouble();
        calculator.multiply(e, f);
        break;

      case "divide":
        System.out.println("Enter two doubles:");
        if (!scanner.hasNextDouble()) {
          calculator.showError();
          return;
        }
        double g = scanner.nextDouble();
        if (!scanner.hasNextDouble()) {
          calculator.showError();
          return;
        }
        double h = scanner.nextDouble();
        if (h == 0.0) {
          calculator.showError();
          return;
        }

        calculator.divide(g, h);
        break;

      case "alphabetize":
        System.out.println("Enter two words:");
        String wordA = scanner.next();
        String wordB = scanner.next();

        calculator.alphabetize(wordA, wordB);
        break;
    }
  }

  public void add(int a, int b) {
    int res = a + b;
    System.out.println("Answer: " + res);
  }

  public void substract(int a, int b) {
    int res = a - b;
    System.out.println("Answer: " + res);
  }

  public void multiply(double a, double b) {
    double res = a * b;
    System.out.printf("Answer: %.2f\n", res);
  }

  public void divide(double a, double b) {
    double res = a / b;
    System.out.printf("Answer: %.2f\n", res);
  }

  public void alphabetize(String a, String b) {
    if (a.toLowerCase().equals(b.toLowerCase())) {
      System.out.println("Answer: Chicken or Egg.");
      return;
    }

    int res = a.compareTo(b);
    if (res > 0) {
      System.out.printf("Answer: %s comes before %s alphabetically.\n", b, a);
    } else if (res < 0) {
      System.out.printf("Answer: %s comes before %s alphabetically.\n", a, b);
    } else {
      System.out.println("Answer: Chicken or Egg.");
    }
  }

  public void showError() {
    String INVALID_INPUT_MSG = "Invalid input entered. Terminating...";
    System.out.println(INVALID_INPUT_MSG);
  }
}
