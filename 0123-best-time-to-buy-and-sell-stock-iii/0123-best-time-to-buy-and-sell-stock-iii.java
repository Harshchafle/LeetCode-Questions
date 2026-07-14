class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        
        int maxProfit = 0;
        int prevBuy = (int)1e9;

        int leftToRight[] = new int[n];
        for(int i = 0; i < n; i++){
            maxProfit = Math.max(maxProfit, nums[i] - prevBuy);
            if(nums[i] < prevBuy){
                prevBuy = nums[i];
            }
            leftToRight[i] = maxProfit;
        }

        maxProfit = 0;
        prevBuy = -(int)1e9;
        int rightToLeft[] = new int[n];
        for(int i = n-1; i >= 0; i--){
            maxProfit = Math.max(maxProfit, prevBuy - nums[i]);
            if(nums[i] > prevBuy){
                prevBuy = nums[i];
            }
            rightToLeft[i] = maxProfit;
        }

        // System.out.println(Arrays.toString(leftToRight));
        // System.out.println(Arrays.toString(rightToLeft));

        maxProfit = 0;
        for(int i = 0; i < n; i++){
            maxProfit = Math.max(leftToRight[i]+rightToLeft[i], maxProfit);
        }
        return maxProfit;
    }
}