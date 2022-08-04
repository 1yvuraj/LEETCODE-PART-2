class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] edges) {
        List<List<Integer>>ans=new ArrayList<>();
        ArrayList<Integer>a=new ArrayList<>();
        a.add(0);
        dfs(edges,ans,a,0);
        return ans;
    }

    public void dfs(int[][]graph, List<List<Integer>>main,ArrayList<Integer>ans,int start) {
        if(start==graph.length-1){
            ArrayList<Integer>a=new ArrayList<>(ans);
            main.add(a);
            return;
        }
        for(int i:graph[start]){
            ans.add(i);
            dfs(graph,main,ans,i);
            ans.remove(ans.size()-1);
        }
    }
}
