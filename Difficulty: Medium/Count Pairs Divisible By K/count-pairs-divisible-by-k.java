class Solution {
    public int countKdivPairs(int[] arr, int k) {
        long count = 0;
        int[] freq = new int[k];

        for (int num : arr) {
            int rem = num % k;
            int need = (k - rem) % k;

            count += freq[need];
            freq[rem]++;
        }

        return (int) count;
    }
}