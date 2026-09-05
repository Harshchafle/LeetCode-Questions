class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;

        int[] maxarr = new int[n];
        int minarr[] = new int[n];

        maxarr[0] = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] < maxarr[i-1]) maxarr[i] = maxarr[i-1];
            else maxarr[i] = nums[i];
        }

        minarr[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            if(nums[i] < minarr[i+1]) minarr[i] = nums[i];
            else minarr[i] = minarr[i+1];
        }

        for(int i = 0; i < n; i++){
            int score = maxarr[i] - minarr[i];
            if(score <= k) return i;
        }
        return -1;
    }
}