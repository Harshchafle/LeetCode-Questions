class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        if(n <= 3) return 2;
        
        int minIdx = 0;
        int maxIdx = 0;
        for(int i = 0; i < n; i++) {
            if(nums[minIdx] > nums[i]) minIdx = i;
            if(nums[maxIdx] < nums[i]) maxIdx = i;
        }

        int st_f = 1 + ((minIdx < maxIdx)? minIdx : maxIdx);
        int st_s = 1 + ((minIdx > maxIdx)? minIdx : maxIdx);
        int end_f = n - ((minIdx > maxIdx)? minIdx : maxIdx);
        int end_s = n - ((minIdx < maxIdx)? minIdx : maxIdx);

        // System.out.println(st_f+" "+st_s+" "+end_s+" "+end_f);

        int case1 = (st_f+end_f);   // _,min,_,_,_,max,_
        int case2 = st_s;           // _,min,max,_,_,_,_
        int case3 = end_s;          // _,_,_,_,min,max,_
        
        // System.out.println(case1+" "+case2+" "+case3);
        return Math.min(case1, Math.min(case2, case3));
    }
}