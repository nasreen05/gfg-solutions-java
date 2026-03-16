import java.util.*;

class Solution {
    int count = 0;

    public int countAllPaths(Node root, int k) {
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, k, path);
        return count;
    }

    void dfs(Node node, int k, ArrayList<Integer> path) {
        if (node == null) return;

        // add current node
        path.add(node.data);

        int sum = 0;

        // check path sums from current node backwards
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k) {
                count++;
            }
        }

        // traverse children
        dfs(node.left, k, path);
        dfs(node.right, k, path);

        // remove current node (backtracking)
        path.remove(path.size() - 1);
    }
}
