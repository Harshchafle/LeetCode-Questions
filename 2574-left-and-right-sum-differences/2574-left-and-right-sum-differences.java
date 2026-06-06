class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        leftSum[0] = nums[0];
        for(int i = 1; i < n; i++){
            leftSum[i] = leftSum[i-1] + nums[i];
        }

        int[] rightSum = new int[n];
        rightSum[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            rightSum[i] = rightSum[i+1] + nums[i];
        }
        // System.out.println(Arrays.toString(leftSum));
        // System.out.println(Arrays.toString(rightSum));

        for(int i = 0; i < n; i++) 
            nums[i] = Math.abs(leftSum[i] - rightSum[i]);
        return nums;
    }
}