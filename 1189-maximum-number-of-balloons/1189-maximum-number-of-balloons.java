class Solution {
    public int maxNumberOfBalloons(String text) {
        int[]hash=new int[26];
        for(char c: text.toCharArray()){
            hash[c-'a']++;
        }
        int b=hash['b'-'a'];
        int a=hash['a'-'a'];
        int l=hash['l'-'a']/2;
        int o=hash['o'-'a']/2;
        int n=hash['n'-'a'];

        return Math.min(Math.min(Math.min(b,a),l),Math.min(o,n));
    }
}