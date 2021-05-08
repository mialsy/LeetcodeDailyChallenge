package DP;

public class LC5_LongestParlindrome {
    public String longestPalindrome(String s) {

        int length = s.length();

        boolean[][] dp = new boolean[length][length];
        // dp[i][j] means whether parli in substring(i,j)

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int start = 0;

        // length
        for (int len = 2; len <= length; len++) {
            for (int i = 0; i < length; i++) { // start of the substring
                int j = i + len - 1;
                if (j >= length) {
                    break;
                }

                // char i != j => no changes
                // char i = j
                if (s.charAt(i) == s.charAt(j)) {
                    // if len == 2
                    // a___a   ____ is parlindrome or not
                    dp[i][j] = len <= 2 ? true : dp[i + 1][j - 1];
                }

                // update the global if it is parlindrome
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
