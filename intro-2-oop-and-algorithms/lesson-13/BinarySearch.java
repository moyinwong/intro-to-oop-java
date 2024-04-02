import java.util.Random;

public class BinarySearch {

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
    int targetIndex = search(3, nums, 0, nums.length - 1);
    // System.out.println(targetIndex);

    int BOUND = 1000000;
    Comparable[] integers = new Integer[BOUND];
    Random rand = new Random();

    for (int i = 0; i < integers.length; i++) {
      integers[i] = i;
    }
    MergeSort.sort(integers);
    int index = search2(Integer.valueOf(0), integers);
    System.out.println(index);
  }

  public static int search(int target, int[] nums, int start, int end) {
    if (start == end) {
      return nums[start] == target ? start : -1;
    }

    int mid = (end - start) / 2;

    if (nums[start + mid] == target) {
      return mid;
    }

    if (nums[start + mid] > target) {
      return search(target, nums, start, start + mid - 1);
    }
    return search(target, nums, start + mid + 1, end);
  }

  public static int search2(Comparable target, Comparable[] items) {
    int start = 0;
    int end = items.length - 1;

    while (start <= end) {
      int mid = (start + end) / 2;

      if (items[mid].compareTo(target) == 0) {
        return mid;
      } else if (items[mid].compareTo(target) > 0) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return -1;
  }
}
