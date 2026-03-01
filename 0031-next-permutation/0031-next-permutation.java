class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j=nums.length-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            swap(i,j,nums);
        }
        rev(nums,i+1);
    }
    public void swap(int a,int b,int[]nums){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void rev(int[]arr,int start){
        int i=start;
        int j=arr.length-1;
        while(i<j){
            swap(i,j,arr);
            i++;
            j--;
        }
    }
}