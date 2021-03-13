package DP;

import java.util.Arrays;

public class LC132_ParlindromePartition {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] isPal = new boolean[len][len];

        for (int i = 0;i < len; i++) {
            Arrays.fill(isPal[i], true);
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i+ 1; j < len; j++) {
                isPal[i][j] = s.charAt(i) == s.charAt(j) && isPal[i + 1][j - 1];
            }
        }

        int[] cuts = new int[len];
        Arrays.fill(cuts, Integer.MAX_VALUE);

        for (int i = 0; i < len; i++) {
            if (isPal[0][i]) {
                cuts[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (isPal[j + 1][i]) {
                        cuts[i] = Math.min(cuts[i], cuts[j] + 1);
                    }
                }
            }
        }

        return cuts[len - 1];

    }
}
