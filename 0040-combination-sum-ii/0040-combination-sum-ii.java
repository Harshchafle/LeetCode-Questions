class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, target, nums, list, ans);
        return ans;
    }

    public void helper(
        int idx, 
        int t, 
        int[] nums, 
        List<Integer> list, 
        List<List<Integer>> ans
    ) {
        // System.out.println(i+" "+t+" "+list);
        int n = nums.length;
        
        if(t == 0) {
            if(!ans.contains(list)){
                ans.add(new ArrayList(list));
            }
        }

        for(int i = idx; i < n; i++) {
            if((i == idx || nums[i] != nums[i-1]) && nums[i] <= t){
                list.add(nums[i]);
                helper(i+1, t-nums[i], nums, list, ans);
                list.remove(list.size()-1);
            }
        }
    }
}