// User function Template for Java
class Solution {
    String uncommonChars(String s1, String s2) {
        
        boolean[] present1 = new boolean[26];
        boolean[] present2 = new boolean[26];
        
        // Mark characters of s1
        for (char ch : s1.toCharArray()) {
            present1[ch - 'a'] = true;
        }
        
        // Mark characters of s2
        for (char ch : s2.toCharArray()) {
            present2[ch - 'a'] = true;
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < 26; i++) {
            if (present1[i] ^ present2[i]) {  // XOR: present in only one
                result.append((char)(i + 'a'));
            }
        }
        
        return result.toString();
    }
}
