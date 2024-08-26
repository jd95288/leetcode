package medium;

import java.util.*;

/**
 * 员工的重要性
 * <p>
 * 你有一个保存员工信息的数据结构，它包含了员工唯一的 id ，重要度和直系下属的 id 。
 * 给定一个员工数组 employees，其中：
 * employees[i].id 是第 i 个员工的 ID。
 * employees[i].importance 是第 i 个员工的重要度。
 * employees[i].subordinates 是第 i 名员工的直接下属的 ID 列表。
 * <p>
 * 给定一个整数 id 表示一个员工的 ID，返回这个员工和他所有下属的重要度的 总和。
 *
 * @author jd95288
 * @date 2024-08-26 14:59
 */
public class GetImportance690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int res = 0;
        Queue<Employee> q = new ArrayDeque<>(employees.size());
        q.offer(map.get(id));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Employee node = q.poll();
                res += node.importance;
                for (Integer subordinate : node.subordinates) {
                    q.offer(map.get(subordinate));
                }
            }
        }
        return res;
    }
}
