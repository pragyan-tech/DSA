class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       return atMost(nums,k)-atMost(nums,k-1);
    }

    public int atMost(int[] nums, int k){
        int left=0;
        int right=0;
        int oddCount=0;
        int subArrays=0;

        while(right<nums.length){
            if(nums[right]%2==1){
                oddCount++;
            }

            while(oddCount>k){
                if(nums[left]%2==1){
                    oddCount--;
                }
                left++;
            }

            if(oddCount<=k){
                subArrays+=right-left+1;
            }

            right++;
        }

        return subArrays;
    }
}