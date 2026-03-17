import java.util.*;

class Solution {

    public int minTime(Node root, int target) {
        // Step 1: Map child -> parent
        HashMap<Node, Node> parentMap = new HashMap<>();
        Node targetNode = buildParentMap(root, parentMap, target);

        // Step 2: BFS
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();

        q.offer(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                // left
                if (curr.left != null && !visited.contains(curr.left)) {
                    burned = true;
                    visited.add(curr.left);
                    q.offer(curr.left);
                }

                // right
                if (curr.right != null && !visited.contains(curr.right)) {
                    burned = true;
                    visited.add(curr.right);
                    q.offer(curr.right);
                }

                // parent
                if (parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))) {
                    burned = true;
                    visited.add(parentMap.get(curr));
                    q.offer(parentMap.get(curr));
                }
            }

            // if any node burned in this level, increase time
            if (burned) time++;
        }

        return time;
    }

    // Build parent map and find target node
    private Node buildParentMap(Node root, HashMap<Node, Node> parentMap, int target) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        Node targetNode = null;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.data == target) {
                targetNode = curr;
            }

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                q.offer(curr.left);
            }

            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                q.offer(curr.right);
            }
        }

        return targetNode;
    }
}
