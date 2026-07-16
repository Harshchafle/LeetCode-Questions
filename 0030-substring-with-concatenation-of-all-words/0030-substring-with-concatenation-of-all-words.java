class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int max = s.length();
        int n = words.length;
        int oneLen = words[0].length();
        List<Integer> list = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        for(int i = 0; i < oneLen; i++) {
            Map<String, Integer> currMap = new HashMap<>();
            int l = i;
            int count = 0;

            for(int r = i; r+oneLen <= max; r += oneLen){
                String rw = s.substring(r, r+oneLen);

                if(map.containsKey(rw)) {
                    currMap.put(rw, currMap.getOrDefault(rw, 0) + 1);
                    count++;

                    while(currMap.get(rw) > map.get(rw)) {
                        String lw = s.substring(l, l+oneLen);
                        
                        currMap.put(lw, currMap.get(lw) - 1);
                        l += oneLen;
                        count--;
                    }

                    if(count == n){
                        list.add(l);
                    }
                    
                }
                else {
                    currMap.clear();
                    count = 0;
                    l = r+oneLen;
                }
            }
        }
        return list;
    }
}