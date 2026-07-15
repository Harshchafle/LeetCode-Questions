class Solution {
    public int gcdOfOddEvenSums(int n) {
        int even = 0;
        int odd = 0;
        for(int i = 1; i <= 2*n; i++) {
            if((i&1)==0) even += i;
            else odd += i;
        }
        return GCD(even, odd);
    }

    public int GCD(int x, int y) {
        // if(y==0) return x;
        // return GCD(y, x%y);
        while(y!=0){
            int temp = y;
            y = x % temp;
            x = temp;
        }
        return x;
    }
}