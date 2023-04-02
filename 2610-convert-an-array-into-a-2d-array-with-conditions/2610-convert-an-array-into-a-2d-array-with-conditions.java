class Solution {

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] freq = new int[201];
        for (int val : nums) freq[val]++;
        int max = 0;
        for (int i = 0; i < freq.length; i++) {
            max = Math.max(max, freq[i]);
        }
        for (int i = 0; i < max; i++) {
            ans.add(new ArrayList<>());
        }
        for (int val : nums) {
            for (int j = 0; j < ans.size(); j++) {
                if (!ans.get(j).contains(val)) {
                    ans.get(j).add(val);
                    break;
                }
            }
        }
        return ans;
    }
}
