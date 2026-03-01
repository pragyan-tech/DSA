class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int max=0;
        int min=prices[0];
        for(int i=1;i<n;i++){
            int cost=prices[i]-min;
            max=Math.max(max,cost);
            min=Math.min(min,prices[i]);
        }
        return max;
    }
}