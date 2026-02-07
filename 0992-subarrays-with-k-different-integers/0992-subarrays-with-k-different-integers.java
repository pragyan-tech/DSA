class Solution {
    public int atMost(int[] nums, int k) {
        int l=0;
        int maxCnt=0;
        Map<Integer,Integer>m=new HashMap<>();
        for(int r=0;r<nums.length;r++){
            m.put(nums[r],m.getOrDefault(nums[r],0)+1);
            while(m.size()>k){
                m.put(nums[l],m.get(nums[l])-1);
                if(m.get(nums[l])==0){
                    m.remove(nums[l]);
                }
                l++;
            }
            maxCnt+=r-l+1;
        }
        return maxCnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
       return atMost(nums,k) - atMost(nums,k-1);
    }
}