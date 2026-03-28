class Solution {
    static String largestNumber(int n, int sum) {

        if (sum > 9 * n) {
            return "-1";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {

            if (sum >= 9) {
                result.append(9);
                sum -= 9;
            } 
            else {
                result.append(sum);
                sum = 0;
            }
        }

        return result.toString();
    }
}
