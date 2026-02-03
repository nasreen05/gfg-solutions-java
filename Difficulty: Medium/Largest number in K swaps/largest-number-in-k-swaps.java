
class Solution {
    String max;

    // Function to find the largest number after k swaps.
    public String findMaximumNum(String s, int k) {
        max = s;
        char[] arr = s.toCharArray();
        solve(arr, k, 0);
        return max;
    }

    private void solve(char[] arr, int k, int idx) {
        if (k == 0 || idx == arr.length) {
            return;
        }

        // Find maximum digit in suffix
        char maxDigit = arr[idx];
        for (int i = idx + 1; i < arr.length; i++) {
            if (arr[i] > maxDigit) {
                maxDigit = arr[i];
            }
        }

        // If we are going to swap, decrease k
        if (maxDigit != arr[idx]) {
            k--;
        }

        // Try swapping with all positions having maxDigit
        for (int i = arr.length - 1; i >= idx; i--) {
            if (arr[i] == maxDigit) {
                swap(arr, idx, i);

                String current = new String(arr);
                if (current.compareTo(max) > 0) {
                    max = current;
                }

                solve(arr, k, idx + 1);

                // Backtrack
                swap(arr, idx, i);
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
