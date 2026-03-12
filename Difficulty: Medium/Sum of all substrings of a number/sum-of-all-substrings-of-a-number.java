class Solution {
    public static int sumSubstrings(String s) {
        int n = s.length();
        int prev = s.charAt(0) - '0';
        int total = prev;

        for (int i = 1; i < n; i++) {
            int digit = s.charAt(i) - '0';
            int curr = (i + 1) * digit + 10 * prev;
            total += curr;
            prev = curr;
        }

        return total;
    }
}
