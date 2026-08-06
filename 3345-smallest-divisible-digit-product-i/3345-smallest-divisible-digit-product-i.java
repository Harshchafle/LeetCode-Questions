class Solution {
    public int smallestNumber(int n, int t) {
        
        int i = n;
        while(i < 101) {
            int prod = 1;
            int num = i;
            while(num > 0) {
                prod *= num%10;
                num /= 10;
            }
            if(prod%t == 0) return i;
            i++;
        }
        return 0;
    }
}