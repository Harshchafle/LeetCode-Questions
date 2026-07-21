class Solution {
    class Pair {
        String des;
        double cost;

        public Pair(String _des, double _cost) {
            this.des = _des;
            this.cost = _cost;
        }
    }

    public double dfs(String src, String des, Set<String> vis, Map<String, List<Pair>> adj) {
        if(!adj.containsKey(src) || !adj.containsKey(des)) return -1.0;
        if(src.equals(des)) return 1.0;
        vis.add(src);
        for(Pair p : adj.get(src)) {
            if(!vis.contains(p.des)) {
                double v = dfs(p.des, des, vis, adj);
                if(v != -1){
                    return v * p.cost;
                }
            }
        }
        return -1.0;
    }

    public double[] calcEquation(List<List<String>> eq, double[] val, List<List<String>> q) {
        int n = val.length;
        Map<String, List<Pair>> adj = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String from = eq.get(i).get(0);
            String to = eq.get(i).get(1);
            if(!adj.containsKey(from)) adj.put(from, new ArrayList<>());
            if(!adj.containsKey(to)) adj.put(to, new ArrayList<>());
            adj.get(from).add(new Pair(to, val[i]));
            adj.get(to).add(new Pair(from, 1/val[i]));
        }

        int len = q.size();
        double[] ans = new double[len];

        for(int i = 0; i < len; i++) {
            String src = q.get(i).get(0);
            String des = q.get(i).get(1);

            Set<String> vis = new HashSet<>();
            double x = dfs(src, des, vis, adj);

            if(x != -1.0) {
                adj.get(src).add(new Pair(des, x));
                adj.get(des).add(new Pair(src, 1/x));
            }
            ans[i] = x;
        }

        return ans;
    }
}