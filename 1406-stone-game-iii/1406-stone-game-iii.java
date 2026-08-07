class Solution {
    int MIN = -(int)1e7;
    public String stoneGameIII(int[] nums) {
        int n = nums.length;

        // int dp[][] = new int[n][3];
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], MIN);
        // }
        // int score = helper(0, 0, dp, nums);

        int dp[] = new int[n+1];
        for(int i = n-1; i >= 0; i--) {
            int best = Integer.MIN_VALUE;
            int currSum = 0;
            for(int k = 1; k <= 3; k++) {
                if(i+k > n) break;
                currSum += nums[i+k-1];
                best = Math.max(best, currSum-dp[i+k]);
            }
            dp[i] = best;
        }
        
        return (dp[0] > 0)? "Alice" : (dp[0] < 0)? "Bob" : "Tie";
    }

    public int helper(int i, int j, int[][] dp, int[] nums) {
        int n = nums.length;
        if(i >= n) return 0;
        if(dp[i][j] != MIN) return dp[i][j];   

        int ans = 0;


        return 0;
    }
}