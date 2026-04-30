class Solution {
    public String countAndSay(int n) {
        String s="1";
        for(int i=1;i<n;i++){
            s=helper(s);
        }
        return s;
    }
    public String helper(String s){
        StringBuilder sb=new StringBuilder();
        int cnt=1;
        char c=s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==c){
                cnt++;
            }else{
                sb.append(cnt);
                sb.append(c);
                c=s.charAt(i);
                cnt=1;
            }
        }
        sb.append(cnt);
        sb.append(c);
        return sb.toString();
    }
}