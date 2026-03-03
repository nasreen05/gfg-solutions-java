import java.util.*;

class Solution {
    public int totalElements(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {
            // Add current element
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            // If more than 2 distinct elements, shrink window
            while (map.size() > 2) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }

            // Update maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
