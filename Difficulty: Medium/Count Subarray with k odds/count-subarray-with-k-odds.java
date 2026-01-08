import java.util.HashMap;

class Solution {
    public int countSubarrays(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case

        int prefixSum = 0;
        int count = 0;

        for (int num : arr) {

            // Convert to binary (odd = 1, even = 0)
            if (num % 2 != 0) {
                prefixSum++;
            }

            // Check if (prefixSum - k) exists
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Store current prefixSum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
