class Solution {
    private int moves;  // global counter

    public int distCandy(Node root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(Node node) {
        if (node == null) return 0;

        // Postorder traversal
        int left = dfs(node.left);
        int right = dfs(node.right);

        // Add total moves required for left and right subtree
        moves += Math.abs(left) + Math.abs(right);

        // Current node's balance
        return node.data + left + right - 1;
    }
}
