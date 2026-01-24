/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    static class Pair {
        Node node;
        int hd;
        
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        // Map to store first node at each horizontal distance
        Map<Integer, Integer> map = new TreeMap<>();
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            Node node = curr.node;
            int hd = curr.hd;
            
            // Store only first occurrence at each horizontal distance
            map.putIfAbsent(hd, node.data);
            
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }
        
        // Extract values from leftmost to rightmost
        for (int val : map.values()) {
            result.add(val);
        }
        
        return result;
    }
}
