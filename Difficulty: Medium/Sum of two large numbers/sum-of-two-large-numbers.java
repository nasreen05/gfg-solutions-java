class Solution {
    String findSum(String s1, String s2) {

        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += s1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += s2.charAt(j) - '0';
                j--;
            }

            sb.append(sum % 10);
            carry = sum / 10;
        }

        // Reverse result
        sb.reverse();

        // Remove leading zeros
        int idx = 0;
        while (idx < sb.length() - 1 && sb.charAt(idx) == '0') {
            idx++;
        }

        return sb.substring(idx);
    }
}
