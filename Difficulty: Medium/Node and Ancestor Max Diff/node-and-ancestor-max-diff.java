class Solution {

    int maxDiff(Node root) {
        return solve(root, root.data, false);
    }

    private int solve(Node node, int maxAncestor, boolean hasAncestor) {

        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int ans = Integer.MIN_VALUE;

        // Only calculate difference if this node
        // has a real ancestor
        if (hasAncestor) {
            ans = maxAncestor - node.data;
        }

        // Current node becomes an ancestor for its children
        int newMaxAncestor = Math.max(maxAncestor, node.data);

        int left = solve(node.left, newMaxAncestor, true);
        int right = solve(node.right, newMaxAncestor, true);

        return Math.max(ans, Math.max(left, right));
    }
}