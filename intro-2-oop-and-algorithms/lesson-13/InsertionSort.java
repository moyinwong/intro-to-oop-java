import java.util.Arrays;

public class InsertionSort {

  public static void main(String[] args) {
    int[] nums = { 5, 1, 3, 8, 7 };
    sort(nums);
    System.out.println(Arrays.toString(nums));
  }

  public static void sort(int[] nums) {
    for (int unsortedIndex = 1; unsortedIndex < nums.length; unsortedIndex++) {
      int nextSmallerEle = nums[unsortedIndex];
      int sortedIndex = unsortedIndex - 1;

      while (sortedIndex >= 0 && nums[sortedIndex] > nextSmallerEle) {
        nums[sortedIndex + 1] = nums[sortedIndex];
        sortedIndex--;
      }

      nums[sortedIndex + 1] = nextSmallerEle;
    }
  }
}
