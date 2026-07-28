class Solution {

    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n <= 3) return s;
        int[] freq = new int[26];

        // mid 
        String middleChar = ((n & 1) == 1)? s.charAt(n / 2) + "" : "";

        // freq array
        for(char ch : s.substring(0, n / 2).toCharArray()) {
            freq[ch-'a']++;
        }

        // System.out.println(Arrays.toString(freq));

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            sb.append(
                ((char)(i+'a')+"").repeat(freq[i])
                );
        }


        return sb.toString() + middleChar + sb.reverse().toString();
    }
}