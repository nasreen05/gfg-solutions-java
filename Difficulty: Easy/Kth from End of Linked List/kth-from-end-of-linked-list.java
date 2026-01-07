/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
} */
class Solution {

    // Function to find the data of kth node from the end of a linked list.
    int getKthFromLast(Node head, int k) {
        if (head == null || k <= 0) return -1;

        Node fast = head;
        Node slow = head;

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return -1; // k is greater than number of nodes
            }
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }
}
