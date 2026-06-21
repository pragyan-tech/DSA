class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int l=0, r=mat.length-1;

        while(l<r){
            int mid= l + (r-l)/2;

            int col=maxCol(mat[mid]);

            if(mat[mid][col]> mat[mid+1][col]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return new int[]{ l, maxCol(mat[l])};
    }
    public int maxCol(int[]row){
        int idx=0;

        for(int i=1;i<row.length;i++){
            if(row[i]>row[idx]){
                idx=i;
            }
        }
        return idx;
    }
}