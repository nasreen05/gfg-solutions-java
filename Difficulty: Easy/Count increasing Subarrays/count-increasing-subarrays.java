class Solution {
    public int countIncreasing(int[] arr) {
        int count = 0;
        int len = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;
                count += len;
            } else {
                len = 0;
            }
        }

        return count;
    }
}
