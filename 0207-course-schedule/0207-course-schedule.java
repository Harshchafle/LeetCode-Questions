class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indeg = new int[n];
        for(int i = 0; i < pre.length; i++) {
            adj.get(pre[i][1]).add(pre[i][0]);
            indeg[pre[i][0]]++;
        }

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(indeg[i] == 0) que.offer(i);
        }

        while(!que.isEmpty()) {
            int removed = que.poll();
            ans.add(removed);
            for(int N : adj.get(removed)) {
                indeg[N]--;
                if(indeg[N] == 0) que.offer(N);
            }
        }

        return ans.size() == n;
    }
}