class Solution {
    public char[] rotate(char []arr){
        int n=arr.length;
        char first=arr[0];
        System.arraycopy(arr,1,arr,0,n-1);
        arr[n-1]=first;
        return arr;
    }
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())return false;
        int n=s.length();
        char[]sChar=s.toCharArray();
        for(int i=0;i<n;++i){
            sChar=rotate(sChar);
            if(new String(sChar).equals(goal))return true;
        }
        return false;
    }
}