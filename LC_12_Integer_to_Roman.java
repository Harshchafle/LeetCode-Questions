class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        StringBuilder ans = new StringBuilder();


        // count number of digits in the number
        int digits = 0;
        int n = num;
        while(n > 0){
            digits++;
            n /= 10;
        }

        // extract digit and approx it to nearest roman
        while(num > 0){
            int letter = num / (int)Math.pow(10, digits-1);

            // System.out.println(letter+" "+num+" "+digits);
            ans.append(makeRoman(letter, map, digits));

            if(letter != 0) num %= letter*(int)Math.pow(10, digits-1);
            digits--;
        }
        return ans.toString();

    }

    public String makeRoman(int letter, Map<Integer, String>map, int digits){
        StringBuilder subLetter = new StringBuilder();
        int multiplier = (int)Math.pow(10, digits-1);
        if(letter == 0) return subLetter.toString();
        else if((letter <= 3) || (letter >= 6 && letter <= 8)){
            int temp = letter;
            if(letter <= 3){
                while(temp > 0){
                    subLetter.append(map.get(multiplier));
                    temp--;
                }
            } 
            else {
                subLetter.append(map.get(multiplier*5));
                while(temp > 5){
                    subLetter.append(map.get(multiplier));
                    temp--;
                }
            }
        }
        else if((letter == 4) || (letter == 9)){
            subLetter.append(map.get(multiplier)).append(map.get(multiplier*(letter+1)));
        }
        else{   // 5 || 10
            subLetter.append(map.get(multiplier*letter));
        }
        return subLetter.toString();
    }
}