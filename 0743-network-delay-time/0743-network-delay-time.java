class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] edge : times) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]}); 
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int currentTime = curr[1];

            if (currentTime > dist[u]) continue;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (currentTime + weight < dist[v]) {
                    dist[v] = currentTime + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        int maxTime = 0;
        
        for (int i = 1; i <= n; i++) { 
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; 
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}