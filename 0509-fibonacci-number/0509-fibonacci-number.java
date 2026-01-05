class Solution {
    public int fib(int n) {
        return fibo(n);
    }
    private int fibo(int x){
        if(x<=1)return x;
        return fibo(x-1)+fibo(x-2);
    }
}