class Solution {
    Node reverseList(Node head) {
        
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        while(curr != null) {
            
            next = curr.next;   // Step 1: store next
            curr.next = prev;   // Step 2: reverse link
            
            prev = curr;        // Step 3: move prev
            curr = next;        // move curr
        }
        
        return prev;   // new head
    }
}
