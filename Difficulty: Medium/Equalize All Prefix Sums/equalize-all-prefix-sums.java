class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;

        long[] pre = new long[n];
        pre[0] = arr[0];

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int mid = i / 2;
            long median = arr[mid];

            long leftCost = median * (mid + 1L) - pre[mid];

            long rightCost =
                    (pre[i] - pre[mid]) - median * (i - mid);

            ans.add((int)(leftCost + rightCost));
        }

        return ans;
    }
}