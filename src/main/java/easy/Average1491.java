package easy;

import java.util.Arrays;

/**
 * 去掉最低工资和最高工资后的工资平均值
 * <p>
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 *
 * @author jd95288
 * @date 2024-05-03 0:01
 */
public class Average1491 {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int n = salary.length;
        int total = 0;
        for (int i = 1; i < n - 1; i++) {
            total += salary[i];
        }
        return (double) total / (n - 2);
    }
}
