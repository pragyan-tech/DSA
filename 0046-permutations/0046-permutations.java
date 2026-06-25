class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        solve(new ArrayList<>(),nums,ans);
        return ans;
    }
    public void solve(List<Integer>p,int[]up,List<List<Integer>>ans){
        if(p.size()==up.length){
            ans.add(new ArrayList<>(p));
            return;
        }
        for(int i=0;i<up.length;i++){
            if(p.contains(up[i]))continue;
            p.add(up[i]);
            solve(p,up,ans);
            p.remove(p.size()-1);
        }
    }
}