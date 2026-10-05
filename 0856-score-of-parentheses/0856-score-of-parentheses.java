class Solution {
    public int scoreOfParentheses(String s) {
        int score=0;
        int cnt=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='('){
                ++cnt;
            }else{
                --cnt;
                if(s.charAt(i-1)=='('){
                    score+= 1 << cnt;
                }
            }
        }
        return score;
    }
}