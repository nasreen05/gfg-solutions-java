class Solution {
    public String firstNonRepeating(String s) {
        int[] freq = new int[26];
        StringBuilder result = new StringBuilder();
        java.util.Queue<Character> queue = new java.util.LinkedList<>();

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
            queue.offer(ch);

            // Remove repeating characters from front
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            // Append result
            if (queue.isEmpty()) {
                result.append('#');
            } else {
                result.append(queue.peek());
            }
        }

        return result.toString();
    }
}
