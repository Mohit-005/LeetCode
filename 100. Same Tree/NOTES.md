# Explanation of [100. Same Tree](https://leetcode.com/problems/same-tree/description/?envType=daily-question&envId=2024-02-23) Solution

## Approaches
(Also explained in the code)

1. **Base Case Handling:**
   - Checks if both trees are empty. If so, returns true.

2. **Null Check:**
   - If one tree is empty while the other is not, returns false.

3. **Value Comparison:**
   - Compares the values of the current nodes in both trees.

4. **Recursive Calls:**
   - Recursively calls the function for left subtrees and right subtrees.

5. **Return:**
   - Returns true if all conditions hold true, indicating identical trees; otherwise, returns false.

## Complexity
**Time complexity:**
- O(n)
  - (n is the number of nodes in the tree)

**Space complexity:**
- O(h)
  - (h is the height of the tree)

