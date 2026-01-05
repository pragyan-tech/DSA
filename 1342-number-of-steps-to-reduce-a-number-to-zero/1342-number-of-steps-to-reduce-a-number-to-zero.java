class Solution {
    public int numberOfSteps(int num) {
        return solve(num,0);
    }
    private int solve(int n,int steps){
        if(n==0)return steps;
        if(n%2==0){
            return solve(n/2,steps+1);
        }
        return solve(n-1,steps+1);
    }
}