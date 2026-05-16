import java.util.Arrays;

class Solution {
    public int findSmallest(int[] arr) {
        Arrays.sort(arr);

        long res = 1;

        for (int num : arr) {
            // If current number is greater than res,
            // then res cannot be formed
            if (num > res) {
                break;
            }

            // Extend the range of possible sums
            res += num;
        }

        return (int) res;
    }
}