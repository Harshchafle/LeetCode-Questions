class Solution {
    public int gcdOfOddEvenSums(int n) {
        int even = n*n;
        int odd = n*(n+1);

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