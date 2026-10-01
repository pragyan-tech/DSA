class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int mid = nums.length / 2;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[mid])
                cnt++;
        }
        return cnt==1;
    }
}