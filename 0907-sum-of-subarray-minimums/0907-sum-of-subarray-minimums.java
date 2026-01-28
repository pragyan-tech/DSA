class Solution {
    private int[] NLE(int []arr){
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
    private int[] PLE(int []arr){
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
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
         int[] nle = NLE(arr);
        int[] ple = PLE(arr);  

        int mod = 1000000007;
        int sum = 0;

        for(int i=0; i<n; i++) {
            int left = i - ple[i];
            int right = nle[i] - i;

            int freq = (int) ((left * right * 1L * arr[i]) % mod);
            sum = (sum + freq) % mod;
        }

        return sum;
    }
}