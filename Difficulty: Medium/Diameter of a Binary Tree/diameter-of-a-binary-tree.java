class Solution {

    int maxDiameter = 0;

    public int diameter(Node root) {
        height(root);
        return maxDiameter;
    }

    // Function to calculate height
    private int height(Node root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Update diameter (number of edges)
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
