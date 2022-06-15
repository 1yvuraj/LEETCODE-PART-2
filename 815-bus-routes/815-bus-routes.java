class Solution {
    public class pair{
        int bus;
        int count;
        pair(int bus,int count){
            this.bus=bus;
            this.count=count;
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(target==source)return 0;
        HashMap<Integer,HashSet<Integer>>map=new HashMap<>();
        for(int i=0;i<routes.length;i++)
        {
            for(int stop:routes[i]){
                if(map.containsKey(stop)==false){
                    map.put(stop,new HashSet<>());
                }
                map.get(stop).add(i);
            }
        }
        LinkedList<pair>list=new LinkedList<>();
        for(int stop:map.get(source)){
            list.addLast(new pair(stop,1));
        }
        boolean[]visit=new boolean[routes.length];
        while(list.size()>0){
            pair rem=list.removeFirst();
            if(visit[rem.bus]==true)
            {
                continue;
            }
            visit[rem.bus]=true;
            for(int stop:routes[rem.bus])
            {
                if(stop==target)
                {
                    return rem.count;
                }
            }
            for(int stop:routes[rem.bus]){
                for(int bus:map.get(stop)){
                    if(visit[bus]==false){
                    list.addLast(new pair(bus,rem.count+1));
                    }
                }
            }
            
        }
        return -1;
    }
}