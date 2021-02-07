package SlidingWindow;

public class LC643_MaximumAverageSubarry {
    public double findMaxAverage(int[] nums, int k) {
        // find max avg = find max sum

        // sanity check
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int sum = 0;
        while (i < k) {
            sum += nums[i];
            i++;
        }

        // sliding window for the genral case
        int maxSum = sum;
        while (i < nums.length) {
            // k is the offset
            sum += nums[i];
            sum -= nums[i - k];
            maxSum = Math.max(sum, maxSum);
            i++;
        }
        return maxSum /((double)k);

    }
}
