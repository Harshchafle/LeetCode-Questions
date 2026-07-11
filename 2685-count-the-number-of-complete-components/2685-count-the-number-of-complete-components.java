class Solution {
    int parent[];
    int rank[];

    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 1);

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            union(u,v);
        }

        Map<Integer, Integer> edgeCount = new HashMap<>();
        for(int [] edge : edges){
            int root = find(edge[0]);
            edgeCount.put(root, edgeCount.getOrDefault(root, 0) + 1);
        }

        // int[] indegree = new int[n];
        // for(int[] edge : edges){
        //     indegree[edge[0]]++;
        //     indegree[edge[1]]++;
        // }
        // System.out.println(Arrays.toString(indegree));

        // Map<Integer, List<Integer>> map = new HashMap<>();
        // for(int i = 0; i < n; i++){
        //     if(!map.containsKey(parent[i])){
        //         map.put(parent[i], new ArrayList<>());
        //     } 
        //     map.get(parent[i]).add(i);
        // }
        // System.out.println(map);

        // int counter = 0;
        // for(int component : map.keySet()){
        //     List<Integer> nodes = map.get(component);
        //     boolean flag = true;
        //     for(int node : nodes){
        //         if(indegree[node]+1 != nodes.size()){
        //             flag = false;
        //             break;
        //         }
        //     }
        //     if(flag) counter++;
        // }
        // return counter;

        int complete = 0;
        for(int v = 0; v < n; v++){
            if(find(v) == v){
                int nodeCount = rank[v];
                int expectedEdges = (nodeCount * (nodeCount - 1) / 2);
                if(edgeCount.getOrDefault(v, 0) == expectedEdges){
                    complete++;
                }
            }
        }
        return complete;
    }

    public int find(int x){
        if(parent[x] == -1){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY){ // already in same group
            // return false;
            return;
        }

        if(rank[rootX] > rank[rootY]){
            parent[rootY] = rootX;
            rank[rootX] += rank[rootY];
        }
        else {
            parent[rootX] = rootY;
            rank[rootY] += rank[rootX];
        }
        // return true;
    }
}