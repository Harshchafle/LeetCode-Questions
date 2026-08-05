class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int in[] : invocations) {
            adj.get(in[0]).add(in[1]);
        }
        // System.out.println(adj);

        boolean[] sus = new boolean[n];
        dfs(k, adj, sus);

        /* 
        bfs {
            Queue<Integer> que = new LinkedList<>();
            que.offer(k);
            sus[k] = true;
            while(que.size() > 0) {
                int curr = que.poll();
                List<Integer> neigh = adj.get(curr);
                for(int next : neigh) {
                    if(!sus[next])
                        que.offer(next);
                    sus[next] = true;
                }
            }
        }
        */

        // System.out.println(Arrays.toString(sus));
        // all suspects are now true and rest are false;

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(i == k) continue;
            if(!sus[i]){
                List<Integer> neigh = adj.get(i);
                for(int next : neigh) {
                    if(sus[next]) return all(n, ans);
                    sus[next] = false;
                }
            }
        }

        
        for(int i = 0; i < n; i++) {
            if(!sus[i]) ans.add(i);
        }

        return ans;
    }

    public List<Integer> all(int n, List<Integer> ans) {
        for(int i = 0; i < n; i++) ans.add(i);
        return ans;
    }

    public void dfs(int node, List<List<Integer>> adj, boolean[] sus) {
        sus[node] = true;
        List<Integer> neigh = adj.get(node);
        for(int next : neigh) {
            if(!sus[next]) dfs(next, adj, sus);
        }
    }
}