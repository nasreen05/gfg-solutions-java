import java.util.*;

class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int i = 0, j = 0, k = 0;
        
        while (i < a.length && j < b.length && k < c.length) {
            
            // If all are equal → common element found
            if (a[i] == b[j] && b[j] == c[k]) {
                result.add(a[i]);
                
                int val = a[i];
                
                // Skip duplicates in all arrays
                while (i < a.length && a[i] == val) i++;
                while (j < b.length && b[j] == val) j++;
                while (k < c.length && c[k] == val) k++;
            }
            else {
                // Move the pointer of the smallest element
                if (a[i] < b[j]) {
                    i++;
                } 
                else if (b[j] < c[k]) {
                    j++;
                } 
                else {
                    k++;
                }
            }
        }
        
        return result;
    }
}
