class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;

        int[][]dist=new int[n][m];
        for(int[]row: dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dist[0][0]=0;

        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[2]-b[2]));
        pq.add(new int[]{0,0,0});

        int [][]dirs={{-1,0},{1,0},{0,-1},{0,1}};

        while(!pq.isEmpty()){
            int[]curr=pq.poll();
            int currRow=curr[0];
            int currCol=curr[1];
            int currCost=curr[2];

            if(currRow==n-1 && currCol==m-1){
                return currCost;
            }
            for(int []dir:dirs){
                int nRow= currRow + dir[0];
                int nCol=currCol + dir[1];

                if(nRow>=0 && nCol>=0 && nRow<n && nCol<m){
                    int effort=Math.max(currCost, Math.abs(heights[currRow][currCol]-heights[nRow][nCol]));
                    if (effort < dist[nRow][nCol]) {
                        dist[nRow][nCol] = effort;
                        pq.add(new int[]{nRow, nCol, effort});
                    }
                }
            }

        }
        return 0;
    }
}