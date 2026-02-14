import java.util.*;

class Solution {
    public ArrayList<Integer> frequencyCount(int[] arr) {
        
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        
        // Count frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Store result
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int freq : map.values()) {
            result.add(freq);
        }
        
        return result;
    }
}
