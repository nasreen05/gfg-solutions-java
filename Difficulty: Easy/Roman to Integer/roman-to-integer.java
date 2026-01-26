class Solution {
    public int romanToDecimal(String s) {
        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int curr = value(s.charAt(i));

            // If next symbol exists and is greater, subtract
            if (i + 1 < n && curr < value(s.charAt(i + 1))) {
                result -= curr;
            } else {
                result += curr;
            }
        }

        return result;
    }

    private int value(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
