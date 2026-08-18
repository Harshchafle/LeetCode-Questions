class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        if(k == 1) {
            int max = -1;
            for(int i = 0; i < n; i++) 
                if(nums[i] > max && map.get(nums[i]) == 1) 
                    max = nums[i];
            return max;
        }
        else if(k == n) {
            int max = -1;
            for(int i = 0; i < n; i++) 
                if(nums[i] > max) 
                    max = nums[i];
            return max;
        }

        int st = nums[0];
        int end = nums[n-1];
        if(st == end) return -1;
        else if(st > end) {
            if(map.get(st) == 1) return st;
            else if(map.get(end) == 1) return end;
        }
        else if(end > st) {
            if(map.get(end) == 1) return end;
            else if(map.get(st) == 1) return st;
        }
        return -1;
    }
}