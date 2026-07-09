class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int currl = 0;
        int maxl = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                currl = 1;
                while(set.contains(num+1)){
                    currl++;
                    num++;
                }
                maxl = Math.max(maxl, currl);
            }
        }
        return Math.max(maxl, currl);
    }
}