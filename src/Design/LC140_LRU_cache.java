package Design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC140_LRU_cache {
    private Map<Integer, Integer> map;

    public LC140_LRU_cache(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return map.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
