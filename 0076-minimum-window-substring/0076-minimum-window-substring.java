class Solution {
    public String minWindow(String s, String t) {
        int l = 0, r = 0, cnt = 0;
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        int n = s.length();
        int m = t.length();
        int[] hash = new int[256];

        for (int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }

        while (r < n) {
            if (hash[s.charAt(r)] > 0) {
                cnt++;
            }
            hash[s.charAt(r)]--;

            while (cnt == m) {
                if ((r - l + 1) < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    cnt--;
                }
                l++;
            }
            r++;
        }

        return start == -1 ? "" : s.substring(start, start + minLen);
    }
}