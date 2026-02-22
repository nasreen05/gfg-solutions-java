import java.util.HashMap;

class Solution {
    public long subarrayXor(int arr[], int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        long count = 0;
        int xr = 0;
        
        // To handle subarrays starting from index 0
        map.put(0, 1);
        
        for (int i = 0; i < arr.length; i++) {
            
            xr = xr ^ arr[i];  // Update prefix XOR
            
            int x = xr ^ k;
            
            if (map.containsKey(x)) {
                count += map.get(x);
            }
            
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }
        
        return count;
    }
}
