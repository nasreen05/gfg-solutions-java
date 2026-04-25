import java.util.*;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int num : arr) {
            boolean added = false;
            
            while (!stack.isEmpty() && stack.peek() * num < 0) {
                int top = stack.peek();
                
                if (Math.abs(top) > Math.abs(num)) {
                    // top survives
                    added = true;
                    break;
                } 
                else if (Math.abs(top) < Math.abs(num)) {
                    // current survives → remove top and continue
                    stack.pop();
                } 
                else {
                    // equal → both removed
                    stack.pop();
                    added = true;
                    break;
                }
            }
            
            if (!added) {
                stack.push(num);
            }
        }
        
        return new ArrayList<>(stack);
    }
}
