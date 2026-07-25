class Solution {
    public int minCut(String s) {
        int n = s.length();
        if(n==1) return 0;
        if(n==2) return (s.charAt(0) == s.charAt(1))? 0 : 1;

        boolean dp[][] = new boolean[n][n];
        int cuts[] = new int[n];

        // for each length of palindrome
        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(((j+1 > i-1) || dp[j+1][i-1]) && s.charAt(i) == s.charAt(j)){
                    dp[j][i] = true;
                    min = (j == 0)? 0 : Math.min(min, cuts[j-1]+1);
                }
            }
            cuts[i] = min;
        }

        return cuts[n-1];
    }
}