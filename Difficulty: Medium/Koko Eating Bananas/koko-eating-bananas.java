class Solution {
    public int kokoEat(int[] arr, int k) {
        int low = 1;
        int high = 0;

        // Find maximum pile
        for (int pile : arr) {
            high = Math.max(high, pile);
        }

        int answer = high;

        // Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hours = 0;

            // Calculate hours needed at speed mid
            for (int pile : arr) {
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= k) {
                answer = mid;     // possible answer
                high = mid - 1;   // try smaller speed
            } else {
                low = mid + 1;    // need higher speed
            }
        }

        return answer;
    }
}
