class Solution {
    public int coin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Continue until only one coin remains
        while (left < right) {

            // Greedily remove the larger end coin
            if (arr[left] >= arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        // Last remaining coin
        return arr[left];
    }
}