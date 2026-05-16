class Solution {
    public void dfs(int row, int col, int[][] grid, int[] delRow, int[] delCol) {
        int n = grid.length;
        int m = grid[0].length;
        
        grid[row][col] = 0;
        
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, grid, delRow, delCol);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (n == 0 || m == 0) return 0;
        
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1};

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                dfs(0, j, grid, delRow, delCol);
            }
            if (grid[n-1][j] == 1) {
                dfs(n-1, j, grid, delRow, delCol);
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, grid, delRow, delCol);
            }
            if (grid[i][m-1] == 1) {
                dfs(i, m-1, grid, delRow, delCol);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}