class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>(); 
        
        for (int i = 0; i < n; i++) {
            int curr = i;
       
            while (!st.isEmpty() && temperatures[curr] > temperatures[st.peek()]) {
                int popped = st.pop();
                ans[popped] = curr-popped;
            }
            st.push(curr);
        }
        return ans;
    }
}