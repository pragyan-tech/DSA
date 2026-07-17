class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        int n=nums.length;
        int actual=n*(n+1)/2;
        int ans=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        ans=actual-sum;
        return ans;
    }
}