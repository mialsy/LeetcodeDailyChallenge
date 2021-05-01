package GraphSearch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC690_ImportanceOfEmployee {
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> idToIndex = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            idToIndex.put(employees.get(i).id, i);
        }
        return helper(employees, idToIndex, id);
    }

    private int helper(List<Employee> employees, Map<Integer, Integer> idToIndex, int id) {
        Employee e = employees.get(idToIndex.get(id));

        int importance = e.importance;
        for (int sub: e.subordinates) {
            importance += helper(employees, idToIndex, sub);
        }
        return importance;
    }
}
