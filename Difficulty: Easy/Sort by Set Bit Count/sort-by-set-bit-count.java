import java.util.*;
import java.util.*;

class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        
        // Stable sort based on set bits (descending)
        Arrays.sort(temp, (a, b) -> Integer.bitCount(b) - Integer.bitCount(a));
        
        // Convert to ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        for (int x : temp) {
            result.add(x);
        }
        
        return result;
    }
}