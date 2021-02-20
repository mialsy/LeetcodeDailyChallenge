package DP;

public class LC485_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cur = 0;
        int max = 0;
        for (int num: nums) {
            cur = num == 1? (cur + 1): 0;
            max = Math.max(cur, max);
        }
        return max;
    }
}
