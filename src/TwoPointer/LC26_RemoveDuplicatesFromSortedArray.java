package TwoPointer;

public class LC26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i == nums.length) break;
            nums[len++] = nums[i];
        }
        return len;
    }
}
