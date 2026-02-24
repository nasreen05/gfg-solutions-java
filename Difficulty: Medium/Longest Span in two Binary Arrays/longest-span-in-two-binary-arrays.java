import java.util.HashMap;

class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        
        int n = a1.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixSum = 0;
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            
            // Create difference and update prefix sum
            prefixSum += (a1[i] - a2[i]);
            
            // If prefix sum becomes 0, span is from 0 to i
            if (prefixSum == 0) {
                maxLen = i + 1;
            }
            
            // If prefix sum seen before
            if (map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                // Store first occurrence only
                map.put(prefixSum, i);
            }
        }
        
        return maxLen;
    }
}
