import java.util.*;

class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        
        // Store all elements in HashSet
        for (int num : arr) {
            set.add(num);
        }
        
        // Check every number in range
        for (int i = low; i <= high; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
}
