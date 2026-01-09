import java.util.HashMap;

class Solution {
    public int countAtMostK(int arr[], int k) {
        int left = 0;
        int result = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            // Add current element
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);

            // Shrink window if distinct elements exceed k
            while (freq.size() > k) {
                freq.put(arr[left], freq.get(arr[left]) - 1);
                if (freq.get(arr[left]) == 0) {
                    freq.remove(arr[left]);
                }
                left++;
            }

            // Count subarrays ending at 'right'
            result += (right - left + 1);
        }

        return result;
    }
}
