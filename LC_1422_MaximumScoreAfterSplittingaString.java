class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int ones = 0;
        int zeroes = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1') ones++;
        }

        int maxCount = 0;
        for(int i = 0; i < n-1; i++){
            // System.out.println(ones+" "+zeroes);
            if(s.charAt(i) == '1'){
                ones--;
            } else {
                zeroes++;
            }
            maxCount = Math.max(maxCount, zeroes + ones);
        }
        return maxCount;
    }
}