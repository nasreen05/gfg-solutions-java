import java.util.*;

class Solution {
    public int getMaxVal(List<Integer> arr, int k) {
        Collections.sort(arr);   // sort in ascending order
        
        int n = arr.size();
        int sum = 0;
        
        for(int i = n - 1; i >= n - k; i--) {
            sum += arr.get(i);
        }
        
        return sum;
    }
}
