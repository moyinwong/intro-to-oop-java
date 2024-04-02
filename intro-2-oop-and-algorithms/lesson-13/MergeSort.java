import java.util.Arrays;
import java.util.Random;

public class MergeSort {
  public static void main(String[] args) {
    int BOUND = 1000000;
    Comparable[] integers = new Integer[BOUND];
    Random rand = new Random();

    for (int i = 0; i < integers.length; i++) {
      integers[i] = rand.nextInt(BOUND);
    }
    sort(integers);
    System.out.println(Arrays.toString(integers));
  }

  public static void sort(Comparable[] nums) {
    mergeSort(nums, 0, nums.length - 1);
  }

  public static void mergeSort(Comparable[] list, int start, int end) {
    if (start == end) {
      return;
    }

    int mid = (end - start) / 2;
    mergeSort(list, start, start + mid);
    mergeSort(list, start + mid + 1, end);
    merge(list, start, start + mid + 1, end);
  }

  private static void merge(Comparable[] list, int leftHalfStart, int rightHalfStart, int end) {
    int leftHalfSize = rightHalfStart - leftHalfStart;
    int rightHalfSize = end - rightHalfStart + 1;

    Comparable[] leftList = new Comparable[leftHalfSize];
    Comparable[] rightList = new Comparable[rightHalfSize];

    // System.out.println("left half start is " + leftHalfStart + ". Right half
    // start is " + rightHalfStart);
    // System.out.println("left half size is " + leftHalfSize + ". Right half start
    // is " + rightHalfSize);
    for (int i = 0; i < leftHalfSize; i++) {
      leftList[i] = list[i + leftHalfStart];
    }
    for (int j = 0; j < rightHalfSize; j++) {
      rightList[j] = list[j + rightHalfStart];
    }

    int leftListIndex = 0;
    int rightListIndex = 0;

    int smallestIndex = leftHalfStart;

    while (leftListIndex < leftHalfSize && rightListIndex < rightHalfSize) {
      if (leftList[leftListIndex].compareTo(rightList[rightListIndex]) <= 0) {
        list[smallestIndex] = leftList[leftListIndex];
        leftListIndex++;
      } else {
        list[smallestIndex] = rightList[rightListIndex];
        rightListIndex++;
      }

      smallestIndex++;
    }

    while (leftListIndex < leftHalfSize) {
      list[smallestIndex] = leftList[leftListIndex];
      leftListIndex++;
      smallestIndex++;
    }

    while (rightListIndex < rightHalfSize) {
      list[smallestIndex] = rightList[rightListIndex];
      rightListIndex++;
      smallestIndex++;
    }
  }
}
