import java.util.ArrayList;
import java.util.List;

public class Averager {
  public static void main(String[] args) {
    double sum = 0;
    for (String num : args) {
      sum += Double.parseDouble(num);
    }
    double average = args.length > 0 ? sum / args.length : 0;
    System.out.println("Average is: " + average);

    SomeOtherClass.sayHello();

    String first = "1";
    String second = "2";
    int third = 1;
    System.out.println(4 - ((int) 5.5 + 2.5) / 1);
  }
}
