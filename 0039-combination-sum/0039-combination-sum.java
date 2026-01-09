class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        solve(0,target,candidates,ans,res);
        return ans;
    }
    private void solve(int i,int target,int[]arr,List<List<Integer>>ans,List<Integer>res){
        if(i==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(res));
            }
            return;
        }
        if(arr[i]<=target){
            res.add(arr[i]);
            solve(i,target-arr[i],arr,ans,res);
            res.remove(res.size()-1);
        }
        solve(i+1,target,arr,ans,res);
    }
}