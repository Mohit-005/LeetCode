# Explanation of [543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/description/)

## Approach

1. **Define a function to calculate the diameter (longest path) and height of a subtree recursively.**
   - In the function, handle the base case (empty subtree) and then calculate diameters and heights for left and right subtrees.

2. **Calculate the current subtree's diameter as the maximum of:**
   - Path through the current node (left height + right height)
   - Maximum diameter in the left or right subtree

3. **Calculate the current subtree's height and return both diameter and height as a pair.**

4. **In the main function, call the helper function on the root and return the maximum diameter found.**

## Complexity

- **Time complexity:**
  - O(n)
    - (n is the number of nodes in the tree)

- **Space complexity:**
  - O(n)
    - (due to recursive function calls and call stack)
