// User function Template for Java
import java.util.*;

class Solution {
    
    public static String betterString(String s1, String s2) {
        long count1 = countDistinct(s1);
        long count2 = countDistinct(s2);
        
        if (count1 >= count2)
            return s1;
        else
            return s2;
    }
    
    private static long countDistinct(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;   // empty subsequence
        
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);
            
            dp[i] = 2 * dp[i - 1];
            
            if (lastIndex.containsKey(ch)) {
                int prevIndex = lastIndex.get(ch);
                dp[i] -= dp[prevIndex - 1];
            }
            
            lastIndex.put(ch, i);
        }
        
        return dp[n];
    }
}
