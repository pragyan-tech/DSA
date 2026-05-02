class Solution {
    public void helper(char[]s,int left,int right){
        if(left>=right)return ;
        char temp=s[left];
        s[left]=s[right];
        s[right]=temp;
        helper(s,left+1,right-1);
    }
    public void reverseString(char[] s) {
        int n=s.length;
        int left=0;
        int right=n-1;
        helper(s,left,right);
    }
}