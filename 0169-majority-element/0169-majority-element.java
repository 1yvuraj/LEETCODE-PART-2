class Solution {

    public int majorityElement(int[] arr) {
        int count1 = 0;
        int check1 = (int) 1e10;
        for (int i = 0; i < arr.length; i++) {
            if (check1 == arr[i]) {
                count1++;
            } else if (count1 == 0) {
                count1 = 1;
                check1 = arr[i];
            } else {
                count1--;
            }
        }
        count1=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==check1)count1++;
        }
        return count1>arr.length/2?check1:-1;
    }
}
