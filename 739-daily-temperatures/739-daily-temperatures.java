class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer>s=new LinkedList<>();
        int[]ans=new int[temperatures.length];
        s.addFirst(0);
        for(int i=1;i<temperatures.length;i++){
            while(s.size()>0 && temperatures[s.peek()]<temperatures[i]){
                ans[s.peek()]=i-s.peek();
                s.removeFirst();
            }
            s.addFirst(i);
        }
        return ans;
    }
}