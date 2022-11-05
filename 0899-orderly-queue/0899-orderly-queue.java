// class Solution {
//     public String orderlyQueue(String s, int k) {
//         String ans = s;
//         if (k == 1) {
//             StringBuilder sb = new StringBuilder(s);
//             int n = s.length();
//             while (n-- > 0) {
//                 char ch = sb.charAt(0);
//                 sb.deleteCharAt(0);
//                 sb.append(ch);
//                 String a = sb.toString();
//                 if (ans.compareTo(a) > 0) {
//                     ans = a;
//                 }
//             }
//             return ans;
//         }
//         char[] arr = s.toCharArray();
//         Arrays.sort(arr);
//         return arr.toString();
//     }
// }
class Solution {
    public String orderlyQueue(String s, int k) {
        if(k>1){ //for k>1, the result string will always be sorted, it works like adjacent swapping in insertion sort
            char []ch=s.toCharArray();
            Arrays.sort(ch);
            String snew=new String(ch);
            return snew;
        }
        String ans=s;
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            char ch=sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(ch);
            String snew=sb.toString();
            if(ans.compareTo(snew)>0){
                ans=snew;
            }
        }
        return ans;
    }
}
