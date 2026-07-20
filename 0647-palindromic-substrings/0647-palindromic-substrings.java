class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                String substr = s.substring(i, j+1);
                if(isPali(substr)) count++;
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