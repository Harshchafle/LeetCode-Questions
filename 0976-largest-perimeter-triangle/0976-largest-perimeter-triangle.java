class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < n-2; i++) {
            if(nums[i]+nums[i+1] > nums[i+2]){
                ans = nums[i]+nums[i+1]+nums[i+2];
            }
        }
        return ans;
    }
}