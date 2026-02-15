import java.util.*;

class Solution {
    public static int countOnce(int arr[]) {
        
        // Create a HashSet to store unique elements
        HashSet<Integer> set = new HashSet<>();
        
        // Add all elements to the set
        for (int num : arr) {
            set.add(num);
        }
        
        // Return size of the set (unique count)
        return set.size();
    }
}
