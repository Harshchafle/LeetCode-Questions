class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int key = nums[i];
            if(map.containsKey(key)){
                map.get(key).add(i);
            }
            else {
                List<Integer> list = new ArrayList<>();
                map.put(key, list);
                map.get(key).add(i);
            }
        }

        int ans = Integer.MAX_VALUE;
        for(List<Integer> list : map.values()){
            if(list.size() >= 3){
                for(int i = 0; i < list.size()-2; i++){
                    ans = Math.min(
                        ans, 
                        Math.abs(list.get(i) - list.get(i+1))+
                        Math.abs(list.get(i+1) - list.get(i+2))+
                        Math.abs(list.get(i) - list.get(i+2))
                    );
                }
                
            }
        }
        return (ans != Integer.MAX_VALUE)? ans : -1;
    }
}