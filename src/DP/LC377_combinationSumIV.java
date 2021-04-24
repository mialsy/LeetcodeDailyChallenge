package DP;

import java.util.HashSet;
import java.util.Set;

public class LC377_combinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (set.contains(i - j)) {
                    dp[i] += dp[j];
                }
            }
        }
        return dp[target];
    }
}
