class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = nums1[0];
        boolean odd = false;
        for(int n : nums1) {
            min = Math.min(min, n);
            if((n&1) == 1) odd = true;
        }
        return ((min&1) == 0 && odd)? false:true;
    }
}