class Solution {
    public int smallestSubstring(String s) {
        int n = s.length();
        int[] count = new int[3]; // for '0', '1', '2'
        
        int left = 0, distinct = 0;
        int minLen = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            int r = s.charAt(right) - '0';
            
            if (count[r] == 0) {
                distinct++;
            }
            count[r]++;
            
            // Try shrinking window
            while (distinct == 3) {
                minLen = Math.min(minLen, right - left + 1);
                
                int l = s.charAt(left) - '0';
                count[l]--;
                
                if (count[l] == 0) {
                    distinct--;
                }
                left++;
            }
        }
        
        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }
}
