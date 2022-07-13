class Solution {

    public int kSimilarity(String s1, String s2) {
        HashSet<String> visit = new HashSet<>();
        LinkedList<String> list = new LinkedList<>();
        list.add(s1);
        int level = 0;
        while (list.size() > 0) {
            int size = list.size();
            while (size-- > 0) {
                String rem = list.removeFirst();
                if (visit.contains(rem)) {
                    continue;
                }
                visit.add(rem);
                if(rem.equals(s2)){
                    return level;
                }
                for (String s : nbr(s2, rem)) {
                    if (!visit.contains(s)) {
                        list.add(s);
                    }
                }
            }
            level++;
        }
        return -1;
        
    }
    public ArrayList<String> nbr(String s2,String rem) {
        int idx=-1;
        ArrayList<String>ans=new ArrayList<>();
        for(int i=0;i<s2.length();i++)
        {
            if(s2.charAt(i)!=rem.charAt(i)){
                idx=i;
                break;
            }
        }
        for(int i=idx+1;i<s2.length();i++)
        {
           if(s2.charAt(idx)==rem.charAt(i)){
           String str=help(rem,idx,i);
            ans.add(str);
           }
           
        }
        return ans;
        
    }

    public String help(String s1, int i, int j) {
        StringBuilder sb = new StringBuilder(s1);
        sb.setCharAt(i, s1.charAt(j));
        sb.setCharAt(j, s1.charAt(i));
        return sb.toString();
    }
}
