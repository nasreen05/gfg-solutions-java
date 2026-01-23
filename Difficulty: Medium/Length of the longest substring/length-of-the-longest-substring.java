class Solution {
    int longestUniqueSubstring(String s) {
        int[] last = new int[26]; // last occurrence
        for (int i = 0; i < 26; i++) last[i] = -1;

        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'a';

            // If character seen inside window
            if (last[idx] >= left) {
                left = last[idx] + 1;
            }

            last[idx] = right;
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
