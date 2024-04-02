import java.util.Random;

public class LinearSearch {

  public static void main(String[] args) {
    Integer[] numbers = new Integer[1000000];
    Random rand = new Random();
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(1000000);
    }

    int index = linearSearch(808343, numbers);
    System.out.println(index);
  }

  public static int linearSearch(Comparable target, Comparable[] list) {
    int index = 0;
    while (index < list.length) {
      if (list[index].compareTo(target) == 0)
        return index;
      else
        index++;
    }
    return -1;
  }
}
