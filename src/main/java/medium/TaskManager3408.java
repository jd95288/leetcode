package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 设计任务管理器
 * <p>
 * 一个任务管理器系统可以让用户管理他们的任务，每个任务有一个优先级。这个系统需要高效地处理添加、修改、执行和删除任务的操作。
 * 请你设计一个 TaskManager 类：
 * TaskManager(vector<vector<int>>& tasks) 初始化任务管理器，初始化的数组格式为 [userId, taskId, priority] ，表示给 userId 添加一个优先级为 priority 的任务 taskId 。
 * void add(int userId, int taskId, int priority) 表示给用户 userId 添加一个优先级为 priority 的任务 taskId ，输入 保证 taskId 不在系统中。
 * void edit(int taskId, int newPriority) 更新已经存在的任务 taskId 的优先级为 newPriority 。输入 保证 taskId 存在于系统中。
 * void rmv(int taskId) 从系统中删除任务 taskId 。输入 保证 taskId 存在于系统中。
 * int execTop() 执行所有用户的任务中优先级 最高 的任务，如果有多个任务优先级相同且都为 最高 ，执行 taskId 最大的一个任务。执行完任务后，taskId 从系统中 删除 。同时请你返回这个任务所属的用户 userId 。如果不存在任何任务，返回 -1 。
 * 注意 ，一个用户可能被安排多个任务。
 *
 * @author jd95288
 * @date 2025-09-18 8:42
 */
public class TaskManager3408 {

    static class TaskManager {

        private final Map<Integer, int[]> taskIdMap = new HashMap<>();
        private final PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            int compare = b[2] - a[2];
            if (compare != 0) {
                return compare;
            }
            return b[1] - a[1];
        });

        public TaskManager(List<List<Integer>> tasks) {
            for (List<Integer> task : tasks) {
                int[] t = {task.get(0), task.get(1), task.get(2)};
                taskIdMap.put(t[1], t);
                q.offer(t);
            }
        }

        public void add(int userId, int taskId, int priority) {
            int[] t = {userId, taskId, priority};
            taskIdMap.put(taskId, t);
            q.offer(t);
        }

        public void edit(int taskId, int newPriority) {
            int[] t = taskIdMap.get(taskId);
            t = new int[]{t[0], t[1], newPriority};
            taskIdMap.put(taskId, t);
            q.offer(t);
        }

        public void rmv(int taskId) {
            taskIdMap.remove(taskId);
        }

        public int execTop() {
            while (!q.isEmpty() && (taskIdMap.get(q.peek()[1]) == null || taskIdMap.get(q.peek()[1])[2] != q.peek()[2]|| taskIdMap.get(q.peek()[1])[0] != q.peek()[0])) {
                q.poll();
            }
            if (q.isEmpty()) {
                return -1;
            }
            int[] task = q.poll();
            taskIdMap.remove(task[1]);
            return task[0];
        }
    }

}
