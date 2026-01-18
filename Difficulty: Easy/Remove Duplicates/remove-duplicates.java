class Solution {
    String removeDups(String s) {
        boolean[] seen = new boolean[26];
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (!seen[ch - 'a']) {
                seen[ch - 'a'] = true;
                result.append(ch);
            }
        }
        return result.toString();
    }
}
