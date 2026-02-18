class Solution {
    public String removeConsecutiveCharacter(String s) {
        
        if (s == null || s.length() == 0)
            return s;
        
        StringBuilder result = new StringBuilder();
        
        // Add first character
        result.append(s.charAt(0));
        
        // Traverse from second character
        for (int i = 1; i < s.length(); i++) {
            
            if (s.charAt(i) != s.charAt(i - 1)) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}
