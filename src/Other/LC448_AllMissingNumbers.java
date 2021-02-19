package Other;

import java.util.ArrayList;
import java.util.List;

public class LC448_AllMissingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            // label the found num to be negative
            nums[index] = - Math.abs(nums[index]);
        }

        for (int i = 0; i < nums.length; i++) {
            // if it is positive, meaning it has not been labelled yet
            if (nums[i] > 0) res.add(i + 1);
        }
        return res;
    }
}
