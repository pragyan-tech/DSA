class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans=new ArrayList<>();
        int []hash=new int[26];
        for(char c:p.toCharArray()){
            hash[c-'a']++;
        }
        int l=0;
        for(int r=0;r<s.length();r++){
            hash[s.charAt(r)-'a']--;
            while(hash[s.charAt(r)-'a']<0){
                hash[s.charAt(l)-'a']++;
                l++;
            }
            if((r-l+1)==p.length()){
                ans.add(l);
            }
        }
        return ans;
    }
}