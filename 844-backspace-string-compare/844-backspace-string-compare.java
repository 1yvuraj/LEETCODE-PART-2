class Solution {
    public boolean backspaceCompare(String str, String t) {
        LinkedList<Character> s = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#') {
                s.addFirst(str.charAt(i));
            } else {
                if (s.size() > 0) s.removeFirst();
            }
        }
        String ans1 = "";
        String ans2 = "";
        while (s.size() > 0) {
            ans1 += s.removeFirst();
        }
        s = new LinkedList<>();
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                s.addFirst(t.charAt(i));
            } else {
                if (s.size() > 0) s.removeFirst();
            }
        }
        while (s.size() > 0) {
            ans2 += s.removeFirst();
        }
        return ans1.equals(ans2);
    }
}
