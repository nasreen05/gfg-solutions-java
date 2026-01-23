class Solution {
    public int longestUniqueSubstr(String s) {
        int n = s.length();
        int left = 0, right = 0;
        int maxLen = 0;

        java.util.HashSet<Character> set = new java.util.HashSet<>();

        while (right < n) {
            char ch = s.charAt(right);

            // If character already exists, remove from left
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
