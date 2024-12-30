class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*
        int[] ans = new int[]{-1,-1};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            int partner = target - numbers[i];
            if(map.containsKey(numbers[i])){
                ans[0] = map.get(numbers[i])+1;
                ans[1] = i+1;
                return ans;
            }
            map.put(partner, i);
        }
        return ans;
        */

        int st = 0,end = numbers.length-1;
        while(true){
            int sum = numbers[st] + numbers[end];
            if(sum == target){
                return new int[]{st+1,end+1};
            }
            else if(sum > target){
                end--;
            }
            else{
                st++;
            }
        }
    }
}