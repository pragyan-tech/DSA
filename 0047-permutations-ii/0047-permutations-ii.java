class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        solve(new ArrayList<>(), nums, used, ans);

        return ans;
    }

    public void solve(List<Integer> p,int[] nums,boolean[] used,List<List<Integer>> ans) {
        if (p.size() == nums.length) {
            ans.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue;

            if (i > 0 &&
                nums[i] == nums[i - 1] &&
                !used[i - 1]) {
                continue;
            }

            used[i] = true;
            p.add(nums[i]);

            solve(p, nums, used, ans);

            p.remove(p.size() - 1);
            used[i] = false;
        }
    }
}