class Solution {
    public int longestSubsequence(int[] nums) {
        int Nonzero=0;
        int ans=nums.length;
        int xor=0;

        for(int num : nums){
            xor^=num;
            if(num!=0){
                Nonzero++;
            }
        }
        if(xor!=0)return ans;
        if(Nonzero==0)return 0;
        return ans - 1;
    }
}