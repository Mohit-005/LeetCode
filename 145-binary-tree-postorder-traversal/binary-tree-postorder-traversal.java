
class Solution {
    Queue<Integer> queue;

    public List<Integer> postorderTraversal(TreeNode root) {
        List result;
        queue = new LinkedList<>();
        
        dfs(root);

        return new ArrayList<>(queue);
    }

    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }

        dfs(node.left);
        dfs(node.right);
        queue.add(node.val);
    }
}