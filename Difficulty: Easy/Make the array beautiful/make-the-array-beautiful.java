import java.util.*;

class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {

            // If stack is not empty and signs are different
            if (!stack.isEmpty() &&
                ((stack.peek() >= 0 && num < 0) ||
                 (stack.peek() < 0 && num >= 0))) {

                stack.pop(); // remove adjacent opposite signs
            } else {
                stack.push(num);
            }
        }

        return new ArrayList<>(stack);
    }
}