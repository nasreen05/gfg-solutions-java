class Solution {

    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String reduced_String(int k, String s) {

        if (k == 1) return "";

        Stack<Pair> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (!stack.isEmpty() && stack.peek().ch == c) {

                stack.peek().count++;

                if (stack.peek().count == k) {
                    stack.pop();
                }

            } else {

                stack.push(new Pair(c, 1));
            }
        }

        StringBuilder result = new StringBuilder();

        for (Pair p : stack) {

            for (int i = 0; i < p.count; i++) {
                result.append(p.ch);
            }
        }

        return result.toString();
    }
}
