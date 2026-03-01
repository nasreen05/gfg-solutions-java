import java.util.*;

class Solution {
    static int map(int n, String keys[], int arr[], String s) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        // Insert key-value pairs
        for(int i = 0; i < n; i++) {
            hm.put(keys[i], arr[i]);
        }
        
        // Check if key exists
        if(hm.containsKey(s)) {
            return hm.get(s);
        }
        
        return -1;
    }
}
