class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=0;
        for(int num:nums){
            right+=num;
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            left+=nums[i];
            right-=nums[i];
            if(nums[i]!=0)continue;
            if(left==right)cnt+=2;
            if(Math.abs(left-right)==1)cnt++;
        }
        return cnt;
    }
}