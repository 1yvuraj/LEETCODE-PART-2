class LUPrefix {

    Integer[]arr;
    int idx;
    public LUPrefix(int n) {
       arr=new Integer[n]; 
    }
    
    public void upload(int video) {
        arr[video-1]=1;
    }
    
    public int longest() {
        
        for(int i=idx;i<arr.length;i++){
            if(arr[i]==null)return idx=i;
        }
        return arr.length;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */