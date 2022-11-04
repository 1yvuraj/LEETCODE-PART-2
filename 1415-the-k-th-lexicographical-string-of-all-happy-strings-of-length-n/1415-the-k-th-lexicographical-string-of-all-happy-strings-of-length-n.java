class Solution {
    ArrayList<String>ans;
    public String getHappyString(int n, int k) {
        ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        
        help(n,sb);
        Collections.sort(ans);
        if(ans.size()<k)return "";
        return ans.get(k-1);
    }
    public void help(int n,  StringBuilder sb) {
        if(sb.length()==n){
            ans.add(sb.toString());
            return;
        }
        for(char ch='a';ch<='c';ch++){
            if(sb.length()>0 && sb.charAt(sb.length()-1)==ch)continue;
            sb.append(ch);
            help(n,sb);
            sb.deleteCharAt(sb.length()-1);
            
        }
    }
}