class Solution {

    public int findMinArrowShots(int[][] coordinates) {
        Arrays.sort(coordinates, (a, b) -> Integer.compare(a[1], b[1]));
        int end = coordinates[0][1], arrow = 1;
        for (int i = 1; i < coordinates.length; i++) {
            if (coordinates[i][0] > end) {
                end = coordinates[i][1];
                arrow++;
            }
        }

        return arrow;
    }
}
