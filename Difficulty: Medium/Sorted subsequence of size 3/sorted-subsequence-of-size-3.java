import java.util.*;

class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        if(n < 3)
            return result;
        
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        
        // Step 1: Build leftMin array
        leftMin[0] = arr[0];
        for(int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
        }
        
        // Step 2: Build rightMax array
        rightMax[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        
        // Step 3: Find valid triplet
        for(int i = 1; i < n - 1; i++) {
            
            if(leftMin[i] < arr[i] && arr[i] < rightMax[i]) {
                
                result.add(leftMin[i]);
                result.add(arr[i]);
                result.add(rightMax[i]);
                
                return result;
            }
        }
        
        return result;
    }
}
