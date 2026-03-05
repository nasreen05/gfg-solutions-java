class Solution {
    public int longestKSubstr(String s, int k) {
        
        int n = s.length();
        int[] freq = new int[26];
        
        int left = 0;
        int distinctCount = 0;
        int maxLen = -1;
        
        for (int right = 0; right < n; right++) {
            
            // Add current character
            char ch = s.charAt(right);
            if (freq[ch - 'a'] == 0) {
                distinctCount++;
            }
            freq[ch - 'a']++;
            
            // Shrink window if distinct > k
            while (distinctCount > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                
                if (freq[leftChar - 'a'] == 0) {
                    distinctCount--;
                }
                left++;
            }
            
            // If exactly k distinct characters
            if (distinctCount == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen;
    }
}
