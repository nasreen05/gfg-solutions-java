import java.util.*;

class Solution {

    class Node {
        int freq;
        int minIndex;
        char ch;
        Node left, right;

        Node(int freq, char ch, int index) {
            this.freq = freq;
            this.ch = ch;
            this.minIndex = index;
            this.left = null;
            this.right = null;
        }

        Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
            this.minIndex = Math.min(left.minIndex, right.minIndex);
        }
    }

    public ArrayList<String> huffmanCodes(String s, int f[]) {

        ArrayList<String> result = new ArrayList<>();

        // Edge case: only one character
        if (s.length() == 1) {
            result.add("0");
            return result;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.freq != b.freq)
                    return a.freq - b.freq;
                return a.minIndex - b.minIndex;
            }
        );

        for (int i = 0; i < s.length(); i++) {
            pq.add(new Node(f[i], s.charAt(i), i));
        }

        while (pq.size() > 1) {

            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(left.freq + right.freq, left, right);

            pq.add(parent);
        }

        Node root = pq.poll();

        preorder(root, "", result);

        return result;
    }

    void preorder(Node root, String code, ArrayList<String> result) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            result.add(code);
            return;
        }

        preorder(root.left, code + "0", result);
        preorder(root.right, code + "1", result);
    }
}

