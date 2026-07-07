class Solution {
    public long sumAndMultiply(int n) {
        int x = 0;
        int temp = n;
        // int dig = 0;
        // while(temp > 0){
        //     if(temp % 10 > 0){
        //         dig++;
        //     }
        //     temp /= 10;
        // }

        int p = 0;
        while(n > 0){
            if(n % 10 > 0){
                x += Math.pow(10, p) * (n % 10);
                p++;
            }
            n /= 10;
        }

        int sum = 0;
        temp = x;
        // System.out.println(x);
        while(temp > 0){
            sum += (temp % 10);
            temp /= 10;
        }
        // System.out.println(x+" "+sum);
        return (long)sum * x;
        
    }
}