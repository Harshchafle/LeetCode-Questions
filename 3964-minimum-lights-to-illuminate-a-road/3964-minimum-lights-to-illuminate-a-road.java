class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        int st = 0;

        int[] pref = new int[n];
        for(int i = 0; i < n; i++) {
            if(lights[i] != 0){
                int left = Math.max(0, i - lights[i]);
                pref[left]--;
                int right = i + lights[i]+1;
                if(right < n)
                    pref[right]++;
            }
        }
        for(int i = 1; i < n; i++) {
            pref[i] += pref[i-1];
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(pref[i] == 0) {
                int j = i;
                while(j < n && pref[j] == 0) j++;
                list.add(j-i);
                i = j;
            }
        }

        int req = 0;
        for(int num : list) {
            req += Math.ceilDiv(num, 3);
        }

        

        return req;
    }
}