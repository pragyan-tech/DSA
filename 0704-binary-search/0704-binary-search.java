class Solution {
    public int search(int[] nums, int target) {
        return solve(nums,target,0,nums.length-1);
    }
    private int solve(int[] nums,int target,int start,int end){
        if(start>end)return -1;
        int mid=start+(end-start)/2;
        if(nums[mid]==target)return mid;
        if(target<nums[mid]){
            return solve(nums,target,start,mid-1);
        }
        return solve(nums,target,mid+1,end);   
    }
}