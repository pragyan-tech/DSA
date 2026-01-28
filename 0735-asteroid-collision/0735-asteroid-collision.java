class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            boolean alive = true;
            while (!st.isEmpty() && asteroid < 0 && st.peek() > 0) {
                if (st.peek() < -asteroid) {
                    st.pop();
                    continue;
                } else if (st.peek() == -asteroid) {
                    st.pop();
                }
                alive = false;
                break;
            }
            if (alive) {
                st.push(asteroid);
            }
        }
        int[] ans = new int[st.size()];
            for (int i = st.size() - 1; i >= 0; --i) {
                ans[i] = st.pop();
            }
            return ans;
    }
}