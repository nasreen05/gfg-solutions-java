import java.util.*;

class Solution {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        
        List<Integer> result = new ArrayList<>();
        
        int i = 0, j = 0, k = 0;
        
        while (i < arr1.size() && j < arr2.size() && k < arr3.size()) {
            
            int a = arr1.get(i);
            int b = arr2.get(j);
            int c = arr3.get(k);
            
            // If all three are equal
            if (a == b && b == c) {
                
                result.add(a);
                
                // Skip duplicates in arr1
                while (i < arr1.size() && arr1.get(i) == a) i++;
                
                // Skip duplicates in arr2
                while (j < arr2.size() && arr2.get(j) == b) j++;
                
                // Skip duplicates in arr3
                while (k < arr3.size() && arr3.get(k) == c) k++;
            }
            
            // Move the pointer of smallest element
            else if (a < b) {
                i++;
            }
            else if (b < c) {
                j++;
            }
            else {
                k++;
            }
        }
        
        if (result.size() == 0) {
            result.add(-1);
        }
        
        return result;
    }
}
