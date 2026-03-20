class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node pre = null, suc = null;
        Node curr = root;

        // Step 1: Find node and track potential pre & suc
        while (curr != null) {
            if (curr.data == key) {
                // Find predecessor (max in left subtree)
                if (curr.left != null) {
                    Node temp = curr.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    pre = temp;
                }

                // Find successor (min in right subtree)
                if (curr.right != null) {
                    Node temp = curr.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    suc = temp;
                }
                break;
            } 
            else if (key < curr.data) {
                suc = curr;      // potential successor
                curr = curr.left;
            } 
            else {
                pre = curr;      // potential predecessor
                curr = curr.right;
            }
        }

        ArrayList<Node> result = new ArrayList<>();
        result.add(pre);
        result.add(suc);
        return result;
    }
}
