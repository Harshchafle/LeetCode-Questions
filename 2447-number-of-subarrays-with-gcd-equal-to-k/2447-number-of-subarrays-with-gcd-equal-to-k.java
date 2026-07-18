class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        int st = 0;
        int prev = nums[0];
        while(st < n) {
            for(int end = st; end < n; end++) {
                if(nums[end] < k) break;
                if(st == end) {
                    if(nums[st] == k) {
                        count++;
                        prev = k;
                    }
                    else if(nums[st] > k) {
                        prev = nums[st];
                    }
                }
                else {
                    if(nums[end] % k != 0) break;
                    int gcd = GCD(prev, nums[end]);
                    if(gcd == k){
                        count++;
                    }
                    prev = gcd;
                    // else break;
                }
            }
            st++;
        }
        return count;
    }

    public int GCD(int x, int y) {
        while(y != 0) {
            int temp = y;
            y = x % temp;
            x = temp;
        }
        return x;
    }
}