public class FarenheitToCelciusConvertor {
  public void convertToCelcius(String day, int farenheit) {
    double temp = (5.0 / 9) * (farenheit - 32);
    System.out.printf("%s Temperature in Celsius %f%n", day, temp);
  }
}
