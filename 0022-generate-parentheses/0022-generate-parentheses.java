class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<String>();
        solve(ans,0,0,"",n);
        return ans;
    }
    private void solve(List<String>res,int left,int right,String s,int n){
        if(s.length()==n*2){
            res.add(s);
            return;
        }
        if(left<n){
            solve(res,left+1,right,s+"(",n);
        }
        if(right<left){
            solve(res,left,right+1,s+")",n);
        }
    }
}