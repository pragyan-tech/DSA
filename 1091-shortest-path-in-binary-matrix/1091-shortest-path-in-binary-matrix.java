class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }

        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});

        grid[0][0] = 1; 

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            if (r == n - 1 && c == m - 1) {
                return dist;
            }

            for (int[] dir : dirs) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 0) {
                    grid[newRow][newCol] = 1; 
                    queue.add(new int[]{newRow, newCol, dist + 1});
                }
            }
        }
        return -1;
    }
}