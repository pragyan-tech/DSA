class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int max=0;
        int min=nums[0];
        for(int i=1;i<n;i++){
            int diff=nums[i]-min;
            max=Math.max(max,diff);
            min=Math.min(min,nums[i]);
        }
        if(max==0)return -1;
        return max;
    }
}