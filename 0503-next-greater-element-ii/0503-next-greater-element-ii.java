class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer>st=new Stack<>();
          int n=nums.length;    
        int[]ans=new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<2*n;i++){
            int curr=i%n;
            int num=nums[curr];
            while(!st.isEmpty() && nums[curr]>nums[st.peek()]){
                int popped=st.pop();
                ans[popped]=nums[curr];
            }
            st.push(curr);
        }
        return ans;
    }
}