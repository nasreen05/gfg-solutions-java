import java.util.HashSet;

class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        
        HashSet<Integer> set = new HashSet<>();
        
        // Store array elements in HashSet
        for (int num : arr) {
            set.add(num);
        }
        
        // Check every number in range [start, end]
        for (int i = start; i <= end; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        
        return true;
    }
}