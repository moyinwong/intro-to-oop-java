# Lesson 13. Interfaces and Algorithms

## Interface

- it allows us to express **has a** relationship instead of **is a** relationship from inheritance
- so that we can group objects that have no meaningful inheritance relationships but share **similar behaviours**
- methods are default `abstract` and `public`
- If a superclass implements an interface, the subclass also need to implment it

### Functional interface

A **functional interface** is interface with **only 1 abstract** method

## Generic Type

- a generic type is an interface or class that is capable of accepting input that identifies the kinds of data (i.e., types) it can work with

## Sorting Algorithms

1. **Merge sort**
2. **Insertion sort**
3. **Bubble sort**
4. **Quicksort**
5. **Selection sort**

- java `Arrays.sort()` use **Timesort**

## Find the efficiency of an algorithm

This is done through bothcomplexity analysis (Time & Space). Several important questions to ask:

- _Does the number of operations that an algorithm performs stay constant regardless of how big the input is?_
- _If the operation count grows as input size increases, then is the growth a directly proportional one?_
- _If things could be a lot worse, what might such growth rates look like?_

## Linear time and Linear Search

- when the input size and the times it takes for an algorithms to complete is directly proportional, it's called linear time/search
- The factor that makes the input size grow can be applied to the times.
- E.g. input size is n => 2n. Then the runtime is also increase by the same factor

**Time complexity: $O(n)$**

```java
public int isElementInArray(int[] nums, int target) {
  for (int i = 0; i < nums.length; i++) {
    if (nums[i] == target) {
      return true;
    }
  }
  return false;
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
```

## Binary search

Binary search has one important precondition, which is that **the elements of the list to search must be sorted**. We’ll explore the algorithm in the context of lists that are sorted in ascending order. Here are the steps:

1. Find the middle element of the list.
2. Compare that middle element’s value to that of the target item
3. If their values are equal, the target is found. Terminate.
4. If the target item is greater than the middle element, perform steps 1-3 on the right sublist
5. If the target item is less than the middle element, perform steps 1-3 on the left sublist
6. Repeat the above above until the target is found in step 3 or the algorithm reaches a single element sublist
7. If the single element is not the target, the target is not in the list. Terminate.

**Time complexity: $O(log n)$**

### Selection Sort

**Algorithms:**

1. Start from first index of the unsorted array
2. Compare the element at that index with the rest of the elements in the unsorted array
3. If found a smaller element, mark the index of that element the smallest
4. Iterating up to the end of the array
5. Swap the smallest element with the eleement at the first index of the unsorted array
6. Continue step 1 to 6 until the whole array is sorted

**Time complexity: $O(n^2)$**

- it's actually $n + n*(n - 1) / 2$, given there's an outer loop which will loop from 0 up to n (array.length) - 1. Plus the inner loop going from $(n - 1) + (n - 2) + (n - 3)... + 1$. This the arithmetic sum series of (n - 1) which is $n/2 + (n^2)/2$.<br />
  Since $n^2$ is the dominent factor here so the time complexity is $O(n^2)$
- same for both worst case and best case scenario as each loop still has to scan through all elements in the unsorted sublist

### Merge Sort

**Algorithms:**

1. Keep dividing the array into **left** and **right** sublist until the it cannot be divided (sublist size is 1)
2. Merge both sublist to get sorted list by:
   2.1 Compare the leftmost elements in **both** sublists
   2.2 Take the smaller element and insert at the leftmost index of the original array
   2.3 Continue to the next element for the sublist which element is smaller, a.k.a move the right
3. Continue step 2.1-2.3 until **all** elements in both sublists are being compared and put back to the original array

**Example**:

- `{3, 8, 20, 23, 4, 5, 7, 1}`

