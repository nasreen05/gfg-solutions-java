import java.util.*;

class Solution {
    public static void rotateByK(LinkedList<Integer> ll, int k) {
        
        int n = ll.size();
        k = k % n;
        
        for(int i = 0; i < k; i++){
            int last = ll.removeLast();
            ll.addFirst(last);
        }
    }
}
