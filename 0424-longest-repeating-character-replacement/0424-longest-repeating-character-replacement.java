class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int maxLen=0;
        int maxFreq=0;
        int[]hash=new int[26];

        for(int r=0; r < s.length(); r++){
            hash[s.charAt(r)-'A']++;
            maxFreq=Math.max(maxFreq, hash[s.charAt(r)-'A']);

            while((r-l+1)-maxFreq > k){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            maxLen=Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}