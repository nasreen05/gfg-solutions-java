class Solution {
    String firstRepChar(String s) {
        
        boolean[] visited = new boolean[26];
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (visited[ch - 'a']) {
                return String.valueOf(ch);
            }
            
            visited[ch - 'a'] = true;
        }
        
        return "-1";
    }
}
