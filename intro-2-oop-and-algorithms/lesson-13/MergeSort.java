import java.util.Arrays;

public class MergeSort {
  public static void main(String[] args) {
    int[] nums = { 5, 5, 3, 3, 2, 2, 1 };
    sort(nums);
    System.out.println(Arrays.toString(nums));
  }

  public static void sort(int[] nums) {
    mergeSort(nums, 0, nums.length - 1);
  }

  public static void mergeSort(int[] list, int start, int end) {
    if (start == end) {
      return;
    }

    int mid = (end - start) / 2;
    mergeSort(list, start, start + mid);
    mergeSort(list, start + mid + 1, end);
    merge(list, start, start + mid + 1, end);
  }

  private static void merge(int[] list, int leftHalfStart, int rightHalfStart, int end) {
    int leftHalfSize = rightHalfStart - leftHalfStart;
    int rightHalfSize = end - rightHalfStart + 1;

    int[] leftList = new int[leftHalfSize];
    int[] rightList = new int[rightHalfSize];

    System.out.println("left half start is " + leftHalfStart + ". Right half start is " + rightHalfStart);
    System.out.println("left half size is " + leftHalfSize + ". Right half start is " + rightHalfSize);
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
      if (leftList[leftListIndex] <= rightList[rightListIndex]) {
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
