class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,Integer>m=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            int curr=nums2[i];
            while(!st.isEmpty() && curr>st.peek()){
                int popped=st.pop();
                m.put(popped,curr);
            }
            st.push(curr);
        }
        int[]ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=m.getOrDefault(nums1[i],-1);
        }
        return ans;
        
    }
}