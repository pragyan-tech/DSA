class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int cnt=0;
        int n=cardPoints.length;
        for(int i=0;i<k;i++){
            cnt+=cardPoints[i];
        }
        int max=cnt;
        for(int i=0;i<k;i++){
            cnt-=cardPoints[k-1-i];
            cnt+=cardPoints[n-1-i];

            max=Math.max(max,cnt);
        }
        return max;
    }
}