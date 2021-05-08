package DP;

public class LC304_range_sum_query {
    private int[][] prefixSum;

    public LC304_range_sum_query(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            // make sure handle edge case
            prefixSum = null;
            return;
        }
        prefixSum = new int[matrix.length][matrix[0].length];

        // calculate row prefix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    prefixSum[i][j] = matrix[i][j];
                } else {
                    prefixSum[i][j] = matrix[i][j] + prefixSum[i][j - 1];
                }
            }
        }

        // calculate col prefix
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                prefixSum[i][j] += prefixSum[i - 1][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (prefixSum == null) {
            return 0;
        }
        int sumTotal = prefixSum[row2][col2];
        int sumSubstract1 = row1 > 0 ? prefixSum[row1 - 1][col2]: 0;
        int sumSubstract2 = col1 > 0 ? prefixSum[row2][col1 - 1]: 0;
        int sumAdd = col1 > 0 && row1 > 0 ? prefixSum[row1 - 1][col1 - 1] : 0;
        return sumTotal - sumSubstract1 - sumSubstract2 + sumAdd;
    }
}
