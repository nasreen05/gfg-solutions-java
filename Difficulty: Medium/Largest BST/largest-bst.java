class Solution {

    // Helper class
    static class Info {
        int size;
        int min;
        int max;
        boolean isBST;

        Info(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    // Main function
    static int largestBst(Node root) {
        return solve(root).size;
    }

    static Info solve(Node node) {
        // Base case
        if (node == null) {
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        Info left = solve(node.left);
        Info right = solve(node.right);

        // Check BST condition
        if (left.isBST && right.isBST &&
            node.data > left.max && node.data < right.min) {

            int size = left.size + right.size + 1;
            int min = Math.min(node.data, left.min);
            int max = Math.max(node.data, right.max);

            return new Info(size, min, max, true);
        }

        // Not BST
        return new Info(Math.max(left.size, right.size), 0, 0, false);
    }
}
