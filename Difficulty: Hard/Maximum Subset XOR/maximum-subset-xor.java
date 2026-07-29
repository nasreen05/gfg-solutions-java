class Solution {
    public int maxSubsetXOR(int[] arr) {
        int n = arr.length;
        int index = 0;

        // Traverse from highest bit to lowest bit
        for (int bit = 31; bit >= 0; bit--) {

            int maxIndex = -1;
            int maxEle = Integer.MIN_VALUE;

            // Find element with current bit set
            for (int i = index; i < n; i++) {
                if (((arr[i] >> bit) & 1) == 1 && arr[i] > maxEle) {
                    maxEle = arr[i];
                    maxIndex = i;
                }
            }

            // No element with current bit set
            if (maxIndex == -1)
                continue;

            // Swap
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;

            // Eliminate current bit from all other elements
            for (int i = 0; i < n; i++) {
                if (i != index && ((arr[i] >> bit) & 1) == 1) {
                    arr[i] ^= arr[index];
                }
            }

            index++;
        }

        // Compute maximum XOR
        int result = 0;
        for (int x : arr) {
            result = Math.max(result, result ^ x);
        }

        return result;
    }
}