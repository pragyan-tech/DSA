class Solution {
    public void dfs(int node,int[]visited,ArrayList<ArrayList<Integer>>adj){
        visited[node]=1;
        for(int i:adj.get(node)){
            if(visited[i]==0){
                dfs(i,visited,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int visited[]=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,visited,adj);
                cnt++;
            }
        }
        return cnt;
    }
}