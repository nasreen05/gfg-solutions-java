import java.util.*;

class GfG {

    /* inserts an element x to the set s */
    void insert(LinkedHashSet<Integer> s, int x) {
        s.add(x);
    }

    /* prints the contents of the set s in ascending order */
    void print_Contents_Increasing_Order(LinkedHashSet<Integer> s) {
        TreeSet<Integer> ts = new TreeSet<>(s);  // sort elements
        
        for (int x : ts) {
            System.out.print(x + " ");
        }
    }

    /* prints the contents of the set s in insertion order */
    void print_Contents_Insertion_Order(LinkedHashSet<Integer> s) {
        for (int x : s) {
            System.out.print(x + " ");
        }
    }

    /* erases an element x from the set s */
    void erase(LinkedHashSet<Integer> s, int x) {
        s.remove(x);
    }

    /* returns the size of the set s */
    int size(LinkedHashSet<Integer> s) {
        return s.size();
    }

    /* returns 1 if x is present else -1 */
    int find(LinkedHashSet<Integer> s, int x) {
        if (s.contains(x)) return 1;
        return -1;
    }
}
