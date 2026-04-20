class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int s=0;
        int e=0;
        for(int i=0;i<n;i++){
            if(colors[i]!=colors[n-1]){
                s=i;
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(colors[i]!=colors[0]){
                e=i;
                break;
            }
        }
        return Math.max(n-1-s,e);
    }
}