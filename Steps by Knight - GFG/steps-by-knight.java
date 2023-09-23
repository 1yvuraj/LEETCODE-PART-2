//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    int[][]dir={{2,1},{-2,1},{2,-1},{-2,-1},{-1,-2},{-1,2},{1,-2},{1,2}};
    
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
         boolean[][]vis=new boolean[N][N];
         return bfs(KnightPos[0]-1,KnightPos[1]-1,TargetPos[0]-1,TargetPos[1]-1,N,vis,0);
         
          
    }
    public int bfs(int sr, int sc, int er,int ec,int N,boolean[][]vis,int count)
    {
        LinkedList<Integer>q=new LinkedList<>();
        q.addLast(sr*N+sc);
       
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int rem=q.removeFirst();
                int r=rem/N;
                int c=rem%N;
                if(vis[r][c])continue;
                vis[r][c]=true;
                if(r==er && c==ec){
                    return count;
                }
                for(int []d:dir){
                    int x=r+d[0];
                    int y=c+d[1];
                    if(x>=0 && y>=0 && x<N && y<N && !vis[x][y]){
                        q.addLast(x*N+y);
                    }
                }
            }count++;
        }
        return -1;
       
    }
}