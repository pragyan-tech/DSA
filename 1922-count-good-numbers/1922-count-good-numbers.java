class Solution {
    private long mod=1000000007;
    public int countGoodNumbers(long n) {
        long evenPos=(n+1)/2;
        long oddPos=n/2;
        long firstPart=power(5,evenPos);
        long secondPart=power(4,oddPos);
        return (int)((firstPart*secondPart)%mod);

    }
    private long power(long base,long expo){
        if(expo==0)return 1;
        long half=power(base,expo/2);
        if(expo%2==0){
            return (half*half)%mod;
        }
        else{
            return (((half *half)%mod)*base)%mod;
        }
    }
}