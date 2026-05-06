class Solution {
    public int getSize(Node root) {
        // Base case
        if (root == null) {
            return 0;
        }
        
        // Recursive case
        return 1 + getSize(root.left) + getSize(root.right);
    }
}