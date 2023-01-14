class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>st=new Stack<>();
        int idx=0;
        while(idx<s.length()){
            char ch=s.charAt(idx);
            if(st.size()>0 && st.peek()=='(' && ch==')')st.pop();
            else st.push(ch);
            idx++;
            
        }
        return st.size();
    }
}