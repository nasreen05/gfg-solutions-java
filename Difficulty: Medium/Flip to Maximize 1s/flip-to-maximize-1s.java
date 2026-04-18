class Solution {
    int maxOnes(int[] arr) {
        int totalOnes = 0;
        
        // Count total ones
        for(int num : arr) {
            if(num == 1) totalOnes++;
        }
        
        // Apply Kadane's Algorithm
        int maxGain = 0;
        int currentGain = 0;
        
        for(int num : arr) {
            int value = (num == 0) ? 1 : -1;
            
            currentGain = Math.max(value, currentGain + value);
            maxGain = Math.max(maxGain, currentGain);
        }
        
        return totalOnes + maxGain;
    }
}
