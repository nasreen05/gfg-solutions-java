class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {
        int n = seats.length;

        for (int i = 0; i < n && k > 0; i++) {
            if (seats[i] == 0) {
                int left = (i == 0) ? 0 : seats[i - 1];
                int right = (i == n - 1) ? 0 : seats[i + 1];

                if (left == 0 && right == 0) {
                    seats[i] = 1; // seat a person
                    k--;
                }
            }
        }

        return k == 0;
    }
}