import java.util.*;

class Solution {
    public int countMinReversals(String s) {
        
        int n = s.length();
        
        // If length is odd, cannot balance
        if (n % 2 != 0) {
            return -1;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            if (ch == '{') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop(); // balanced pair
                } else {
                    stack.push(ch);
                }
            }
        }
        
        int open = 0, close = 0;
        
        while (!stack.isEmpty()) {
            if (stack.pop() == '{') {
                open++;
            } else {
                close++;
            }
        }
        
        return (open + 1) / 2 + (close + 1) / 2;
    }
}
