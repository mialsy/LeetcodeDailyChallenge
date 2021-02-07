package DP;

public class LC978_LongestTurbulentSubarray {

    // Dynamic programing
    // Similar to longest subarray
    // Suppose input array length = n
    // Time:  O(n) going through the array length
    // Space: O(1) 3 int
    public int maxTurbulenceSize(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        } else if (arr.length == 1) {
            return 1;
        }

        int currentMax = 1;
        int globalMax = 1;
        int prevSign = 0;

        for (int i = 1; i < arr.length; i++) {
            if (i == 1) {
                prevSign = computeSign(arr[i - 1], arr[i]);
                currentMax = prevSign == 0 ? 1: 2;
            } else {
                int currentSign = computeSign(arr[i - 1], arr[i]);
                if (currentSign * prevSign == -1) {
                    currentMax += 1;
                } else if (currentSign == 0) {
                    currentMax = 1;
                } else {
                    currentMax = 2;
                }
                prevSign = currentSign;
            }
            globalMax = Math.max(currentMax, globalMax);
        }
        return globalMax;
    }

    // helper function
    private int computeSign(int one, int two) {
        if (one > two) return 1;
        if (one == two) return 0;
        return -1;
    }
}
