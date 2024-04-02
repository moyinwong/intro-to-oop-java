import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class ScannerInput {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // System.out.println("Enter temperature and day in farenheit: ");
    // int temp = scanner.nextInt();
    // String day = scanner.next();
    // double celsius = (5.0 / 9) * (temp - 32);
    // System.out.println("Unit for (c/centigrade/celsicus):");
    // String c = scanner.next();

    // System.out.printf("%s's temperature in fareinheit: %d\n", day, temp);
    // System.out.printf("%s's temperature in %-11s %.2f\n", day, c + ":", celsius);

    // System.out.print("Choose a number: ");

    // int num;
    // while ((num = scanner.nextInt()) < 100) {
    // System.out.println("Not zero. Try again");
    // }

    // System.out.println("Yay you make it! Zero is the best" + num);

    // System.out.print("Enter the number of items: ");
    // int numsOfItems = scanner.nextInt();

    // System.out.print("Averge cost per items: ");
    // double price = scanner.nextDouble();
    // double total = numsOfItems * price;

    // DecimalFormat formatter = new DecimalFormat();
    // System.out.println("The total is: " + formatter.format(total));
    System.out.println("Input 2 numbers");
    if (!scanner.hasNextInt()) {
      System.out.println("Wrong input");
      return;
    }
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    System.out.println(a);
    System.out.println(b);
  }
}
