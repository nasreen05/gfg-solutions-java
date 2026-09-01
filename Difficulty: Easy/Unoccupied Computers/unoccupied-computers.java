class Solution {
    public int solve(int n, String s) {
        boolean[] using = new boolean[26];
        boolean[] rejected = new boolean[26];

        int occupied = 0;
        int answer = 0;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'A';

            // First occurrence: customer arrives
            if (!using[idx] && !rejected[idx]) {
                if (occupied < n) {
                    using[idx] = true;
                    occupied++;
                } else {
                    rejected[idx] = true;
                    answer++;
                }
            }
            // Second occurrence: customer leaves
            else if (using[idx]) {
                using[idx] = false;
                occupied--;
            }
            else {
                // Customer was rejected, now they are leaving
                rejected[idx] = false;
            }
        }

        return answer;
    }
}