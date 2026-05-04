class Solution {
    public boolean isBinaryPalindrome(int n) {
        String bin = Integer.toBinaryString(n);
        
        int i = 0, j = bin.length() - 1;
        while (i < j) {
            if (bin.charAt(i) != bin.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}