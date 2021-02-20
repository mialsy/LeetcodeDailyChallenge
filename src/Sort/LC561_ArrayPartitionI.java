package Sort;

import java.util.Arrays;

public class LC561_ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);

        int res = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            res += nums[i * 2];
        }
        return res;
    }
}
