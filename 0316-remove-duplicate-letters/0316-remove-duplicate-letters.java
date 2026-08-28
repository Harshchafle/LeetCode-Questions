class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();

        int[] freq = new int[26];
        for(int i = 0; i < n; i++) freq[s.charAt(i)-'a'] = i;

        Stack<Character> st = new Stack<>();
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(set.contains(ch)) continue;
            while(!st.isEmpty() && st.peek() > ch && freq[st.peek()-'a'] > i){
                set.remove(st.pop());
            } 
            
            st.push(ch);
            set.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        return sb.reverse().toString();
    }
}