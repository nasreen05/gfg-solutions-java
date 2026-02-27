class GfG {
    public int remAnagrams(String s1, String s2) {
        
        int[] freq = new int[26];
        
        // Count characters of s1
        for(char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        // Subtract characters of s2
        for(char ch : s2.toCharArray()) {
            freq[ch - 'a']--;
        }
        
        int deletions = 0;
        
        // Sum absolute differences
        for(int i = 0; i < 26; i++) {
            deletions += Math.abs(freq[i]);
        }
        
        return deletions;
    }
}
