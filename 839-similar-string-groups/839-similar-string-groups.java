class Solution {
    HashMap<String,String> p;
    HashMap<String,Integer> r;

    public int numSimilarGroups(String[] strs) {
        p=new HashMap<>();
        r=new HashMap<>();
        
        for (String str : strs) {
            p.put(str, str);
            r.put(str, 1);
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                String s1 = strs[i];
                String s2 = strs[j];
                if (similar(s1, s2)) {
                    String x = find(s1);
                    String y = find(s2);
                    if(!(x.equals(y)))
                    union(x, y);
                }
            }
        }
        int count=0;
        for(String key:p.keySet()) {
           if(p.get(key).equals(key)){
               count++;
           }
            
        }
        return count;
    }

    public String find(String x) {
        if (p.get(x) == x) {
            return x;
        }
        String pos = p.get(x);
        String ans = find(pos);
        p.put(x, ans);
        return ans;
    }

    public void union(String x, String y) {
        if (r.get(x) > r.get(y)) {
            p.put(y, x);
        } else if (r.get(x) < r.get(y)) {
            p.put(x, y);
        } else {
            p.put(x, y);
            r.put(x, r.get(x) + 1);
        }
    }

    public boolean similar(String x, String y) {
        int res = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i)) {
                res++;
            }
        }
        return res == 2;
    }
}
