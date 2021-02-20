package Hash;

import java.util.HashMap;
import java.util.Map;

public class LC1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[] {-1, -1};
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            int index = map.getOrDefault(other, -1);
            if (index != -1 && index != i) {
                return new int[] {i, index};
            }
        }

        return new int[] {-1, -1};
    }
}
