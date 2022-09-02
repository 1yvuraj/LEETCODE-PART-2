class Solution {

    public int largestRectangleArea(int[] temperatures) {
        int max = -(int) 1e9;
        LinkedList<Integer> s = new LinkedList<>();
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans,temperatures.length);
        s.addFirst(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (s.size() > 0 && temperatures[s.peek()] > temperatures[i]) {
                ans[s.peek()] = i;
                s.removeFirst();
            }
            s.addFirst(i);
        }
        s = new LinkedList<>();
        int[] a = new int[temperatures.length];
        Arrays.fill(a,-1);
        s.addFirst(temperatures.length - 1);
        for (int i = temperatures.length - 2; i >= 0; i--) {
            while (s.size() > 0 && temperatures[s.peek()] > temperatures[i]) {
                a[s.peek()] = i;
                s.removeFirst();
            }
            s.addFirst(i);
        }
        for (int i = 0; i < ans.length; i++) {
            max = Math.max(max,Math.abs(ans[i]-a[i]-1)*temperatures[i]);
            
        }
        return max;
    }
}
