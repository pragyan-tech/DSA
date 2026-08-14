class Solution {
    public int maximumLengthSubstring(String s) {
        int hash[]=new int[26];
        int left=0;
        int ans=0;
        for(int right=0;right<s.length();right++){
            hash[s.charAt(right)-'a']++;

            while(hash[s.charAt(right)-'a']>2){
                hash[s.charAt(left)-'a']--;
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}