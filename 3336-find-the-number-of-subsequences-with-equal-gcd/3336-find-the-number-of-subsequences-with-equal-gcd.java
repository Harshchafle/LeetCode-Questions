class Solution {
    int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        Integer[][][] memo = new Integer[n][201][201];
        return helper(0, nums, 0, 0, memo)-1;
    }

    public int helper(int i, int[] nums, int g1, int g2, Integer[][][] memo){
        if(i == nums.length){
            if(g1 == g2) return 1;
            return 0;
        }
        if(memo[i][g1][g2] != null) return memo[i][g1][g2];
        int a = helper(i+1, nums, GCD(g1, nums[i]), g2, memo);
        int b = helper(i+1, nums, g1, GCD(g2, nums[i]), memo);
        int c = helper(i+1, nums, g1, g2, memo);
        return memo[i][g1][g2] = ((a+b)%MOD+c)%MOD;
    }

    public void generateSubSeq(int i, int[] nums, int n, List<Integer> list, List<List<Integer>> subSeq) {
        if(i >= n) {
            if(list.size() > 0 && list.size() != n)
                subSeq.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        generateSubSeq(i+1, nums, n, list, subSeq);
        list.remove(list.size()-1);
        generateSubSeq(i+1, nums, n, list, subSeq);
    }

    public int GCD(int x, int y) {
        while(y != 0){
            int temp = y;
            y = x % temp;
            x = temp;
        }
        return x;
    }
}