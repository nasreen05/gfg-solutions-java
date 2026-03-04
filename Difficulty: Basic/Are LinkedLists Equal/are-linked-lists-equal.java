import java.util.*;

class Solution {
    public static boolean areEqual(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
        
        // If sizes are different → not equal
        if (ll1.size() != ll2.size()) {
            return false;
        }
        
        // Compare elements one by one
        for (int i = 0; i < ll1.size(); i++) {
            if (!ll1.get(i).equals(ll2.get(i))) {
                return false;
            }
        }
        
        return true;
    }
}
