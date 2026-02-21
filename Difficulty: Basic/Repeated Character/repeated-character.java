class Solution {
    char firstRep(String S) {
        int[] freq = new int[26];   // since only lowercase letters
        
        // Count frequency of each character
        for(int i = 0; i < S.length(); i++) {
            freq[S.charAt(i) - 'a']++;
        }
        
        // Find first character with frequency > 1
        for(int i = 0; i < S.length(); i++) {
            if(freq[S.charAt(i) - 'a'] > 1) {
                return S.charAt(i);
            }
        }
        
        // If no repeating character
        return '#';
    }
}
