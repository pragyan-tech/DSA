class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]}); 
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {src, 0, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int u = curr[0];
            int currCost = curr[1];
            int currStops = curr[2];

            if (currStops > k) {
                continue;
            }

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (currCost + weight < dist[v]) {
                    dist[v] = currCost + weight;
                    queue.add(new int[] {v, dist[v], currStops + 1});
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}