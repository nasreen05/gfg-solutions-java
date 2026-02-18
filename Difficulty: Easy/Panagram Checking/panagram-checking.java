class Solution {
    public static boolean checkPangram(String s) {
        
        boolean[] present = new boolean[26];
        int count = 0;
        
        s = s.toLowerCase();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch >= 'a' && ch <= 'z') {
                int index = ch - 'a';
                
                if (!present[index]) {
                    present[index] = true;
                    count++;
                }
            }
        }
        
        return count == 26;
    }
}
