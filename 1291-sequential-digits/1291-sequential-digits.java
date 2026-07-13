class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int digits = 0;
        int tmp = high;
        while(tmp > 0){
            digits++;
            tmp /= 10;
        }

        List<Integer> list = new ArrayList<>();     

        String seq = "123456789";
        int len = seq.length();
        for(int size = 1; size <= digits; size++){
            for(int st = 0; st <= len-size; st++){
                int end = st+size;
                int num = Integer.parseInt(seq.substring(st, end));
                if(num > high) return list;
                if(low <= num && num <= high){
                    list.add(num);
                }
            }
        }
        return list;
    }
}