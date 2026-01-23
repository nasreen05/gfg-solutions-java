import java.util.*;

class Solution {
    int maxPeople(int[] arr) {
        int n = arr.length;

        int[] prevGE = new int[n]; // previous greater or equal
        int[] nextGE = new int[n]; // next greater or equal

        Arrays.fill(prevGE, -1);
        Arrays.fill(nextGE, n);

        Stack<Integer> stack = new Stack<>();

        // Previous Greater or Equal
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            prevGE[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Greater or Equal
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            nextGE[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = i - prevGE[i] - 1;
            int right = nextGE[i] - i - 1;
            ans = Math.max(ans, left + right + 1);
        }

        return ans;
    }
}
