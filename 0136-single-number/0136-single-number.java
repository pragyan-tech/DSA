class Solution {
    public int singleNumber(int[] nums) {
        int cnt=0;
        for(int i:nums){
            cnt^=i;
        }
        return cnt;
    }
}