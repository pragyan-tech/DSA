class Solution {
    public int countPrimeSetBits(int left, int right) {
        int cnt=0;
        for(int i=left;i<=right;i++){
            int setBit=Integer.bitCount(i);
            if(isPrime(setBit)){
                cnt++;
            }
        }
        return cnt;
    }
    private boolean isPrime(int n) {
        if (n<=1) {
            return false;
        }
        for (int i=2;i*i <= n;i++) {
            if (n%i==0) {
                return false;
            }
        }
        
        return true;
    }
}