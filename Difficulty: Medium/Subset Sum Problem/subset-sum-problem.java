class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : arr) {
            for (int s = sum; s >= num; s--) {
                dp[s] = dp[s] || dp[s - num];
            }
        }
        return dp[sum];
    }
}
