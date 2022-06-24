class Solution {
    int[] arr;
    int[] rank;
    int count;
    public int regionsBySlashes(String[] grid) {
        count=1;
        int n=grid.length;
        arr = new int[(n+1)*(n+1)];
        rank = new int[(n+1)*(n+1)];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<=grid.length;i++)
        {
            for(int j=0;j<=grid.length;j++)
            {
                if(i==0 || j==0 ||i==grid.length || j==grid.length)
                {
                    int cellno=i*(grid.length+1)+j;
                    if(cellno!=0){
                    help(0,cellno);
                    }
                }
            }
        }
        for(int i=0;i<grid.length;i++)
        {
            char[]ch=grid[i].toCharArray()
;            for(int j=0;j<grid.length;j++)
            {
                
                if(ch[j]=='/')
                {
                    int cell1=i*(grid.length+1)+j+1;
                    int cell2=(i+1)*(grid.length+1)+j;
                    help(cell1,cell2);
                }else if(ch[j]=='\\'){
                    int cell1=i*(grid.length+1)+j;
                    int cell2=(i+1)*(grid.length+1)+j+1;
                    help(cell1,cell2);
                }
            }
        }
        return count;
        
    }
    public void help(int x,int y)
    {
        int x1=find(x);
        int y1=find(y);
        if(x1!=y1)
        {
            union(x1,y1);
        }
        else{
            count++;
        }
    }
    public int find(int x)
    {
        if(arr[x]==x)
        {
            return x;
        }
        int temp=find(arr[x]);
        arr[x]=temp;
        return temp;
    }
    public void union(int x,int y)
    {
       
        if(rank[x]>rank[y]){
            arr[y]=x;
        }else if(rank[x]<rank[y]){
            arr[x]=y;
        }else{
            arr[x]=y;
            rank[x]++;
        }
        
    }
}
