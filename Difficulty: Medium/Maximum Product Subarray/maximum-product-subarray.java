class Solution {
    int maxProduct(int[] arr) {
        int n = arr.length;

        int maxEndingHere = arr[0];
        int minEndingHere = arr[0];
        int result = arr[0];

        for (int i = 1; i < n; i++) {
            int curr = arr[i];

            int tempMax = Math.max(curr,
                           Math.max(curr * maxEndingHere, curr * minEndingHere));
            int tempMin = Math.min(curr,
                           Math.min(curr * maxEndingHere, curr * minEndingHere));

            maxEndingHere = tempMax;
            minEndingHere = tempMin;

            result = Math.max(result, maxEndingHere);
        }

        return result;
    }
}
