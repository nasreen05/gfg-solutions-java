class Solution {
    public int minCandy(int arr[]) {
        int n = arr.length;
        int[] candies = new int[n];

        // Step 1: Everyone gets at least 1 candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Step 2: Left to Right pass
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Step 3: Right to Left pass
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Step 4: Sum all candies
        int total = 0;
        for (int c : candies) {
            total += c;
        }

        return total;
    }
}
