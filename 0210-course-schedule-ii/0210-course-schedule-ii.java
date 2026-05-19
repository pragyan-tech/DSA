class Solution {
    public boolean dfs(int node, int[] vis, List<List<Integer>> adj, Stack<Integer> s) {
        vis[node] = 1; 
        
        for (int i : adj.get(node)) {
            if (vis[i] == 0) {
                if (!dfs(i, vis, adj, s)) return false; 
            } else if (vis[i] == 1) {
                return false; 
            }
        }
        
        vis[node] = 2; 
        s.push(node);
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj=new ArrayList<>();
        Stack<Integer>s=new Stack<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]arr:prerequisites){
            adj.get(arr[1]).add(arr[0]);
        }
        int[]vis=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(!dfs(i, vis, adj, s))return new int[0];
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!s.isEmpty()) {
            res[index++] = s.pop();
        }
        
        return res;
    }
}