class Solution {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> ans = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; j < bound; j *= y) {
                if (i + j <= bound) {
                    set.add(i + j);
                    if (y == 1) {
                        break;
                    }
                }
            }
            if (x == 1) {
                break;
            }
        }
        ans.addAll(set);
        return ans;
    }
}
