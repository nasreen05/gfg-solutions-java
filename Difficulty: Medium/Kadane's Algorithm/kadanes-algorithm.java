class Solution {
    int maxSubarraySum(int[] arr) {
        int n = arr.length;
        int maxSum = arr[0];      // Stores overall maximum
        int currentSum = arr[0];  // Stores max subarray sum ending here
        
        for (int i = 1; i < n; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
