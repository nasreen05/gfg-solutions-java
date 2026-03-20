class Solution {
    static String removeChars(String str1, String str2) {
        
        // Step 1: mark characters of str2
        boolean[] remove = new boolean[26];
        
        for (char ch : str2.toCharArray()) {
            remove[ch - 'a'] = true;
        }
        
        // Step 2: build result
        StringBuilder result = new StringBuilder();
        
        for (char ch : str1.toCharArray()) {
            if (!remove[ch - 'a']) {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}
