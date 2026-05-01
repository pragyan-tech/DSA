class Solution {
    public void dfs(int[][] image, int sr, int sc, int color,int prevColor){
        int rows=image.length;
        int col=image[0].length;
        if(sr<0 || sr>=rows || sc<0 || sc>=col || image[sr][sc]!=prevColor){
            return;
        }
        image[sr][sc]=color;
        dfs(image,sr+1,sc,color,prevColor);
        dfs(image,sr-1,sc,color,prevColor);
        dfs(image,sr,sc+1,color,prevColor);
        dfs(image,sr,sc-1,color,prevColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        int prevColor = image[sr][sc];
        if(color==prevColor)return image;
        dfs(image,sr,sc,color,prevColor);
        return image;
    }
}