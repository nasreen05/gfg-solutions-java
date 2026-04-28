class Solution {
    public int longestSubstr(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxFreq = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Update frequency
            freq[s.charAt(right) - 'A']++;
            
            // Track max frequency in current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            
            // If replacements needed exceed k, shrink window
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            
            // Update answer
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
