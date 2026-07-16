class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;

        // calculating max from 0 upto i
        int mx[] = new int[n];
        int max = -(int)1e9;
        for(int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            mx[i] = max;
        }

        // System.out.println(Arrays.toString(mx));
        int prefGcd[] = new int[n];
        for(int i = 0; i < n; i++) {
            prefGcd[i] = GCD(nums[i], mx[i]);
        }

        Arrays.sort(prefGcd);
        // System.out.println(Arrays.toString(prefGcd));

        int st = 0, end = n-1;
        long sum = 0;
        while(st < end) {
            sum += GCD(prefGcd[st], prefGcd[end]);
            st++;
            end--;
        }
        // System.out.println(GCD(6, 18));

        return sum;
    }

    public int GCD(int x, int y) {
        // if(y == 0) return x;
        // return GCD(y, x % y);
        while(y != 0) {
            int temp = y;
            y = x % temp;
            x = temp;
        }
        return x;
    }
}