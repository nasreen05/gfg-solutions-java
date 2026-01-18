class Solution {
    public static String smallestWindow(String s, String p) {
        if (p.length() > s.length()) return "";

        int[] freq = new int[26];

        // Step 1: Store frequency of characters in p
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0, right = 0;
        int required = p.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Step 2: Sliding window
        while (right < s.length()) {
            char rChar = s.charAt(right);

            if (freq[rChar - 'a'] > 0) {
                required--;
            }
            freq[rChar - 'a']--;
            right++;

            // Step 3: Try to shrink window
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lChar = s.charAt(left);
                freq[lChar - 'a']++;

                if (freq[lChar - 'a'] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
