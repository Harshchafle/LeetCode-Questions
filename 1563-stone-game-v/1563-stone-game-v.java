class Solution {
    public int stoneGameV(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int[] pref = new int[n+1];
        for(int i = 0; i < n; i++) {
            pref[i+1] = pref[i]+nums[i];
        }

        int[][] dp = new int[n][n];

        for(int i = n-1; i >= 0; i--) {
            for(int j = i+1; j < n; j++) {
                int ans = 0;
                for(int k = i; k < j; k++) {
                    int leftSum = pref[k+1] - pref[i];
                    int rightSum = pref[j+1] - pref[k+1];

                    if(leftSum >= rightSum) {
                        ans = Math.max(ans, dp[k+1][j] + rightSum);
                    }
                    if(leftSum <= rightSum) {
                        ans = Math.max(ans, dp[i][k] + leftSum);
                    }

                    if(2*Math.min(leftSum, rightSum) <= ans) break;

                }
                dp[i][j] = ans;
            }
        }
        return dp[0][n-1];

    }
}