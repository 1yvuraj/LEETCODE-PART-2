class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>>map=new HashMap<>();
        List<List<String>>a=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            char[]str=strs[i].toCharArray();
            Arrays.sort(str);
            String s=new String(str);
            if(map.containsKey(s)){
                map.get(s).add(strs[i]);
            }else{
                ArrayList<String>ans=new ArrayList<>();
                 map.put(s,ans);
                 map.get(s).add(strs[i]);
            }
        }
        for(int i=0;i<strs.length;i++){
            char[]str=strs[i].toCharArray();
            Arrays.sort(str);
            String s=new String(str);
            if(map.containsKey(s))a.add(map.get(s));
            map.remove(s);
        }
        return a;
    }
}