1. Array divided into `{3, 8, 20, 23}` and `{4, 5, 7, 1}`
2. `{3, 8, 20, 23}` divided into `{3, 8}` and `{20, 23}`
3. `{3, 8}` divided into `{3}` and `{8}`
4. `3` is less than `8`. So combined is `{3, 8}`
5. `{20, 23}` divided into `{20}` and `{23}`
6. `20` is less than `23`. So combined is `{20, 23}`
7. Comparing and combining `{3, 8}` and `{20, 23}`
8. `3` is less than `20`. So combined now is `{3, _, _, _}`
9. `8` is less than `20`. So combined now is `{3, 8, _, _}`
10. All elements in left sublist are iterated. Put remaining elements from right sublist to original array. We get `{3, 8, 20, 23}`
11. `{4, 5, 7, 1}` divided into `{4, 5}` and `{7, 1}`
12. `{4, 5}` divided into `{4}` and `{5}`
13. `4` is less than `5`. So combined is `{4, 5}`.
14. `{7, 1}` divided into `{7}` and `{1}`
15. `7` is greater than `1`. So combined is `{1, 7}`.
16. Comparing and combining `{4, 5}` and `{1, 7}`
17. `4` is greater than `1`. So combined now is `{1, _, _, _}`
18. `4` is less than `7`. So combined now is `{1, 4, _, _}`
19. `5` is less than `7`. So combined now is `{1, 4, 5, _}`
20. All elements from left sublist are iterated. Put remaining elements from right sublist to original array. We get `{1, 4, 5, 7}`
21. Comparing and combining `{3, 8, 20, 23}` and `{1, 4, 5, 7}`
22. `3` is greater than `1`. So combined now is `{1, _, _, _, _, _, _, _}`
23. `3` is less than `4`. So combined now is `{1, 3, _, _, _, _, _, _}`
24. `8` is less than `4`. So combined now is `{1, 3, 4, _, _, _, _, _}`
25. `8` is less than `5`. So combined now is `{1, 3, 4, 5, _, _, _, _}`
26. `8` is less than `7`. So combined now is `{1, 3, 4, 5, 7, _, _, _}`
27. All elements from right sublist are iterated. Put remaining elements from left sublist to original array. We get `{1, 3, 4, 5, 7, 8, 20, 23}`

**Time complexity: linearithmic (linear + logarithmic) $O(n * log n)$**

- the additional multiplication of `n` to get the $n * log n$ growth rate for merge sort accounts for the number of operations per layer growing linearly with n.

### Insertion Sort

**Algorithms:**

1. Assume there is a sorted sublist & an unsorted sublist
2. Assume the first element of the array is sorted
3. Iterate through the elements of the unsorted sublist
4. Scan through the elements of the sorted sublist from right to left
5. While an element in sorted sublist is greater than the current unsorted element
6. Keeping shifting the sorted sublist to the right. Keep track of the current index being shifted
7. When there's no element greater than the current element in unsorted sublist, insert it in that index

**Time complexity: $O(n^2)$ for worst case, $O(n)$ for best case**

<u>**Worst case**</u>

- for worst case, reversed order input e.g. `{5,4,3,2,1}`. There would be `n` loop and each loop keeps shifting all elements in sorted sublist to the right.
- E.g.
- loop 1: shift `5` to right and insert 4 at index `0`
- loop 2: shift `4, 5` to right and insert 3 at index `0`
- loop 3: shift `3, 4, 5` to right and insert 2 at index `0`
- loop 3: shift `2, 3, 4, 5` to right and insert 1 at index `0`
- so the total numbers of shift adding up is: $1 + 2 + 3... + (n-2) + (n-1)$
- It's **same** as insertion sort which is **$O(n^2)$**

<u>**Best case**</u>

- for best case, presorted input e.g. `{1,2,3,4,5}`. There would be `n` loop and each loop just do constant work
- e.g.
- loop 1: `2` is greater than the rightmost part of sorted sublist which is `1`. Continue to next unsorted element
- loop 1: `3` is greater than the rightmost part of sorted sublist which is `2`. Continue to next unsorted element
- loop 1: `4` is greater than the rightmost part of sorted sublist which is `3`. Continue to next unsorted element
- loop 1: `5` is greater than the rightmost part of sorted sublist which is `4`. Continue to next unsorted element

### Growth rate list

| Growth Rate  | Big-O notation |
| ------------ | -------------- |
| Constant     | $O(1) $        |
| Logarithmic  | $O(log(n)) $   |
| Linear       | $O(n) $        |
| Linearithmic | $O(nlog(n))$   |
| Quadratic    | $O(n^2)$       |
| Cubic        | $O(n^3)$       |
| Exponential  | $O(a^n)$       |
