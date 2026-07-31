class Solution {
    public int minimumPushes(String word) {
        int n = word.length();

        int freq[] = new int[26];
        for(char ch : word.toCharArray()) {
            freq[ch-'a']++;
        }

        Arrays.sort(freq);
        int count = 0;
        int p = 0;
        for(int i = 25; i >= 0; i--) {
            if(freq[i] == 0) break;
            
            count += freq[i] * (p/8 + 1);
            p++;
        }
        return count;
    }
}