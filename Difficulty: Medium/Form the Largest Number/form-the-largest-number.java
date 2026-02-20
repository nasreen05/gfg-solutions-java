import java.util.*;

class Solution {
    public String findLargest(int[] arr) {
        
        int n = arr.length;
        String[] str = new String[n];
        
        // Convert int array to String array
        for (int i = 0; i < n; i++) {
            str[i] = String.valueOf(arr[i]);
        }
        
        // Custom sort
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
        
        // Edge case: if largest number is 0
        if (str[0].equals("0")) {
            return "0";
        }
        
        // Build final result
        StringBuilder result = new StringBuilder();
        for (String s : str) {
            result.append(s);
        }
        
        return result.toString();
    }
}
