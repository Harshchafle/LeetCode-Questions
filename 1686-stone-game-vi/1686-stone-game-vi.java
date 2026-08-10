class Solution {
    public int stoneGameVI(int[] alice, int[] bob) {
        int n = alice.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> (alice[b]+bob[b]) - (alice[a]+bob[a])
        );
        for(int i = 0; i < n; i++) {
            pq.offer(i);
        }

        int score = 0;
        while(!pq.isEmpty()) {
            score += alice[pq.poll()];
            if(!pq.isEmpty()){
                score -= bob[pq.poll()];
            }
        }

        return (score > 0)? 1 : (score < 0)? -1 : 0;
    }
}