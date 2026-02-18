import java.util.Stack;

class Solution {
    public String reverse(String S) {
        
        Stack<Character> stack = new Stack<>();
        
        // Push all characters into stack
        for (int i = 0; i < S.length(); i++) {
            stack.push(S.charAt(i));
        }
        
        // Pop characters to form reversed string
        StringBuilder reversed = new StringBuilder();
        
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        return reversed.toString();
    }
}
