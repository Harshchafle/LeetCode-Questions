class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int count = 0;
        int[] sml = new int[26];
        int[] cap = new int[26];
        for(char ch : word.toCharArray()) {
            if(ch >= 'a'){
                cap[ch-'a']++;
            }
            else
                sml[ch-'A']++;
        }
        for(int i = 0; i < 26; i++) 
            if(sml[i] > 0 && cap[i] > 0) 
                count++;
        
        return count;
    }
}