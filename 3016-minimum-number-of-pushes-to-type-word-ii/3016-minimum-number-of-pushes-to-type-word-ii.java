class Solution {
    class Key {
        char ch;
        int f;

        public Key(char _ch, int _f) {
            this.ch = _ch;
            this.f = _f;
        }
    }
    public int minimumPushes(String word) {
        int ones = 0, twos = 0, threes = 0, fours = 0;
        int n = word.length();
        PriorityQueue<Key> pq = new PriorityQueue<>((a,b) -> {
            return b.f - a.f;
        });

        int freq[] = new int[26];
        for(char ch : word.toCharArray()) {
            freq[ch-'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                pq.offer(new Key((char)(i+'a'), freq[i]));
            }
        }

        int count = 0;
        int p = 0;
        int mul = 1;
        while(!pq.isEmpty()) {
            Key k = pq.poll();
            char c = k.ch;
            int fq = k.f;

            // System.out.println(c+" "+fq+" "+p+" "+mul+" "+count);
            if(p >= 24) mul = 4;
            else if(p >= 16) mul = 3;
            else if(p >= 8) mul = 2;
            count += (fq * mul);
            p++;
        }

        return count;
    }
}