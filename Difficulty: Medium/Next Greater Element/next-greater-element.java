import java.util.*;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(n);
        Stack<Integer> st = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove smaller or equal elements
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // If stack is empty, no greater element
            if (st.isEmpty()) {
                res.add(-1);
            } else {
                res.add(st.peek());
            }

            // Push current element
            st.push(arr[i]);
        }

        // Reverse result to restore order
        Collections.reverse(res);
        return res;
    }
}
