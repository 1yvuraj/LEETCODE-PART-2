class Solution {
    public List<Integer> majorityElement(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int count1 = 0;
        int check1 = (int) 1e10;
        int count2 = 0;
        int check2 = (int) 1e10;
        for (int i = 0; i < arr.length; i++) {
            if (check1 == arr[i]) {
                count1++;
            } else if (check2 == arr[i]) {
                count2++;
            } else if (count1 == 0) {
                count1 = 1;
                check1 = arr[i];
            } else if (count2 == 0) {
                count2 = 1;
                check2 = arr[i];
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == check2) count2++;
            if (arr[i] == check1) count1++;
        }
        if (count1 > arr.length / 3) ans.add(check1);
        if (count2 > arr.length / 3) ans.add(check2);
        return ans;
    }
}
