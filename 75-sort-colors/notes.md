# Explanation of the [75. Sort Colors](https://leetcode.com/problems/sort-colors/description/) Solution

# Intuition
The problem of sorting an array of 0s, 1s, and 2s is effectively solved by the [Dutch National Flag algorithm](https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/). The idea is to use three pointers to categorize the elements into three sections: red (0s), white (1s), and blue (2s). By moving these pointers and swapping elements, we can ensure the array is sorted in a single pass.

# Approach
1. **Three Pointers**:
   - `low`: Tracks the boundary for 0s.
   - `mid`: Current element being examined.
   - `high`: Tracks the boundary for 2s.
   
2. **Traversal and Swapping**:
   - Traverse the array with the `mid` pointer.
   - Depending on the value at `nums[mid]`, perform swaps to move elements to their correct sections:
     - If `nums[mid] == 0`, swap it with the element at `low`, increment both `low` and `mid`.
     - If `nums[mid] == 1`, just move the `mid` pointer.
     - If `nums[mid] == 2`, swap it with the element at `high`, decrement `high` (do not increment `mid` in this case as the swapped element at `mid` needs to be checked).
   
# Time and Space Complexity
- ## Time Complexity: O(n)
  - The algorithm makes a single pass through the array, ensuring each element is checked and potentially swapped at most once.
- ## Space Complexity: O(1)
  - The algorithm sorts the array in place without using any extra space except for a few integer variables.


# Detailed Steps
1. **Initialization**:
   - Set `low = 0`, `mid = 0`, and `high = nums.length - 1`.
   
2. **Iteration**:
   - Use a `while` loop that runs until `mid` exceeds `high`.
   - Inside the loop:
     - If `nums[mid] == 0`, swap `nums[low]` and `nums[mid]`, then increment both `low` and `mid`.
     - If `nums[mid] == 1`, simply increment `mid`.
     - If `nums[mid] == 2`, swap `nums[mid]` and `nums[high]`, then decrement `high`.

By the end of the traversal, the array is sorted such that all 0s are at the beginning, followed by 1s, and then 2s. This efficient in-place sorting approach ensures the desired order with minimal computational overhead.
