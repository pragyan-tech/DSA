class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int maxLen = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (m.containsKey(ch)) {
                l = Math.max(l, m.get(ch) + 1);
            }
            m.put(ch, r);
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}