/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/

class Solution {
    
    public void toSumTree(Node root) {
        solve(root);
    }
    
    // Returns sum of original subtree
    int solve(Node node) {
        if (node == null)
            return 0;
        
        int oldValue = node.data;
        
        int leftSum = solve(node.left);
        int rightSum = solve(node.right);
        
        // Update current node with sum of left and right subtrees
        node.data = leftSum + rightSum;
        
        // Return total sum of original subtree
        return oldValue + node.data;
    }
}