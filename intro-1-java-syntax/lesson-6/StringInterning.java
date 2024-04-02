
public class StringInterning {
  public static void main(String[] args) {
    String a = new String("park");
    String b = new String("Abrk");

    if (a != b) {
      System.out.println("a & b are not aliase");
    }

    if (a.compareTo(b) > 0) {
      System.out.println("a is greater than b");
    } else if (a.compareTo(b) < 0) {
      System.out.println("b is greater than a");
    } else {
      System.out.println("a & b has the same content");
    }
  }
}
