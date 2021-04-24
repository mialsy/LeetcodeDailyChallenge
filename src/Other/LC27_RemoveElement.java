package Other;

public class LC27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;

        int i = 0;
        while (i < len) {
            if (nums[i] == val) {
                swap(nums, i, --len);
            } else {
                i++;
            }
        }
        return len;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
