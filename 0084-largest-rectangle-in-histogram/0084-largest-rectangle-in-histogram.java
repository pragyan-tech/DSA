class Solution {
    public int[] prevSmaller(int[] nums){
        int n=nums.length;
        int[]ans=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            int curr=i;
            while(!st.isEmpty() && nums[st.peek()]>=nums[curr]){
                int popped=st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }else{
                ans[i]=st.peek();
            }
            st.push(curr);
        }
        return ans;
    }
    public int[] nextSmaller(int[] nums){
        int n=nums.length;
        int[]ans=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int curr=i;
            while(!st.isEmpty() && nums[st.peek()]>=nums[curr]){
                int popped=st.pop();
            }
            if(st.isEmpty()){
                ans[i]=n;
            }else{
                ans[i]=st.peek();
            }
            st.push(curr);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int[] left = prevSmaller(heights);
        int[] right = nextSmaller(heights);
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int width=right[i]-left[i]-1;
            int height=heights[i];
            int area=width * height;

            maxArea=Math.max(maxArea,area);
        }
            return maxArea;
    }
}