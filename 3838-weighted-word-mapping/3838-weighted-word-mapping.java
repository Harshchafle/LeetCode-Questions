class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String ans = "";
        int n = words.length;
        for(int i = 0; i < n; i++){
            String str = words[i];
            int len = str.length();
            int idx = 0;

            for(int j = 0; j < len; j++){
                idx += weights[(str.charAt(j) - 'a')]%26;
            }
            idx %= 26;
            ans += ""+(char)('z'-idx);
        }
        return ans;
    }
}