class Solution {

    // public int secondsToRemoveOccurrences(String s) {
    //     int time=0;
    //     while(s.indexOf("01")>=0){
    //         s=s.replace("01","10");
    //         time++;
    //     }
    //     return time;
    // }
    public int secondsToRemoveOccurrences(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        int time = 0;
        while (count >=0) {
            count = 0;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == '0' && sb.charAt(i+1) == '1') {
                    count++;
                }
            }
            if (count == 0) return time;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == '0' && sb.charAt(i+1) == '1') {
                    sb.setCharAt(i, '1');
                    sb.setCharAt(i + 1, '0');
                    i++;
                }
            }
           
           
            time++;
        }
        return -1;
    }
}
