 import java.util.*;

class Solution {
    
    public ArrayList<String> permutation(String S) {
        
        ArrayList<String> res = new ArrayList<>();
        
        char[] arr = S.toCharArray();
        
        // Generate all permutations
        permute(arr, 0, res);
        
        // Sort lexicographically
        Collections.sort(res);
        
        return res;
    }
    
    void permute(char[] arr, int index, ArrayList<String> res) {
        
        if (index == arr.length) {
            res.add(new String(arr));
            return;
        }
        
        for (int i = index; i < arr.length; i++) {
            
            // Swap
            swap(arr, index, i);
            
            // Recurse
            permute(arr, index + 1, res);
            
            // Backtrack
            swap(arr, index, i);
        }
    }
    
    void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
