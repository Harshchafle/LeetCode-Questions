class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int count = 0;
        for(char ch : s.toCharArray()) {
            count += (ch - '0');
        }

        List<String> list = new ArrayList<>();
        int st = 0;
        int end = 0;
        while(end < n) {
            while(end < n && s.charAt(st) == s.charAt(end)) {
                end++;
            }
            list.add(s.substring(st, end));
            st = end;
        }
        // System.out.println(count+" "+list);
        int sum = 0;
        for(int i = 1; i < list.size()-1; i++) {
            if(list.get(i).charAt(0) == '1') {
                String left = list.get(i-1);
                String right = list.get(i+1);
                if(left.charAt(0) == '0' && right.charAt(0) == '0') {
                    sum = Math.max(sum, left.length() + right.length());
                }
            }
        }

        return sum+count;
    }
}