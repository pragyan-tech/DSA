class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] prefix=new int[m];
        int maxArea=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                prefix[j]=(matrix[i][j]=='1')?prefix[j]+1:0;  
            }
            maxArea=Math.max(maxArea,largestAreaHistogram(prefix));
        }
        return maxArea;
    }
    public int largestAreaHistogram(int[]heights){
        int[]left=PSE(heights);
        int[]right=NSE(heights);
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int width=right[i]-left[i]-1;
            int height=heights[i];
            int area=(height*width);

            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
    private int[] NSE(int[]arr){
        int n=arr.length;
        int[]ans=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return ans;
    }
    private int[] PSE(int[]arr){
        int n=arr.length;
        int[]ans=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return ans;
    }
}