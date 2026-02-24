import java.util.*;

class Solution {
    String secFrequent(String arr[], int N) {
        
        if(N < 2) return "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // Step 1: Count frequency
        for(String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        int firstMax = 0;
        int secondMax = 0;
        
        // Step 2: Find first and second max frequency
        for(int freq : map.values()) {
            if(freq > firstMax) {
                secondMax = firstMax;
                firstMax = freq;
            } 
            else if(freq > secondMax && freq < firstMax) {
                secondMax = freq;
            }
        }
        
        // Step 3: Find string with second max frequency
        for(String key : map.keySet()) {
            if(map.get(key) == secondMax) {
                return key;
            }
        }
        
        return "";
    }
}
