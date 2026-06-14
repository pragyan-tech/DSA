class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l=0;
        int[]hash=new int[26];
        for(char c:s1.toCharArray()){
            hash[c-'a']++;
        }
        for(int r=0;r<s2.length();r++){
            hash[s2.charAt(r)-'a']--;
            while(hash[s2.charAt(r)-'a']<0){
                hash[s2.charAt(l)-'a']++;
                l++;
            }
            if((r-l+1)==s1.length()){
                return true;
            }
        }
        return false;
    }
}