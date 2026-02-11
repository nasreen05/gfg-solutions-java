import java.util.*;

class Solution {
    public static int binarySearchAL(ArrayList<Integer> list, int k) {
        
        int low = 0;
        int high = list.size() - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (list.get(mid) == k) {
                return mid;   // element found
            } 
            else if (list.get(mid) < k) {
                low = mid + 1;   // search right
            } 
            else {
                high = mid - 1;  // search left
            }
        }
        
        return -1;  // element not found
    }
}
