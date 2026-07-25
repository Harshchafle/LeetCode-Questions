class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        Deque<String> stack = new ArrayDeque<>();

        int st = 0;
        while(st < n) {
            char ch = path.charAt(st);
            if(ch != '/') {
                String str = "";
                while(st < n && path.charAt(st) != '/'){
                    str += ""+(path.charAt(st));
                    st++;
                }
                if(str.equals("..")){
                    if(!stack.isEmpty()) stack.pop();
                }
                else if(str.equals(".")){}
                else stack.push(str);
            }
            st++;
        }

        String answer = "";
        if(stack.isEmpty()) answer += "/";
        while(!stack.isEmpty()){
            answer += "/"+stack.removeLast();
        }
        return answer;
    }
}