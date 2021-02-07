package Greedy;

/*
Array length = n
Time: linear scan array => O(n)
Space: O(1)
 */

public class LC665_NonDecresingArray {

    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return true;
        }

        int modTimes = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                modTimes++;
                if (modTimes > 1) {
                    return false;
                }
                // Compared i + 1 and i - 1
                // if nums[i + 1] >= nums[i - 1], if nums[i + 2] > nums[i+ 1], then nums[i + 2] > nums[i - 1]
                // else need to update to nums[i], so that nums[i+1] in the future is larger or equal to nums[i]
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }

}
