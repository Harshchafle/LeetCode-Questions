class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int quelen = queries.length;
        int count[] = new int[quelen];
        int n = words.length;
        
        int[] prefSum = new int[n];
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(isCorrectString(words[i])){
                sum++;
            }
            prefSum[i] = sum;
        }

        for(int i = 0; i < quelen; i++){
            //int stringCount = 0;
            // for(int j = queries[i][0]; j <= queries[i][1]; j++){
            //     if(isCorrectString(words[j])){
            //         stringCount++;
            //     }
            // }
            // count[i] = stringCount;
            count[i] = prefSum[queries[i][1]] - ((queries[i][0] == 0)? 0:prefSum[queries[i][0] - 1]);
        }
        return count;
    }

    public boolean isCorrectString(String str){
        return (isVowel(str.charAt(0)) && isVowel(str.charAt(str.length()-1)));
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}