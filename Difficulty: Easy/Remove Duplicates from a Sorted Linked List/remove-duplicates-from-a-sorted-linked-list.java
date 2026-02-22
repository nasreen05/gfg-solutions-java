class Solution {
    // Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head) {
        
        if (head == null) return head;
        
        Node current = head;
        
        while (current != null && current.next != null) {
            
            if (current.data == current.next.data) {
                // Remove duplicate
                current.next = current.next.next;
            } 
            else {
                // Move forward
                current = current.next;
            }
        }
        
        return head;
    }
}
