class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        if(n == 2){
            return 2;
        }
        int st = 0;
        int end = 0;
        int[] freq = new int[26];
        int max = 0;

        while(end < n) {
            char ch = s.charAt(end);
            if(freq[ch-'a'] == 2){
                max = Math.max(max, end-st);
                while(freq[ch-'a'] == 2){
                    freq[s.charAt(st)-'a']--;
                    st++;
                }
            }
            freq[ch-'a']++;
            end++;
        }
        max = Math.max(max, end-st);
        return max;
    }
}