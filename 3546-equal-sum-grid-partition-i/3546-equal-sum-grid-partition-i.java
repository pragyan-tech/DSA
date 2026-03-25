class Solution {
    public boolean solve(long[]arr,long sum){
        long left=arr[0];
        long right=sum -left;
        for(int i=1;i<arr.length;i++){
            if(left==right)return true;
            else if(left>right)return false;
            left+=arr[i];
            right-=arr[i];
        }
        return false;
    }
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        long[]rowSum=new long[m];
        long[]colSum=new long[n];
        long sum=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                rowSum[i]+=grid[i][j];
                colSum[j]+=grid[i][j];
                sum+=grid[i][j];
            }
        }
        if (sum % 2 != 0) return false;

        if (solve(rowSum, sum)) return true;
        if (solve(colSum, sum)) return true;

        return false;
    }
}