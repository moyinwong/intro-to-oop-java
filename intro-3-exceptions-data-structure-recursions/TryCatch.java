import java.io.FileNotFoundException;

public class TryCatch {
  public static void main(String[] args) throws FileNotFoundException {
    try {
      int a = 10 / 0;
    } catch (ArithmeticException e) {
      System.out.println(e);
    }
  }
}
