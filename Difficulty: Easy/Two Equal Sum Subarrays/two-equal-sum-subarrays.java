class Solution {
    public boolean canSplit(int arr[]) {
        int totalSum = 0;
        
        // Step 1: Calculate total sum
        for(int num : arr) {
            totalSum += num;
        }
        
        // Step 2: If total sum is odd, cannot split equally
        if(totalSum % 2 != 0) {
            return false;
        }
        
        int prefixSum = 0;
        
        // Step 3: Check prefix sum equals half of total sum
        for(int i = 0; i < arr.length - 1; i++) {
            prefixSum += arr[i];
            
            if(prefixSum == totalSum / 2) {
                return true;
            }
        }
        
        return false;
    }
}
