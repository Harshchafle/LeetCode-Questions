class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        return helper(columnNumber, str);
    }

    public String helper(int num , StringBuilder str){
            num--;
            if(num < 0){
                return str.toString();
            }
            int ch = num % 26;
            str.insert(0, (char)(ch+'A'));
        return helper(num / 26, str);
    }
}