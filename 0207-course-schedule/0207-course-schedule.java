class Solution {
    public boolean dfs(int node,int[]vis,List<List<Integer>>adj){
        vis[node]=1;
        for(int i:adj.get(node)){
            if(vis[i]==1){
                return true;
            }
            if(vis[i]==0){
                if(dfs(i,vis,adj)){
                return true;
                }
            }
        }
        vis[node]=2;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]arr:prerequisites){
            adj.get(arr[1]).add(arr[0]);
        }
        int vis[]=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(dfs(i,vis,adj))return false;
            }
        }
        return true;
    }
}