class Solution {

    public int nextGreaterElement(int n) {
        long m=n;
        char[] number =String.valueOf(m).toCharArray();
        int idx = -1;
        for (int i = number.length - 1; i > 0; i--) {
            if (number[i - 1] < number[i]) {
                idx = i - 1;
                break;
            }
        }
        if (idx == -1) return -1;

        for (int i = number.length - 1; i > idx; i--) {
            if (number[i] > number[idx]) {
                swap(number, i, idx);
                break;
            }
        }
        reverse(number, idx + 1, number.length - 1);

        String str = new String(number);
        if (Long.parseLong(str) <= Integer.MAX_VALUE) {
            return Integer.parseInt(str);
        } else {
            return -1;
        }
    }

    public static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void reverse(char[] ch, int i, int j) {
        while (i < j) {
            swap(ch, i, j);
            i++;
            j--;
        }
    }
}
