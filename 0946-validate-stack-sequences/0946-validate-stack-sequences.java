class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int idx = 0;
        int y = 0;
        while (idx < pushed.length) {
            s.push(pushed[idx]);
            while (s.size() > 0 && popped[y] == s.peek()) {
                s.pop();
                y++;
            }
            idx++;
        }

        return s.size() == 0 ? true : false;
    }
}
