import java.util.*;

class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        int count = 0;
        
        for(int i = 0; i < str.length(); i++) {
            
            char ch = str.charAt(i);
            
            if(ch == '(') {
                count++;
                stack.push(count);
                result.add(count);
            }
            
            else if(ch == ')') {
                result.add(stack.pop());
            }
        }
        
        return result;
    }
}
