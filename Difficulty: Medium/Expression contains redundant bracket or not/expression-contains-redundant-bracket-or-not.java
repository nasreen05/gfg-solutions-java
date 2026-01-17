class Solution {
    public static boolean checkRedundancy(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // If closing bracket found
            if (ch == ')') {
                boolean hasOperator = false;

                // Pop till opening bracket
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }

                // Remove opening bracket
                stack.pop();

                // No operator inside → redundant
                if (!hasOperator) {
                    return true;
                }
            } 
            else {
                stack.push(ch);
            }
        }
        return false;
    }
}
