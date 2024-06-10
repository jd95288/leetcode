package medium;

import java.util.Arrays;

/**
 * 救生艇
 * <p>
 * 给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回 承载所有人所需的最小船数 。
 *
 * @author jd95288
 * @date 2024-06-10 21:18
 */
public class NumRescueBoats881 {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int end = Arrays.binarySearch(people, limit);
        if (end < 0) {
            end = -end - 1;
        }
        int res = n - end;
        int start = 0;
        while (start < end) {
            while (start < end - 1 && people[start] + people[end - 1] > limit) {
                end--;
                res++;
            }
            start++;
            end--;
            res++;
        }
        return res;
    }
}
