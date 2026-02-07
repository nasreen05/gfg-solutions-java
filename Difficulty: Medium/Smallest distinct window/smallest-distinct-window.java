// User function Template for Java
class Solution {
    public int findSubString(String str) {

        int n = str.length();

        // Count distinct characters in the string
        boolean[] present = new boolean[26];
        int required = 0;

        for (int i = 0; i < n; i++) {
            if (!present[str.charAt(i) - 'a']) {
                present[str.charAt(i) - 'a'] = true;
                required++;
            }
        }

        int[] freq = new int[26];
        int count = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        // Sliding window
        for (int right = 0; right < n; right++) {
            char ch = str.charAt(right);

            if (freq[ch - 'a'] == 0) {
                count++;
            }
            freq[ch - 'a']++;

            // Try to shrink the window
            while (count == required) {
                minLen = Math.min(minLen, right - left + 1);

                char leftChar = str.charAt(left);
                freq[leftChar - 'a']--;

                if (freq[leftChar - 'a'] == 0) {
                    count--;
                }
                left++;
            }
        }

        return minLen;
    }
}
