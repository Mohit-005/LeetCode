# Explanation of [513. Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/description/) Solution

# Method 1

**Explanation:**

The code finds the leftmost value of the bottom row in a binary tree using a breadth-first search (BFS) approach.

1. Declare an integer variable 'last' to store the leftmost value.
2. Initialize a queue 'q' of TreeNode pointers and push the root node into the queue.
3. While the queue is not empty:
   a. Get the size of the queue to determine the number of elements at the current level.
   b. Iterate through each element at the current level:
      i. Pop the element from the queue and store it in 'curr'.
      ii. If it's the first element at the current level (i == 0), update 'last' with the value of the current node (curr->val).
      iii. Push the left and right child nodes of 'curr' into the queue.
   c. Move to the next level.

**Time Complexity:** O(N)

**Space Complexity:** O(w) (w is the maximum width of the tree)

```java
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int last = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode curr = q.poll();
                if (i == 0)
                    last = curr.val;  // last leftMost val
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return last;
    }
}
```

# Method 2

**Explanation:**

The code recursively finds the value of the bottom-left node in a binary tree, tracking the current depth and leftmost value at each level.

- **Parameters:** Accepts `root` (current node) and `currD` (current depth) as parameters.
- **Base Case:** Checks if the current node (`root`) is NULL. Returns from the function if the node is NULL.
- **Depth Update:** Checks if the current depth (`currD`) is greater than the previous maximum depth. If true, updates both depth and left variables with values corresponding to the new level.
- **Recursive Calls:** Regardless of depth updates, recursively calls the function on both left and right subtrees. Increments `currD` by 1 for each recursive call.
- **Result:** After all recursive calls finish, returns the leftmost value (`left`) and its level (`depth`).

**Time Complexity:** O(N)

**Space Complexity:** O(w) (w is the maximum width of the tree)

```java
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int[] result = new int[]{0, 0};
        help(root, 1, result);
        return result[1];
    }

    private void help(TreeNode node, int currD, int[] result) {
        if (node == null) {
            return;
        }

        // If we have reached a new level
        if (currD > result[0]) {
            result[0] = currD;
            result[1] = node.val;
        }

        // Explore left and right subtrees
        help(node.left, currD + 1, result);
        help(node.right, currD + 1, result);
    }
}
