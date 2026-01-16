class Solution {

    int maxIndexDiff(int arr[]) {
        int n = arr.length;
        if (n == 0) return 0;   // safety check

        int[] LMin = new int[n];
        int[] RMax = new int[n];

        // Build LMin[] -> minimum from left
        LMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            LMin[i] = Math.min(LMin[i - 1], arr[i]);
        }

        // Build RMax[] -> maximum from right
        RMax[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            RMax[j] = Math.max(RMax[j + 1], arr[j]);
        }

        // Two-pointer traversal
        int i = 0, j = 0, maxDiff = 0;

        while (i < n && j < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDiff;
    }
}
