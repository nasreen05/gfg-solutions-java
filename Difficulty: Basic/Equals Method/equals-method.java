class Solution {
    public static boolean areEqual(int a[], int b[]) {
        
        // If lengths are different, arrays cannot be equal
        if (a.length != b.length) {
            return false;
        }
        
        // Compare each element
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        
        // If all elements match
        return true;
    }
}
