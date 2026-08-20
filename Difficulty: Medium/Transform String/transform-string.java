class Solution {
    int transform(String s1, String s2) {

        int n = s1.length();

        if (n != s2.length()) {
            return -1;
        }

        // Check whether both strings contain the same characters
        int[] freq = new int[256];

        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }

        for (int x : freq) {
            if (x != 0) {
                return -1;
            }
        }

        int i = n - 1;
        int j = n - 1;
        int operations = 0;

        while (i >= 0) {

            if (j >= 0 && s1.charAt(i) == s2.charAt(j)) {
                // This character stays in its relative position
                i--;
                j--;
            } else {
                // This character must be moved to the front
                operations++;
                i--;
            }
        }

        return operations;
    }
}