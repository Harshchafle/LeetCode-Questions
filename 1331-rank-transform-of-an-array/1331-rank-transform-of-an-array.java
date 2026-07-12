class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = arr[i];
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int i = 0; i < n; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], rank++);
        }
        for(int i = 0; i < n; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}