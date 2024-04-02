import java.util.HashMap;

public class FarenheitToCelcius {
  public static void main(String[] args) {
    FarenheitToCelciusConvertor convertor = new FarenheitToCelciusConvertor();

    HashMap<Integer, String> map = new HashMap<Integer, String>();
    map.put(0, "Monday");
    map.put(1, "Tuesday");
    map.put(2, "Wednesday");
    map.put(3, "Thursday");
    map.put(4, "Friday");
    map.put(5, "Saturday");
    map.put(6, "Sunday");

    int[] weekTemps = { 78, 81, 90, 65, 40, 60, 84 };

    for (int i = 0; i < weekTemps.length; i++) {
      convertor.convertToCelcius(map.get(i), weekTemps[i]);
    }
  }

}
