class Solution {

    public boolean haveConflict(String[] event1, String[] event2) {
        int arr1[] = convert(event1);
        int arr2[] = convert(event2);
        if (arr1[0] > arr2[1]) return false;
        if (arr1[1] >= arr2[0]) return true;
        return false;
    }

    public int[] convert(String[] event1) {
        String s = event1[0];
        String e = event1[1];
        int[] arr = new int[2];
        arr[0] = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
        arr[1] = Integer.parseInt(e.substring(0, 2)) * 60 + Integer.parseInt(e.substring(3, 5));
        return arr;
    }
}
