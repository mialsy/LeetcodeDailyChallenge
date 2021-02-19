package LinearScan;

public class LC495_TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) return 0;

        int total = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] - timeSeries[i] >=duration) {
                total += duration;
            } else {
                total += timeSeries[i + 1] - timeSeries[i];
            }
        }

        total += duration;
        return total;
    }
}
