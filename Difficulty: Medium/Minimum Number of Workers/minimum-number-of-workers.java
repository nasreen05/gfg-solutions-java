import java.util.*;

class Solution {
    public int minMen(int arr[]) {
        int n = arr.length;
        List<int[]> intervals = new ArrayList<>();

        // Step 1: Build intervals
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int start = Math.max(0, i - arr[i]);
                int end = Math.min(n - 1, i + arr[i]);
                intervals.add(new int[]{start, end});
            }
        }

        // Step 2: Sort intervals
        intervals.sort((a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int count = 0;
        int idx = 0;
        int coveredTill = 0;

        // Step 3: Greedy cover
        while (coveredTill < n) {
            int farthest = coveredTill;

            while (idx < intervals.size() && intervals.get(idx)[0] <= coveredTill) {
                farthest = Math.max(farthest, intervals.get(idx)[1] + 1);
                idx++;
            }

            if (farthest == coveredTill) {
                return -1; // gap found
            }

            count++;
            coveredTill = farthest;
        }

        return count;
    }
}
