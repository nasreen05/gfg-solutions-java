class Solution {
    boolean isBinary(String s) {
        for (char ch : s.toCharArray()) {
            if (ch != '0' && ch != '1') {
                return false;
            }
        }
        return true;
    }
}
