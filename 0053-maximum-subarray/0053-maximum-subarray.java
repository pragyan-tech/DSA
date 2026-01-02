class Solution {
    public int maxSubArray(int[] nums) {
        return solve(nums,0,nums.length-1);
    }
    private int solve(int[]nums,int left,int right){
        if(left==right)return nums[left];
        int mid=left+(right-left)/2;
        int leftsum=solve(nums,left,mid);
        int rightsum=solve(nums,mid+1,right);
        int crossSum=cross(nums,left,mid,right);
        return Math.max(Math.max(leftsum,rightsum),crossSum);
    }
    private int cross(int[]nums,int left,int mid,int right){
        int sum=0;
        int leftmax=Integer.MIN_VALUE;
        for(int i=mid;i>=left;i--){
            sum+=nums[i];
            leftmax=Math.max(leftmax,sum);
        }
        sum=0;
        int rightmax=Integer.MIN_VALUE;
        for(int i=mid+1;i<=right;i++){
            sum+=nums[i];
            rightmax=Math.max(rightmax,sum);
        }
        return leftmax+rightmax;
    }
}