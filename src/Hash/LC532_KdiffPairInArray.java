package Hash;

import java.util.HashSet;
import java.util.Set;

public class LC532_KdiffPairInArray {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k < 0 ) {
            return 0;
        }

        Set<Integer> seen = new HashSet<>();
        Set<Integer> diff = new HashSet<>();

        for (int num: nums) {
            if (seen.contains(num - k)) {
                diff.add(num - k);
            }
            if (seen.contains(num + k)) {
                diff.add(num);
            }
            seen.add(num);
        }
        return diff.size();
    }
}
