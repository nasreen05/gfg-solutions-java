import java.util.*;

class Solution {
    Queue<Integer> q;

    Solution() { 
        q = new LinkedList<>(); 
    }

    // Push element at the end
    public void addElement(int key) {
        q.add(key);
    }

    // Remove and print front element
    public void RemoveElement() {
        if (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        } else {
            System.out.print("-1 ");
        }
    }

    // Print front element
    public void peekElement() {
        if (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
        } else {
            System.out.print("-1 ");
        }
    }

    // Print size of queue
    public void Size() {
        System.out.print(q.size() + " ");
    }
}
