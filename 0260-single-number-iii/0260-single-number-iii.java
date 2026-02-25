class Solution {
    public int[] singleNumber(int[] nums) {
        long num=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            num^=nums[i];
        }
        int rightmost=(int)(num & num-1)^(int) num;
        int b1=0,b2=0;
        for(int i=0;i<n;i++){
            if((rightmost & nums[i])!=0){
                b1^=nums[i];
            }else{
                b2^=nums[i];
            }
        }
        return new int[]{b1,b2};
    }
}