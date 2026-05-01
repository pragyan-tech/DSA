class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        int sum=0;
        int prevSum=0;
        
        int idx=n-1;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            prevSum+=i*nums[i];
        }
        int max=prevSum;
        for(int i=0;i<n;i++){
            prevSum = prevSum + sum - (nums[idx] * n);
            max=Math.max(max,prevSum);
            idx--;
        }
        return max;
    }
}