class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int n = s.length();
        
        
        int st = 0, end = 0;
        int arr[] = new int[3];
        while(end < n){
            arr[s.charAt(end)-'a']++;
            while(
                arr[0] > 0 &&
                arr[1] > 0 && 
                arr[2] > 0 &&
                (end - st + 1) >= 3
            ) {
                count += n - end;
                arr[s.charAt(st)-'a']--;
                st++;
            }
            end++;
        }

        return count;
    }
}