class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        // checking if all elems are same and zero
        boolean zero = (nums[0] == 0);

        int ans = 0;
        for(int num : nums) {
            ans ^= num;
            if(num != 0) zero = false;
        }
        if(ans != 0) return n;
        else return (zero)? 0 : n-1;
    }
}