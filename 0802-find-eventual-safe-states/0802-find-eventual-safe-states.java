class Solution {
    private boolean dfs(int node, int[][] graph, int[] state) {
        if (state[node] > 0) {
            return state[node] == 2;
        }

        state[node] = 1;

        for (int neighbor : graph[node]) {
            if (!dfs(neighbor, graph, state)) {
                return false;
            }
        }

        state[node] = 2;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[]state=new int[n];

        List<Integer>safe=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(dfs(i,graph,state)){
                safe.add(i);
            }
        }
        return safe;
    }
}