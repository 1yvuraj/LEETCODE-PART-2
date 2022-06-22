class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer>[]graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        for(int[]arr:prerequisites){
            graph[arr[0]].add(arr[1]);
        }
        int[]arr=new int[n];
        LinkedList<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int nbr:graph[i]){
                arr[nbr]++;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]==0)
            {
                q.addLast(i);
            }
        }
        int idx=arr.length-1;
       
        while(q.size()>0)
        {
            int rem=q.removeFirst();
            idx--;
            for(int nbr:graph[rem]){
                arr[nbr]--;
                if(arr[nbr]==0)
                {
                    q.addLast(nbr);
                }
            }
        }
        
        if(idx==-1){
            return true;
            
        }
        return false;
        

    }
}