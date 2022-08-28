class Solution {
    public String removeStars(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(st.size()>0 && ch=='*'){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        StringBuilder input1 = new StringBuilder();
        String ans="";
        while(st.size()>0){
            ans+=st.pop();
        }
        input1.append(ans);
        input1.reverse();
        return input1.toString();
    }
}