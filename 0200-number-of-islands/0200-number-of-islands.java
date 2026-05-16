class Solution {
    public void dfs(int row,int col,char[][]grid,int[] delRow,int[] delCol){
        int n=grid.length;
        int m=grid[0].length;
        
        grid[row][col]='0';

        for(int i=0;i<4;i++){
            int nRow=row + delRow[i];
            int nCol=col + delCol[i];
            if(nRow>=0 && nCol>=0 && nRow<n && nCol<m && grid[nRow][nCol]=='1'){
                dfs(nRow,nCol,grid,delRow,delCol);
            }
        }

    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};

        int cnt=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    dfs(i,j,grid,delRow,delCol);
                }
            }
        }
        return cnt;
    }
}