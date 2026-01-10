class Solution {
    public List<String> letterCombinations(String digits) {
        List<String>ans=new ArrayList<>();
        if(digits.isEmpty())return ans;
        String[]map={"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        solve("",ans,digits,map);
        return ans;
    }
    private void solve(String p,List<String>ans,String up,String[]map){
        if(up.isEmpty()){
            ans.add(p);
            return;
        }
        int digit=up.charAt(0)-'0';//will convert '2' to 2;
        String letters=map[digit];
        for(int i=0;i<letters.length();i++){
            char ch=letters.charAt(i);
            solve(p+ch,ans,up.substring(1),map);
        }
    }
}