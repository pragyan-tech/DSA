class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        solve(res,"",0,0,n);
        return res;
    }
    private void solve(List<String>res,String s,int left,int right,int n){
        if(s.length()==n*2){
            res.add(s);
        }
        if(left<n){
            solve(res,s+"(",left+1,right,n);
        }
        if(right< left){
            solve(res,s+")",left,right+1,n);
        }
    }
}