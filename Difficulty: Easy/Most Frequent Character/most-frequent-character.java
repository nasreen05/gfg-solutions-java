class Solution {
    public char getMaxOccuringChar(String s) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int maxFreq = -1;
        char result = 'a';

        // Find max occurring character
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                result = (char) (i + 'a');
            }
        }

        return result;
    }
}
