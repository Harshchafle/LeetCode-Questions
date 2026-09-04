class Solution {
    public int shortestPathAllKeys(String[] grid) {
        return bfs(grid);
    }

    class State{
        int x, y, keys;
        public State(int x, int y, int keys) {
            this.x = x;
            this.y = y;
            this.keys = keys;
        }
    }

    public int bfs(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();

        int x = 0, y = 0;
        int max = -1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if(ch == '@'){
                    x = i;
                    y = j;
                }
                if(ch >= 'a' && ch <= 'f') {
                    max = Math.max(ch-'a'+1, max);
                }
            }
        }

        Queue<State> que = new LinkedList<>();
        que.offer(new State(x, y, 0));
        int steps = 0;
        Set<String> vis = new HashSet<>();
        
        while(!que.isEmpty()) {
            int size = que.size();
            while(size-- > 0) {
                State st = que.poll();
                if(st.keys == (1 << max)-1) {
                    return steps;
                }

                int[][] dir = {{0,-1}, {-1,0}, {0, 1}, {1, 0}};
                for(int[] d : dir) {
                    int newX = st.x + d[0];
                    int newY = st.y + d[1];
                    int keys = st.keys;
                    if(isValid(newX, newY, m, n)) {
                        char ch = grid[newX].charAt(newY);

                        // tackling wall
                        if(ch == '#') continue;
                        // key
                        if(isKey(ch)) keys |= 1 <<(ch-'a');
                        // Lock
                        if(isLock(ch) && ((keys >> (ch-'A')) & 1) == 0) continue;
                        
                        if(!vis.contains("("+newX+","+newY+","+keys+")")) {
                            vis.add("("+newX+","+newY+","+keys+")");
                            que.offer(new State(newX, newY, keys));
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public int dfs(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();

        int x = 0, y = 0;
        int k = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if(ch == '@'){
                    x = i;
                    y = j;
                }
                if(97 <= ch && ch <= 122) {
                    k++;
                }
            }
        }

        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(memo[i], Integer.MAX_VALUE);
        boolean keyType[] = new boolean[6];
        boolean vis[][] = new boolean[m][n];
        return helper(x, y, k, keyType, grid, vis, memo);
    }

    public int helper(
            int i, int j, int k, 
            boolean[] keyType, String[] grid, 
            boolean[][] vis, int[][] memo
        ) {
        
        int m = grid.length;
        int n = grid[0].length();

        if(k <= 0 || !isValid(i, j, m, n)) return 0;

        // if already calculated then return result
        // if(memo[i][j] != Integer.MAX_VALUE) return memo[i][j];

        char ch = grid[i].charAt(j);

        // if wall return
        if(ch == '#') return 0;

        // if key then take it 
        if(isKey(ch)) {
            keyType[ch-'a'] = true;
        }

        // if Lock then if key available unlock it and move on else collect key first
        if(isLock(ch)) {
            if(keyType[ch+32-'a']) {    // Key Available
                k--;
                if(k == 0) return 0;
                // move on
            }
            else {                      // Not Available
                return 0;
            }
        }
        vis[i][j] = true;

        int l = Integer.MAX_VALUE;
        int u = l;
        int r = l;
        int d = l;

        System.out.println(i+" "+j+" "+k+" ");
        // left
        if(isValid(i, j-1, m, n) && !vis[i][j-1])
            l = 1 + helper(i, j-1, k, keyType, grid, vis, memo);

        // up
        if(isValid(i-1, j, m, n) && !vis[i-1][j])
            u = 1 + helper(i-1, j, k, keyType, grid, vis, memo);

        // right
        if(isValid(i, j+1, m, n) && !vis[i][j+1])
            r = 1 + helper(i, j+1, k, keyType, grid, vis, memo);

        // down
        if(isValid(i+1, j, m, n) && !vis[i+1][j])
            d = 1 + helper(i+1, j, k, keyType, grid, vis, memo);

        return memo[i][j] = Math.min(l, Math.min(u, Math.min(r, d)));
    }

    public boolean isValid(int x, int y, int m, int n) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public boolean isKey(char ch) {
        return (97 <= ch && ch <= 122);         
    }

    public boolean isLock(char ch) {
        return (65 <= ch && ch <= 90);
    }
}