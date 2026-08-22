class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int temp = n;
        while(temp > 0) {
            sum += temp % 10;
            prod *= temp % 10;
            // System.out.println(temp%10+" "+sum+" "+prod);
            temp /= 10;
            
        }
        return (n % (sum + prod) == 0);
    }
}