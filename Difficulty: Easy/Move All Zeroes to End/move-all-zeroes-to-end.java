class Solution {
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int nonZeroIndex = 0;

        // Move non-zero elements forward
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[nonZeroIndex++] = arr[i];
            }
        }

        // Fill remaining positions with 0
        while (nonZeroIndex < n) {
            arr[nonZeroIndex++] = 0;
        }
    }
}
