class Solution {
    public boolean strongPasswordCheckerII(String password) {
        return help(password);
    }
    public boolean help(String password) {
        if(password.length()<8)return false;
        boolean l=false;
        boolean u=false;
        boolean d=false;
        boolean s=false;
        for(int i=0;i<password.length();i++)
        {
            char ch=password.charAt(i);
            if(ch>='A'&& ch<='Z') u=true;
            else if(ch>='a'&&ch<='z') l=true;
            else if(ch>='0'&& ch<='9') d=true;
if(ch=='!' || ch=='@'|| ch=='#' || ch=='$'||ch=='%' || ch=='^'||ch=='&' || ch=='*'||ch=='(' ||ch==')'   || ch=='-'||ch=='+') s=true;
            if(i+1<password.length()){
                if(password.charAt(i)==password.charAt(i+1))
                    return false;
                }
            
        }
        return l&&u&&d&&s;
        
    }
}