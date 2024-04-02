import java.util.Arrays;

public class SelectionSort {
  public static void main(String[] args) {
    int[] nums = { 3, 9, 6, 1, 2, 9, 12, 15, 23, -1 };
    SelectionSort.sort(nums);
    System.out.println(Arrays.toString(nums));
  }

  public static void sort(int[] nums) {
    int lastSortIndex = -1;

    while (lastSortIndex < nums.length - 1) {
      int minIndex = lastSortIndex + 1;
      int swapIndex = lastSortIndex + 1;

      for (int i = lastSortIndex + 2; i < nums.length; i++) {
        if (nums[i] < nums[minIndex]) {
          minIndex = i;
        }
      }

      if (swapIndex != minIndex) {
        int temp = nums[minIndex];
        nums[minIndex] = nums[swapIndex];
        nums[swapIndex] = temp;
      }

      lastSortIndex++;
    }
  }

  public static void sort2(Comparable[] nums) {
    int minIndex;

    for (int unsortedIndex = 0; unsortedIndex < nums.length - 1; unsortedIndex++) {
      minIndex = unsortedIndex;

      for (int currentIndex = unsortedIndex + 1; currentIndex < nums.length; currentIndex++) {
        if (nums[currentIndex].compareTo(nums[minIndex]) < 0) {
          minIndex = currentIndex;
        }
      }

      Comparable temp = nums[minIndex];
      nums[minIndex] = nums[unsortedIndex];
      nums[unsortedIndex] = temp;
    }
  }
}
