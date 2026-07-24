class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        // here max(nums[i] = 1500) so power of two lies in range 2048
        int MAX = 2048;
        int[] xorPair = new int[MAX];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                xorPair[nums[i]^nums[j]] = 1;;
            }
        }

        int[] xorTriplet = new int[MAX];
        for(int i = 0; i < MAX; i++) {
            if(xorPair[i] > 0)
                for(int j = 0; j < n; j++) {
                    xorTriplet[i^nums[j]]++;
                }
        }

        int count = 0;
        for(int i = 0; i < MAX; i++) count += (xorTriplet[i] > 0)? 1 : 0;
        return count;

    }
}