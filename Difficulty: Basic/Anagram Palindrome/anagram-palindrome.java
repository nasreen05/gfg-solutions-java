class Solution {
    boolean canFormPalindrome(String s) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Count characters with odd frequency
        int oddCount = 0;

        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // Palindrome possible if at most one odd frequency exists
        return oddCount <= 1;
    }
}
