class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n==1) return 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        if(ratings[0] > ratings[1]) dp[0]++;
        
            for(int j = 1; j < n; j++){
                if(ratings[j] > ratings[j-1])
                    dp[j] = dp[j-1] + 1;
            }
            for(int j = n-2; j >= 0; j--){
                if(ratings[j] > ratings[j+1])
                    dp[j] = Math.max(dp[j], dp[j+1]+1);
            }
        int sum = Arrays.stream(dp).sum();
        return sum;
    }
}