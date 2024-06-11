# Explanation of LeetCode Problem [1122. Relative Sort Array](https://leetcode.com/problems/relative-sort-array/) Explanation

# Intuition

The problem requires sorting `arr1` such that the relative order of elements in `arr2` is preserved in `arr1`. Any elements in `arr1` that are not in `arr2` should be sorted in ascending order and placed at the end of the array.

# Approach

1. **Count the occurrences of each element in `arr1`:**
   * Create a count array `cnt` of size 1001 (since the values range from 0 to 1000) to store the count of each element in `arr1`.
2. **Place elements from `arr2` in the result array `ans` according to their order in `arr2`:**
   * For each element `n` in `arr2`, add `n` to the result array `ans` as many times as it appears in `arr1` (using the count from `cnt`), and then decrease the count for `n` in `cnt`.
3. **Place the remaining elements in ascending order:**
   * Iterate through the count array `cnt` and for each element with a non-zero count, add it to the result array `ans` in ascending order until all elements are placed.

# Complexity

## Time Complexity

* **Counting elements in `arr1`:** O(N), where N is the length of `arr1`.
* **Placing elements from `arr2` into the result array:** O(M + N), where M is the length of `arr2`.
  * Iterating over `arr2` takes O(M), and placing each element into `ans` also takes O(N) in total since the sum of counts is N.
* **Placing remaining elements in ascending order:** O(1001) ≈ O(1), since the size of the count array is fixed and constant (1001).

Thus, the overall time complexity is  **O(N + M)** .

## Space Complexity

* The count array `cnt` uses O(1001) space, which is constant and considered O(1).
* The result array `ans` uses O(N) space to store the sorted elements.

Thus, the overall space complexity is  **O(N)** .
