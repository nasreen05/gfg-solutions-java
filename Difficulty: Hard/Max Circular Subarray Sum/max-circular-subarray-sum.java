class Solution {
    public int maxCircularSum(int arr[]) {
        int n = arr.length;

        int maxKadane = arr[0];
        int currMax = arr[0];

        int minKadane = arr[0];
        int currMin = arr[0];

        int totalSum = arr[0];

        for (int i = 1; i < n; i++) {
            // Kadane for maximum subarray
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxKadane = Math.max(maxKadane, currMax);

            // Kadane for minimum subarray
            currMin = Math.min(arr[i], currMin + arr[i]);
            minKadane = Math.min(minKadane, currMin);

            totalSum += arr[i];
        }

        // If all elements are negative
        if (maxKadane < 0)
            return maxKadane;

        int maxCircular = totalSum - minKadane;

        return Math.max(maxKadane, maxCircular);
    }
}
