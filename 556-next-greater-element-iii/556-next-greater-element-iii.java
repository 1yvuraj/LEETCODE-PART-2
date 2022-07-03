class Solution {
    public int nextGreaterElement(int n) {
        long m=n;
        char[] ch=(""+m).toCharArray();
        int idx=-1;
        int j=-1;
         for(int i=ch.length-1;i>0;i--){
             if(ch[i-1]<ch[i]){
                 idx=i-1;
                 break;
             }
         }
        if(idx==-1){
            return -1;
        }
        if(idx>-1){
            for(j=ch.length-1;j>idx;j--){
            if(ch[j]>ch[idx]){
                swap(ch,idx,j);
                break;
            }
        }
            reverse(ch,idx+1,ch.length-1);
        }
        
        
        String str=new String(ch);
        long ans=Long.parseLong(str);
        if(ans<=Integer.MAX_VALUE){
            return (int)ans;
        }
        
        else{
            return -1;
        }
    }
    public static void swap(char[] ch,int i,int j){
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
    
    public static void reverse(char[] ch,int i,int j){
        while(i<j){
            swap(ch,i,j);
            i++;
            j--;
        }

    }
}