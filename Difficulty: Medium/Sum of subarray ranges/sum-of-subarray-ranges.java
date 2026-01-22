import java.util.*;

class Solution {

    public int subarrayRanges(int[] arr) {
        int n = arr.length;

        long sumMax = sumSubarrayMax(arr, n);
        long sumMin = sumSubarrayMin(arr, n);

        return (int)(sumMax - sumMin);
    }

    // Sum of subarray minimums
    private long sumSubarrayMin(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? Integer.MIN_VALUE : arr[i];

            while (!stack.isEmpty() && arr[stack.peek()] > curr) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long count = (long)(mid - left) * (right - mid);
                sum += count * arr[mid];
            }
            stack.push(i);
        }
        return sum;
    }

    // Sum of subarray maximums
    private long sumSubarrayMax(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? Integer.MAX_VALUE : arr[i];

            while (!stack.isEmpty() && arr[stack.peek()] < curr) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long count = (long)(mid - left) * (right - mid);
                sum += count * arr[mid];
            }
            stack.push(i);
        }
        return sum;
    }
}
