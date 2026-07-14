class Solution {
    public int maxProfit(int[] nums) {
        // 3D-DP(currentDate, HoldingStock, TransactionLeft)
        int n = nums.length;
        Integer[][][] memo = new Integer[n][2][3];
        return helper(0, nums, 0, 2, memo); 
    }

    public int helper(int i, int[] nums, int hold, int txLeft, Integer[][][] memo){
        if(i == nums.length || txLeft == 0){
            return 0;
        }

        if(memo[i][hold][txLeft] != null) return memo[i][hold][txLeft];

        int profit = 0;
        if(hold == 1){
            int p1 = nums[i] + helper(i+1, nums, 0, txLeft-1, memo);
            int p2 = helper(i+1, nums, 1, txLeft, memo);
            profit = Math.max(p1, p2);
        }
        else {
            int p1 = helper(i+1, nums, 1, txLeft, memo) - nums[i];
            int p2 = helper(i+1, nums, 0, txLeft, memo);
            profit = Math.max(p1, p2);
        }

        return memo[i][hold][txLeft] = profit;
    }
}