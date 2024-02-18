/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
public boolean isValidBST(TreeNode root) {
    //for empty tree
    return isValid(root, null, null);
}

public boolean isValid(TreeNode root, Integer min, Integer max) {
    if(root == null) 
        return true;
    if(min != null && root.val <= min) 
        return false;
    if(max != null && root.val >= max) 
        return false;
    
    return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
