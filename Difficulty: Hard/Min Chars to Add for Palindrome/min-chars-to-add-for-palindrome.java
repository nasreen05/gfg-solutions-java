class Solution {
    public int minChar(String s) {
        
        String rev = new StringBuilder(s).reverse().toString();
        String temp = s + "$" + rev;
        
        int[] lps = new int[temp.length()];
        
        // Build LPS array
        for (int i = 1; i < temp.length(); i++) {
            int len = lps[i - 1];
            
            while (len > 0 && temp.charAt(i) != temp.charAt(len)) {
                len = lps[len - 1];
            }
            
            if (temp.charAt(i) == temp.charAt(len)) {
                len++;
            }
            
            lps[i] = len;
        }
        
        return s.length() - lps[temp.length() - 1];
    }
}
