class Solution {
    int[]p;
    public boolean equationsPossible(String[] equations) {
        p=new int[26];
        for(int i=0;i<p.length;i++){
            p[i]=i;
        }
        for(int i=0;i<equations.length;i++){
            String ans=equations[i];
            if(ans.charAt(1)=='='){
                int x=find(ans.charAt(0)-'a');
                int y=find(ans.charAt(3)-'a');
                if(x!=y){
                    p[x]=y;
                }
            }
        }
        for(int i=0;i<equations.length;i++){
            String ans=equations[i];
            if(ans.charAt(1)=='!'){
                int x=find(ans.charAt(0)-'a');
                int y=find(ans.charAt(3)-'a');
                if(x==y){
                    return false;
                }
            }
        }
        return true;
    }
    public int find(int x) {
       return p[x]==x?x:(p[x]=find(p[x]));
       
    }
}