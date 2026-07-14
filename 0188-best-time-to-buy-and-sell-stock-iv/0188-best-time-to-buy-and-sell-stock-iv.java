class Solution {
    public int maxProfit(int k, int[] nums) {
        // 3D-DP(currentDate, Holding, TxLeft)
        Integer memo[][][] = new Integer[nums.length][2][k+1];
        return helper(0, nums, 0, k, memo);
    }

    public int helper(int i, int[] nums, int hold, int txLeft, Integer[][][] memo){
        // Base : i reach to last or No transaction left
        if(i == nums.length || txLeft == 0) return 0;

        // if calculated then return direct
        if(memo[i][hold][txLeft] != null) return memo[i][hold][txLeft];

        // track maximum profit
        int profit = 0;

        if(hold == 1){
            // Option 1 : sell stock (add nums[i] to profit, set hold = 0, txLeft--)
            int p1 = nums[i] + helper(i+1, nums, 0, txLeft-1, memo);
            
            // Option 2 : Eat 5-star (Do Nothing)
            int p2 = helper(i+1, nums, 1, txLeft, memo);

            // take maximum profit
            profit = Math.max(p1, p2);
        }
        else {
            // Option 1 : Buy a stock (subtract nums[i] from profit, set hold = 1, txLeft)
            int p1 = helper(i+1, nums, 1, txLeft, memo) - nums[i];

            // Option 2 : Again Eat 5-star (Do Nothing)
            int p2 = helper(i+1, nums, 0, txLeft, memo);

            // take maximum profit
            profit = Math.max(p1, p2);
        }

        return memo[i][hold][txLeft] = profit;
    }
}