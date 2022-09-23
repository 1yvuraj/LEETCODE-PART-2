class Solution {
    ArrayList<String> main = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> map = new HashSet<>();
       
        for (String val : wordDict) {
            map.add(val);
        }
        help(s, map, 0, "");
        return main;
    }

    public void help(String s, HashSet<String> map, int si,  String ans) {
        if (si == s.length()) {
            String a = "";
            a += ans;
            main.add(ans.trim());
            return ;
        }
        for (int i = si; i <= s.length(); i++) {
            if (map.contains(s.substring(si, i))) {
               help(s, map, i,  ans + s.substring(si, i) + " ");
            }
        }
        
    }
}
