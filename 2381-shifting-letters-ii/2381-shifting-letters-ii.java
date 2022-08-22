class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] arr = new int[s.length() + 1];
        for (int i = 0; i < shifts.length; i++) {
            int dir = shifts[i][2];
            if (dir == 0) {
                arr[shifts[i][0]]-= 1;
                arr[shifts[i][1] + 1] += 1;
            } else {
                arr[shifts[i][0]]+= 1;
                arr[shifts[i][1] + 1]-= 1;
            }
        }
        StringBuilder sb = new StringBuilder(s);

        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i = 0; i < arr.length - 1; i++) {
            char ch = s.charAt(i);
            int num = (ch + arr[i] - 'a') % 26;
            if (num < 0) {
                num += 26;
            }

            sb.setCharAt(i, (char) (num + 'a'));
        }
        return sb.toString();
    }
}
