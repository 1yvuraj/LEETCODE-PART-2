class Solution {
    public int minAddToMakeValid(String s) {
        LinkedList<Character>st=new LinkedList<>();
        st.addFirst(s.charAt(0));
        int i=1;
        while(i<s.length())
        {
            if(st.size()>0 && st.peek()=='('&& s.charAt(i)==')'){
                st.removeFirst();
                
            }else if(s.charAt(i)==')' || s.charAt(i)=='(' ){
                st.addFirst(s.charAt(i));
               
            }
            i++;
        }
        return st.size();
    }
}