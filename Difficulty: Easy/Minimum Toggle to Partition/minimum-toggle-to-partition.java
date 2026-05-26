class Solution {
    int minToggle(int[] arr) {
        int n = arr.length;

        // Count total zeros in array
        int totalZero = 0;
        for (int num : arr) {
            if (num == 0) {
                totalZero++;
            }
        }

        int leftOne = 0;     // 1s on left side
        int rightZero = totalZero; // 0s on right side

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {

            // toggles needed:
            // left side should be all 0s -> convert left 1s
            // right side should be all 1s -> convert right 0s
            ans = Math.min(ans, leftOne + rightZero);

            if (i < n) {
                if (arr[i] == 1) {
                    leftOne++;
                } else {
                    rightZero--;
                }
            }
        }

        return ans;
    }
}