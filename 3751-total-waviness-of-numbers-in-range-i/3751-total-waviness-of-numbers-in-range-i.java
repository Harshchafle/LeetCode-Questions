class Solution {
    public int totalWaviness(int num1, int num2) {
        int waviness = 0;

        for(int i = Math.max(101, num1); i <= num2; i++){
            String number = String.valueOf(i);
            int j = 1;
            while(j <= number.length()-2){
                int prev = number.charAt(j-1)-'0';
                int curr = number.charAt(j)-'0';
                int next = number.charAt(j+1)-'0';
                // System.out.println(prev+" "+curr+" "+next);
                if(prev < curr && curr > next) waviness++;
                if(prev > curr && curr < next) waviness++;
                j++;
            }
        }

        return waviness;
    }
}