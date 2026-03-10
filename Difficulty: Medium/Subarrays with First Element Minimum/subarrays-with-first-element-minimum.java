import java.util.*;

class Solution {
    public int countSubarrays(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        long count = 0;

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            int nextSmaller;
            if (st.isEmpty()) {
                nextSmaller = n;
            } else {
                nextSmaller = st.peek();
            }

            count += (nextSmaller - i);

            st.push(i);
        }

        return (int)count;
    }
}
