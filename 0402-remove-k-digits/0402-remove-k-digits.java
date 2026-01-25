class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len)
            return "0";

        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            while (k > 0 && !st.isEmpty() && st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
            i++;
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder s = new StringBuilder();
        while (!st.isEmpty())
            s.append(st.pop());
        s.reverse();

        while (s.length() > 1 && s.charAt(0) == '0')
            s.deleteCharAt(0);
        return s.toString();
    }
}