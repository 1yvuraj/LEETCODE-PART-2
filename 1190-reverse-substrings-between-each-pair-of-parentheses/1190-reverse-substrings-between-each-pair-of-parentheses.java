class Solution {

    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack();
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                 ans = "";
                while (st.peek() != '(') {
                    ans += st.pop();
                }
                st.pop();
                int k =0;
                while (k<ans.length()) {
                    st.push(ans.charAt(k));
                    k++;
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb=new StringBuilder();
        while (st.size() > 0) sb.append(st.pop());
        sb.reverse();
        return sb.toString();
    }
}
