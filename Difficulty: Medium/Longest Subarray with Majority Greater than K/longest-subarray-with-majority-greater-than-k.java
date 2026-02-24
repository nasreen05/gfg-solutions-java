import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        
        // Step 1: Convert array into +1 and -1
        for(int i = 0; i < n; i++) {
            if(arr[i] > k)
                arr[i] = 1;
            else
                arr[i] = -1;
        }
        
        // Step 2: Use prefix sum + hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int maxLen = 0;
        
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            
            // If sum > 0 → whole subarray valid
            if(sum > 0)
                maxLen = i + 1;
            
            // Store first occurrence of sum
            if(!map.containsKey(sum))
                map.put(sum, i);
            
            // If (sum - 1) exists → subarray with sum > 0 exists
            if(map.containsKey(sum - 1)) {
                maxLen = Math.max(maxLen, i - map.get(sum - 1));
            }
        }
        
        return maxLen;
    }
}
