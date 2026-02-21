import java.util.*;

class Solution {
    public ArrayList<Integer> rabinKarp(String text, String pattern) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int n = text.length();
        int m = pattern.length();
        
        if (m > n) return result;
        
        int base = 256;        // number of possible characters
        int mod = 1000000007;  // large prime to avoid overflow
        
        long patternHash = 0;
        long textHash = 0;
        long power = 1;   // base^(m-1)
        
        // Calculate base^(m-1)
        for (int i = 0; i < m - 1; i++) {
            power = (power * base) % mod;
        }
        
        // Initial hash for pattern and first window of text
        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * base + pattern.charAt(i)) % mod;
            textHash = (textHash * base + text.charAt(i)) % mod;
        }
        
        // Slide window over text
        for (int i = 0; i <= n - m; i++) {
            
            // If hash matches, verify characters
            if (patternHash == textHash) {
                if (text.substring(i, i + m).equals(pattern)) {
                    result.add(i);
                }
            }
            
            // Calculate next window hash
            if (i < n - m) {
                textHash = (textHash - text.charAt(i) * power % mod + mod) % mod;
                textHash = (textHash * base + text.charAt(i + m)) % mod;
            }
        }
        
        return result;
    }
}
