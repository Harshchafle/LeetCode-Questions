class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // String of length 1 is always palindrome;
        for(int i = 0; i < n; i++) {
           dp[i][i] = 1;
        }

        // two consucutive character are palindromic if they are same
        for(int i = 0; i < n-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = 1;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        // print(dp);
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(0, s, dp, list, ans);

        return ans;
    }

    public void helper(int i, String s, int[][] dp, List<String> list, List<List<String>> ans) {
        int n = s.length();
        
        if(i == n){
            
            if(!list.isEmpty()){
                ans.add(new ArrayList<>(list));
                // list.remove(list.size()-1);
            }
            return;
        }
        // System.out.println(list);
        for(int k = i; k < n; k++) {
            if(dp[i][k] == 1) {
                list.add(s.substring(i,k+1));
                helper(k+1, s, dp, list, ans);
                list.remove(list.size()-1);
            }
            
        }
    }

    public void print(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}