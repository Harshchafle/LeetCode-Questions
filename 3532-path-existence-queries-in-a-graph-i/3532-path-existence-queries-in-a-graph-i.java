class Solution {
    private int[] parent;
    private int[] rank;
    
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // unionFind(n);
        int len = queries.length;
        boolean[] ans = new boolean[len];

        int[] num = new int[n];
        num[0] = 0;
        int counter = 0;
        for(int i = 1; i < n; i++){
            if(Math.abs(nums[i]-nums[i-1]) > maxDiff){
                counter++;
            }
            num[i] = counter;
        }

        for(int i = 0; i < len; i++){
            int[] q = queries[i];
            if(num[q[0]]==num[q[1]]){
                ans[i] = true;
            }
            else ans[i] = false;
        }
        return ans;

       

        
    }

    public void unionFind(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = i;
        }
    }

    public int find(int x){
        if(parent[x] != x){
            return find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y){
        int rootX = parent[x];
        int rootY = parent[y];

        if(rootX == rootY){
            return false;
        }
        if(rank[rootX] < rank[rootY]){
            parent[rootX] = rootY;
        }
        else if(rank[rootX] > rank[rootY]){
            parent[rootY] = rootX;
        }
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}