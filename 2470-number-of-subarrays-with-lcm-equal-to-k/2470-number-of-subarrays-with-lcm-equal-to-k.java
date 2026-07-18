class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            long l = nums[i];
            if(l == k) count++;
            for(int j = i+1; j < n; j++) {
                // System.out.print(l+" "+nums[j]+" : ");
                l = LCM(l, nums[j]);
                if(l > k) break;
                // System.out.println(l);
                if(l == k) count++;
            }
        }
        return count;
    }

    public long LCM(long x, long y) {
        long a = x, b = y;
        while(y != 0) {
            long temp = y;
            y = x %  temp;
            x = temp;
        }
        return a*b/x;
    }
}