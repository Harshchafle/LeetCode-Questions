class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n = queries.length;

        // let;s find the maximum number present in the array
        int max = Arrays.stream(nums).max().getAsInt();

        // count the freq o feach num in nums
        int[] freq = new int[max+1];
        for(int num : nums) freq[num]++;

        // count of pairs
        long pair[] = new long[max+1];

        // iterate on all gcd from max down to 1
        for(int g = max; g > 0; g--) {
            // to count multiples of gcd
            int count = 0;
            for(int j = g; j <= max; j += g) {
                count += freq[j];
                pair[g] -= pair[j];
            }

            pair[g] += (long)(count)*(count-1)/2;
        }

        // build prefSum
        for(int i = 2; i < max+1; i++) {
            pair[i] += pair[i-1];
        }
        
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = binary(pair, queries[i]);
        }

        return ans;
    }

    public int binary(long[] pair, long t) {
        int st = 0;
        int end = pair.length-1;
        int idx = pair.length;
        while(st <= end) {
            int mid = st + (end - st) / 2;
            
            if(pair[mid] > t) {
                idx = mid;
                end = mid - 1;
            }
            else st = mid + 1;
        }
        return idx;
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