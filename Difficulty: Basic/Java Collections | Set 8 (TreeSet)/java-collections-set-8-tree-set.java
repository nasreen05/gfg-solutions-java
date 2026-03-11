import java.util.*;

class gfg1 {
    void task(TreeSet<String> ts, char a, char b, char c, char d) {
        
        // strings less than a
        System.out.println(ts.headSet(String.valueOf(a)));
        
        // strings greater than or equal to b
        System.out.println(ts.tailSet(String.valueOf(b)));
        
        // strings between c (inclusive) and d (exclusive)
        System.out.println(ts.subSet(String.valueOf(c), String.valueOf(d)));
    }
}
