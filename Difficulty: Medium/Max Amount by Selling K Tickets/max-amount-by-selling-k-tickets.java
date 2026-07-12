import java.util.*;

class Solution {
    public int maxAmount(int[] arr, int k) {
        long mod = 1000000007L;
        long ans = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : arr) {
            maxHeap.offer(x);
        }

        while (k-- > 0 && !maxHeap.isEmpty()) {
            int curr = maxHeap.poll();
            ans = (ans + curr) % mod;

            if (curr > 1) {
                maxHeap.offer(curr - 1);
            }
        }

        return (int) (ans % mod);
    }
}