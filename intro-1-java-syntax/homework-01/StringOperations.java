public class StringOperations {
  public static void main(String[] args) {
    String name = "Kelvin";
    System.out.println(name);

    String nameZ = "A" + name.substring(1, name.length() - 1) + "Z";
    System.out.println(nameZ);

    String url = "www.gatech.edu";
    System.out.println(url);

    String domain = url.split("\\.")[1] + "1331";
    System.out.println(domain);
  }
}
