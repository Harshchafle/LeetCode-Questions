class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int count = 0;
        for(int k = 0; k < n; k++) {
            int i = 0, j = k;
            while(j < n) {
                if(i == j) {
                    dp[i][j] = true;
                    count++;
                }
                else if(j == i+1) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        count++;
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                        count++;
                    }
                }
                i++;
                j++;
            }
        }

        return count;
    }

    public boolean isPali(String str) {
        int st = 0;
        int end = str.length()-1;
        while(st < end) {
            if(str.charAt(st) != str.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }
}