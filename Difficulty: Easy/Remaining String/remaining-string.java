class Solution {
    public String printString(String s, char ch, int count) {
        
        int occurrence = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            if (s.charAt(i) == ch) {
                occurrence++;
                
                if (occurrence == count) {
                    
                    if (i == s.length() - 1) {
                        return "";
                    }
                    
                    return s.substring(i + 1);
                }
            }
        }
        
        return "";
    }
}
