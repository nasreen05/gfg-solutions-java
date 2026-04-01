class Solution {
    public char nthCharacter(String s, int r, int n) {
        
        for(int i = 0; i < r; i++) {
            
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < s.length(); j++) {
                
                if(s.charAt(j) == '0') {
                    sb.append("01");
                } else {
                    sb.append("10");
                }
                
                // Stop early if already enough length
                if(sb.length() > n) break;
            }
            
            s = sb.toString();
        }
        
        return s.charAt(n);
    }
}
