package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        // san check
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> triple = new ArrayList<>();
                    triple.add(nums[i]);
                    triple.add(nums[j]);
                    triple.add(nums[k]);

                    // as i, j, k are in ascending order
                    // euqals can be used
                    res.add(triple);
                    while (j++ < k  && nums[j] == nums[j - 1]) {}
                    while (j < k-- && nums[k] == nums[k + 1]) {}
                } else if (nums[i] + nums[j] + nums[k] > 0){
                    k--;
                } else {
                    j++;
                }
            }
        }

        return res;
    }
}
