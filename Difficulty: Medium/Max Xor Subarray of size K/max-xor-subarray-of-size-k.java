class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;
        
        // Step 1: XOR of first window
        int currentXor = 0;
        for (int i = 0; i < k; i++) {
            currentXor ^= arr[i];
        }

        int maxXor = currentXor;

        // Step 2: Slide the window
        for (int i = k; i < n; i++) {
            currentXor ^= arr[i - k]; // Remove left element
            currentXor ^= arr[i];     // Add new right element
            
            maxXor = Math.max(maxXor, currentXor);
        }

        return maxXor;
    }
}
