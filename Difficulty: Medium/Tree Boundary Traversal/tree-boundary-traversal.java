class Solution {

    ArrayList<Integer> result;

    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    void addLeftBoundary(Node node) {
        Node curr = node.left;
        while (curr != null) {
            if (!isLeaf(curr)) result.add(curr.data);
            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    void addLeaves(Node node) {
        if (node == null) return;

        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }

        addLeaves(node.left);
        addLeaves(node.right);
    }

    void addRightBoundary(Node node) {
        Stack<Integer> stack = new Stack<>();
        Node curr = node.right;

        while (curr != null) {
            if (!isLeaf(curr)) stack.push(curr.data);
            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }

    // 🔧 METHOD NAME FIXED HERE
    ArrayList<Integer> boundaryTraversal(Node node) {
        result = new ArrayList<>();

        if (node == null) return result;

        if (!isLeaf(node))
            result.add(node.data); // root

        addLeftBoundary(node);
        addLeaves(node);
        addRightBoundary(node);

        return result;
    }
}
