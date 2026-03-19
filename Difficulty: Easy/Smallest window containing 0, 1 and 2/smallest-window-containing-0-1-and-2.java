class Solution {
    public int smallestSubstring(String S) {
        
        int n = S.length();
        int[] count = new int[3]; // for '0','1','2'
        
        int left = 0, minLen = Integer.MAX_VALUE;
        int unique = 0; // count of distinct chars in window
        
        for (int right = 0; right < n; right++) {
            
            int idx = S.charAt(right) - '0';
            
            // If this char appears first time
            if (count[idx] == 0) unique++;
            
            count[idx]++;
            
            // When we have all 3 characters
            while (unique == 3) {
                
                minLen = Math.min(minLen, right - left + 1);
                
                int leftIdx = S.charAt(left) - '0';
                count[leftIdx]--;
                
                // If one character count becomes 0
                if (count[leftIdx] == 0) {
                    unique--;
                }
                
                left++;
            }
        }
        
        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }
}
