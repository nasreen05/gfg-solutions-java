import java.util.*;

class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();

        rows.add(0);
        rows.add(n + 1);

        cols.add(0);
        cols.add(m + 1);

        for (int[] cell : arr) {
            rows.add(cell[0]);
            cols.add(cell[1]);
        }

        Collections.sort(rows);
        Collections.sort(cols);

        int maxRowGap = 0;
        for (int i = 1; i < rows.size(); i++) {
            maxRowGap = Math.max(maxRowGap,
                                 rows.get(i) - rows.get(i - 1) - 1);
        }

        int maxColGap = 0;
        for (int i = 1; i < cols.size(); i++) {
            maxColGap = Math.max(maxColGap,
                                 cols.get(i) - cols.get(i - 1) - 1);
        }

        return maxRowGap * maxColGap;
    }
}