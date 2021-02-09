package KMP;

public class LC739_DailyTemperature {
    // KMP？
    // Time: O(n)?
    // Space: O(1)
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[0];
        }

        int[] arr = new int[T.length];
        arr[T.length - 1] = 0;

        for (int i = T.length - 2; i >= 0; i--) {
            int next = i + 1;

            while (next < arr.length && T[i] >= T[next] && arr[next] != 0) {
                next += arr[next];
            }
            if (next < arr.length && T[i] < T[next]) {
                arr[i] = next - i;
            }
        }
        return arr;
    }
}
