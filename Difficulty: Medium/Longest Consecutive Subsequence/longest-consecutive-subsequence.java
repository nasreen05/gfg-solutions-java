import java.util.*;

class Solution {

    public int longestConsecutive(int[] arr) {
        
        int n = arr.length;
        if(n == 0) return 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        // Step 1: Add all elements to set
        for(int num : arr) {
            set.add(num);
        }
        
        int maxLen = 0;
        
        // Step 2: Check each number
        for(int num : set) {
            
            // Check if it's starting element
            if(!set.contains(num - 1)) {
                
                int currentNum = num;
                int count = 1;
                
                while(set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                
                maxLen = Math.max(maxLen, count);
            }
        }
        
        return maxLen;
    }
}
