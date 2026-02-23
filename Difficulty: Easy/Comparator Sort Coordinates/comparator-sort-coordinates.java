import java.util.Arrays;

class Solution {
    public static void coordinatesSort(Point[] arr) {
        
        // Sort by x in increasing order
        // If x is same, then sort by y in increasing order
        Arrays.sort(arr, (p1, p2) -> {
            if (p1.x == p2.x) {
                return p1.y - p2.y;   // sort by y if x is same
            }
            return p1.x - p2.x;       // sort by x
        });
    }
}
