class Solution {
    public boolean isPossible(int[] arr, int s, int x) {

        if (x == 0) {
            return true;
        }

        long sum = s;
        java.util.ArrayList<Long> seq = new java.util.ArrayList<>();

        // s itself is written on the paper initially
        if (s <= x) {
            seq.add((long) s);
        }

        for (int a : arr) {
            long next = sum + a;

            // If next is greater than x, it can never be used.
            // Future values will be even larger.
            if (next > x) {
                break;
            }

            seq.add(next);

            // Update sum of all numbers on paper
            sum += next;
        }

        // Greedy subset sum from largest to smallest
        long target = x;

        for (int i = seq.size() - 1; i >= 0; i--) {
            if (seq.get(i) <= target) {
                target -= seq.get(i);
            }

            if (target == 0) {
                return true;
            }
        }

        return false;
    }
}