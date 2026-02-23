import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public static PriorityQueue<Integer> insertion(ArrayList<Integer> arr) {
        
        // Create a Min Heap (default behavior of PriorityQueue)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Insert all elements into the PriorityQueue
        for (int num : arr) {
            pq.add(num);
        }
        
        // Return the PriorityQueue
        return pq;
    }
}
