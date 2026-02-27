class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        
        // Condition 1: Length must be same
        if(s1.length() != s2.length())
            return false;
        
        int[] freq = new int[26];
        
        // Count frequency of s1
        for(char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        // Subtract frequency of s2
        for(char ch : s2.toCharArray()) {
            freq[ch - 'a']--;
        }
        
        int changes = 0;
        
        // Count extra characters in s1
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0)
                changes += freq[i];
        }
        
        return changes <= k;
    }
}
