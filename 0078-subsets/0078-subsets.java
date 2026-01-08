class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(new ArrayList<>(),nums,0,ans);
        return ans;
    }
    public void solve(List<Integer>p,int[]up,int i,List<List<Integer>>ans){
        if(i==up.length){
            ans.add(new ArrayList<>(p));
            return;
        }
        p.add(up[i]);
        solve(p,up,i+1,ans);
        p.remove(p.size()-1);
        solve(p,up,i+1,ans);
    }
}