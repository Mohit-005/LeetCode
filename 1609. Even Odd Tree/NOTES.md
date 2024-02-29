# Explanation for [1609. Even-Odd Tree Check](https://leetcode.com/problems/even-odd-tree/description/?envType=daily-question&envId=2024-02-29) Solution

## Intuition

The initial thought for solving tree questions is often to consider using Breadth-First Search (BFS) or Depth-First Search (DFS). In this case, BFS seems like a good starting point due to the requirement to check strictly increasing or decreasing order in levels. The approach involves traversing the tree level by level, maintaining a queue of nodes at each level.

## Approach

Here's an explanation of the code:

1. **Breadth-First Search (BFS):** The code utilizes BFS to traverse the tree level by level, using a queue to keep track of nodes at each level.

2. **Flag for Alternating Levels:** A boolean flag, named `flag`, is used to determine whether the current level should have odd or even values.

3. **Conditions Checking:** Inside the BFS loop, the code checks the following conditions for each node:

   a. If the current level is odd (flag is true), then the node value should be odd, and it should be strictly greater than the previous node's value.
   
   b. If the current level is even (flag is false), then the node value should be even, and it should be strictly less than the previous node's value.

   c. If any of these conditions are not met, the function returns false immediately.

4. **Updating Queue:** The code enqueues the left and right children of each node (if they exist) into the queue for the next level.

5. **Updating Previous Value:** The variable `prev` is updated with the value of the current node, ensuring it's used in the next iteration for comparison.

6. **Alternating Levels:** After processing each level, the flag is toggled to switch between odd and even levels.

7. **Returning Result:** If the BFS completes without encountering any violation of conditions, the function returns true, indicating that the tree is an Even-Odd Tree.

## Complexity

- Time complexity: O(n) because each node is traversed once.
- Space complexity: O(n) because of the queue used for BFS.
