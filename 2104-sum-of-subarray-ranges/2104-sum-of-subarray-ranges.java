class Solution {
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
    private int[] NGE(int[]arr){
        int n=arr.length;
        int[]ans=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&& arr[st.peek()]<=arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return ans;
    }
    private int[] PGE(int[]arr){
        int n=arr.length;
        int[]ans=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&& arr[st.peek()]<arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return ans;
    }
    private long subArrMin(int[]arr){
        int n=arr.length;
        int[]nse=NSE(arr);
        int[]pse=PSE(arr);
        long sum=0;
        for(int i=0;i<n;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            long freq=1L*left*right;
            sum+=freq*arr[i];
        }
        return sum;
    }
    private long subArrMax(int[]arr){
        int n=arr.length;
        int[]nge=NGE(arr);
        int[]pge=PGE(arr);
        long sum=0;
        for(int i=0;i<n;i++){
            int left=i-pge[i];
            int right=nge[i]-i;
            long freq=1L*left*right;
            sum+=freq*arr[i];
        }
        return sum;
    }
    public long subArrayRanges(int[] nums) {
        return subArrMax(nums)-subArrMin(nums);
    }
}