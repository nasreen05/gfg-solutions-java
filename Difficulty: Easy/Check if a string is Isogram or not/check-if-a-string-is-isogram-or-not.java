
import java.util.*;

class Solution {
    // Function to check if a string is Isogram or not.
    static boolean isIsogram(String data) {
        HashSet<Character> set = new HashSet<>();

        for (char ch : data.toCharArray()) {
            if (set.contains(ch)) {
                return false; // duplicate found
            }
            set.add(ch);
        }

        return true;
    }
}
