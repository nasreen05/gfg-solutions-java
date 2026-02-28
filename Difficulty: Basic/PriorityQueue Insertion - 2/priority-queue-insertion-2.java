import java.util.*;

class Solution {
    public static PriorityQueue<Integer> insertion(ArrayList<Integer> arr) {
        
        // Create Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // Insert elements
        for(int num : arr) {
            pq.add(num);
        }
        
        return pq;
    }
}
