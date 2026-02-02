class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen=0;
        int l=0;
        int zerocnt=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==0){
                zerocnt++;
            }
            while(zerocnt>k){
            if(nums[l]==0){
                zerocnt--;
            }
            l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}