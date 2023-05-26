class Solution {
    public int punishmentNumber(int n) {
        int sum=0;
        for(int i=1;i<=n;i++){
            int ans=i*i;
            
            if(partionsum(0,i,ans+"")){
            
                sum+=ans;
            }
        }
        return sum;
    }
    public boolean partionsum(int sum,int tar,String str) {
      if(str.length()==0){
          if(sum==tar)return true;
          else return false;
      }
      for(int i=0;i<str.length();i++){
      int val=Integer.parseInt(str.substring(0,i+1));
      if(partionsum(sum+val,tar,str.substring(i+1)))return true;
    
      }
        return false;
    }
    
}

