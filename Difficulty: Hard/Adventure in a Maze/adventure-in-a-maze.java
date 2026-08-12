import java.util.*;

class Solution {

    public ArrayList<Integer> findWays(int[][] grid) {

        int n = grid.length;
        int MOD = 1000000007;

        long[][] ways = new long[n][n];
        int[][] maxAdventure = new int[n][n];

        // Starting cell
        ways[0][0] = 1;
        maxAdventure[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                // From top
                if (i > 0) {

                    int previousValue = grid[i - 1][j];

                    if (previousValue == 2 || previousValue == 3) {

                        ways[i][j] =
                                (ways[i][j] + ways[i - 1][j]) % MOD;

                        if (ways[i - 1][j] > 0) {

                            maxAdventure[i][j] =
                                    Math.max(
                                            maxAdventure[i][j],
                                            maxAdventure[i - 1][j]
                                                    + grid[i][j]
                                    );
                        }
                    }
                }

                // From left
                if (j > 0) {

                    int previousValue = grid[i][j - 1];

                    if (previousValue == 1 || previousValue == 3) {

                        ways[i][j] =
                                (ways[i][j] + ways[i][j - 1]) % MOD;

                        if (ways[i][j - 1] > 0) {

                            maxAdventure[i][j] =
                                    Math.max(
                                            maxAdventure[i][j],
                                            maxAdventure[i][j - 1]
                                                    + grid[i][j]
                                    );
                        }
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        result.add((int) ways[n - 1][n - 1]);
        result.add(maxAdventure[n - 1][n - 1]);

        return result;
    }
}