class Solution {
    public int substrCount(String s, int k) {
        
        int n = s.length();
        
        if(k > n)
            return 0;
        
        int[] freq = new int[26];
        int distinct = 0;
        int count = 0;
        
        // First window
        for(int i = 0; i < k; i++) {
            if(freq[s.charAt(i) - 'a'] == 0)
                distinct++;
                
            freq[s.charAt(i) - 'a']++;
        }
        
        if(distinct == k - 1)
            count++;
        
        
        // Sliding window
        for(int i = k; i < n; i++) {
            
            // Remove left char
            freq[s.charAt(i - k) - 'a']--;
            
            if(freq[s.charAt(i - k) - 'a'] == 0)
                distinct--;
            
            
            // Add right char
            if(freq[s.charAt(i) - 'a'] == 0)
                distinct++;
                
            freq[s.charAt(i) - 'a']++;
            
            
            // Check condition
            if(distinct == k - 1)
                count++;
        }
        
        return count;
    }
}
