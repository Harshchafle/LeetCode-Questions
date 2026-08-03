class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = x, btm = x+k-1; i < btm; i++, btm--){
            for(int j = y; j < (y+k); j++){
                int temp = grid[i][j];
                grid[i][j] = grid[btm][j];
                grid[btm][j] = temp;
            }
        }
        return grid;
    }
}