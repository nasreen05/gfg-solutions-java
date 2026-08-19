import java.util.*;

class Solution {

    public int countTriplets(int[] arr, int l, int r) {
        Arrays.sort(arr);

        long ans = countLessEqual(arr, r) - countLessEqual(arr, l - 1);

        return (int) ans;
    }

    // Counts triplets whose sum is <= target
    private long countLessEqual(int[] arr, int target) {
        int n = arr.length;
        long count = 0;

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                long sum = (long) arr[i] + arr[left] + arr[right];

                if (sum <= target) {
                    // Every index from left+1 to right
                    // will also form a valid triplet
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}