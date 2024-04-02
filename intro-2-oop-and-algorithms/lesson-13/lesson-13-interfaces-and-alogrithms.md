# Lesson 13. Interfaces and Algorithms

## Interface

- it allows us to express **has a** relationship instead of **is a** relationship from inheritance
- so that we can group objects that have no meaningful inheritance relationships but share **similar behaviours**
- methods are default `abstract` and `public`
- If a superclass implements an interface, the subclass also need to implment it

## Generic Type

- a generic type is an interface or class that is capable of accepting input that identifies the kinds of data (i.e., types) it can work with

## Sorting Algorithms

1. Merge sort
2. Insertion sort
3. Bubble sort
4. Quicksort
5. Selection sort

- java `Arrays.sort()` use **Timesort**

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

### Merge Sort

## Find the efficiency of an algorithm

This is done through bothcomplexity analysis (Time & Space). Several important questions to ask:

- _Does the number of operations that an algorithm performs stay constant regardless of how big the input is?_
- _If the operation count grows as input size increases, then is the growth a directly proportional one?_
- _If things could be a lot worse, what might such growth rates look like?_
