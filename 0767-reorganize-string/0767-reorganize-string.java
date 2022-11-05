class Solution {
    class pair{
        char ch;
        int f;
        pair(char ch,int f){
            this.ch=ch;
            this.f=f;
        }
    }
    public String reorganizeString(String s) {
        int[]arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->(b.f-a.f));
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                pq.add(new pair((char)(i+'a'),arr[i]));
                
            }
        }
       pair block=pq.poll();
       sb.append(block.ch);
       block.f--;
       while(pq.size()>0){
           pair temp=pq.poll();
           sb.append(temp.ch);
           temp.f--;
           if(block.f>0){
               pq.add(block);
           }
           block=temp;
       }
        if(block.f>0)return "";
      return sb.toString();
    }
}