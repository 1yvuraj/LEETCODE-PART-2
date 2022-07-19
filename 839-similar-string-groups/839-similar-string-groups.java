class Solution {
    int[]p;
    public int numSimilarGroups(String[] strs) {
        p=new int[strs.length];
        int c=strs.length;
        for(int i=0;i<p.length;i++){
            p[i]=i;
        }
       for(int i=0;i<strs.length;i++){
           for(int j=i+1;j<strs.length;j++){
               if(is(strs[i],strs[j])){
                   int x=find(i);
                   int y=find(j);
                   if(x!=y){
                       p[x]=y;
                       c--;
                   }
               }
           }
       }
        return c;
       
    }
    public boolean is(String s1,String s2) {
      int c=0;
      for(int i=0;i<s1.length();i++){
          if(s1.charAt(i)!=s2.charAt(i))++c;
      }
        return c<=2;
       
    }
    public int find(int x) {
       return p[x]==x?x:(p[x]=find(p[x]));
       
    }
}