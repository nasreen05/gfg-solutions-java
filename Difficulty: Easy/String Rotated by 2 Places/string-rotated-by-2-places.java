class Solution {
    public static boolean isRotated(String s1, String s2) {

        // Length must be same
        if (s1.length() != s2.length()) {
            return false;
        }

        int n = s1.length();

        // If length is 0, 1 or 2
        if (n <= 2) {
            return s1.equals(s2);
        }

        // Anti-clockwise rotation
        String anti = s1.substring(2) + s1.substring(0, 2);

        // Clockwise rotation
        String clock = s1.substring(n - 2) + s1.substring(0, n - 2);

        return s2.equals(anti) || s2.equals(clock);
    }
}
