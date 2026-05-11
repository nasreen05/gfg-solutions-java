class Solution {
    public boolean palindromePair(String[] arr) {
        if (arr.length < 2) return false;
        
        // Map from reversed string to original index
        java.util.Map<String, Integer> revMap = new java.util.HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            String reversed = new StringBuilder(arr[i]).reverse().toString();
            revMap.put(reversed, i);
        }
        
        // Check for empty string case
        if (revMap.containsKey("") && revMap.get("") != 0) {
            if (isPalindrome(arr[0])) return true;
        }
        
        // For each word, check all possible splits
        for (int i = 0; i < arr.length; ++i) {
            String word = arr[i];
            for (int j = 1; j <= word.length(); ++j) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                
                // Case 1: left is pal, right's reverse exists
                if (isPalindrome(left) && revMap.containsKey(right) && revMap.get(right) != i) {
                    return true;
                }
                
                // Case 2: right is pal, left's reverse exists
                if (isPalindrome(right) && revMap.containsKey(left) && revMap.get(left) != i) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}