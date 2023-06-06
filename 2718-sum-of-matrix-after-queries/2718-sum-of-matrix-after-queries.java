class Solution {
    public long matrixSumQueries(int n, int[][] q) {
       long sum=0;
       boolean []row=new boolean[n];
        boolean []col=new boolean[n];
        int rowc=n;
        int colc=n;
        for(int i=q.length-1;i>=0;i--){
            int type=q[i][0];
            int index=q[i][1];
            int val=q[i][2];
            if(type==0){
                if(row[index])continue;
                row[index]=true;
                rowc--;
                sum+=colc*val;
            }else{
                
                if(col[index])continue;
                col[index]=true;
                colc--;
                sum+=rowc*val;
            }
            
        
        }
    return sum;
    }
}