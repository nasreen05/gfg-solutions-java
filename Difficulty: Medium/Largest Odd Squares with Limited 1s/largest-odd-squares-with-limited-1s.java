
import java.util.*;

class Solution {

    public List<Integer> largestSquare(int[][] mat, int[][] queries, int k) {

        int n = mat.length;
        int m = mat[0].length;

        // Prefix sum of number of 1s
        int[][] prefix = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                prefix[i + 1][j + 1] =
                        mat[i][j]
                        + prefix[i][j + 1]
                        + prefix[i + 1][j]
                        - prefix[i][j];
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int[] query : queries) {

            int r = query[0];
            int c = query[1];

            /*
             * First check 1 x 1 square.
             *
             * If the center itself contains more than k ones,
             * then no valid square exists.
             */
            if (mat[r][c] > k) {
                answer.add(-1);
                continue;
            }

            /*
             * radius = 0 -> 1 x 1
             * radius = 1 -> 3 x 3
             * radius = 2 -> 5 x 5
             */
            int maxRadius = Math.min(
                    Math.min(r, n - 1 - r),
                    Math.min(c, m - 1 - c)
            );

            int low = 0;
            int high = maxRadius;
            int bestRadius = 0;

            while (low <= high) {

                int radius = low + (high - low) / 2;

                int top = r - radius;
                int bottom = r + radius;
                int left = c - radius;
                int right = c + radius;

                int ones = prefix[bottom + 1][right + 1]
                         - prefix[top][right + 1]
                         - prefix[bottom + 1][left]
                         + prefix[top][left];

                if (ones <= k) {
                    bestRadius = radius;
                    low = radius + 1;
                } else {
                    high = radius - 1;
                }
            }

            answer.add(2 * bestRadius + 1);
        }

        return answer;
    }
}



