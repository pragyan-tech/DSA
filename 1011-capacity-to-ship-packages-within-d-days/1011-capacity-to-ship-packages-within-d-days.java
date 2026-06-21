class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0,r=0;

        for(int w: weights){
            l=Math.max(l, w);
            r+=w;
        }
        while(l<r){
            int mid=l+(r-l)/2;

            if(canShip(weights,days,mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    public boolean canShip(int[]weights, int days, int capacity){
        int load=0;
        int usedDays=1;

        for(int w: weights){
            if(load + w > capacity){
                usedDays++;
                load=0;
            }
            load+= w;
        }
        return usedDays<=days;
    }
}