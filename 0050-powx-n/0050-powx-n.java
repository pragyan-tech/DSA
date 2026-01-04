class Solution {
    public double myPow(double x, int n) {
        return solve(x,n);
    }
    private double solve(double x,int n){
        return Math.pow(x,n);
    }
}