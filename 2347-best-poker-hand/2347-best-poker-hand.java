class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int c = 1;
        for (int i = 1; i < suits.length; i++) {
            if (suits[i] != suits[i - 1]) {
                break;
            }
            c++;
        }
        if (c == 5) {
            return "Flush";
        }
        int[] arr = new int[14];
        int max = -(int) 1e9;
        for (int i = 0; i < ranks.length; i++) {
            arr[ranks[i]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
        if (max == 3 || max == 4) {
            return "Three of a Kind";
        } else if (max == 2) {
            return "Pair";
        }
        return "High Card";
    }
}
