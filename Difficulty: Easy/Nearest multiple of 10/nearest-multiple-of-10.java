class Solution {

    String roundToNearest(String s) {

        int n = s.length();
        char lastDigit = s.charAt(n - 1);

        // If last digit is less than or equal to 5 → round down
        if (lastDigit <= '5') {
            return s.substring(0, n - 1) + "0";
        }
        else {
            // Round up
            StringBuilder sb = new StringBuilder(s.substring(0, n - 1));

            int i = sb.length() - 1;

            // Handle carry
            while (i >= 0 && sb.charAt(i) == '9') {
                sb.setCharAt(i, '0');
                i--;
            }

            if (i >= 0) {
                sb.setCharAt(i, (char)(sb.charAt(i) + 1));
            } else {
                sb.insert(0, '1');
            }

            sb.append('0');
            return sb.toString();
        }
    }
}
