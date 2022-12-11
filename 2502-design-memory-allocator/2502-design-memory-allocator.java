class Allocator {
    int[]arr;
    int c=0;
    public Allocator(int n) {
        arr=new int[n];
    }
    public int allocate(int size, int mID) {
        c=0;
        int idx=0;
        boolean flag=false;
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
               c++; 
                if(c==size){
                    flag=true;
                    break;
                }
            }else{
                c=0;
                j=i+1;
            }
        }
        if(flag){
            for(int i=j;i<j+size;i++)arr[i]=mID;
             return j;
        }
        else return -1;
       
    }  
    public int free(int mID) {
        c=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==mID){
                c++;
                arr[i]=0;
                
            }
        }
        return c;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */