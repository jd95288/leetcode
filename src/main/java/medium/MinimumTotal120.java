package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 三角形最小路径和
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * @author jd95288
 * @date 2024-08-06 15:42
 */
public class MinimumTotal120 {

    /**
     * 空间优化
     */
    public int minimumTotal_v1(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 这里+1是为了将初始化最后一行放入循环内部而不越界
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
            }
        }
        return dp[0];
    }

    /**
     * 执行通过
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int size = triangle.get(n - 1).size();
        int[][] dp = new int[n][size];
        for (int j = 0; j < size; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            size = triangle.get(i).size();
            // 这里可以直接取j <= i，第0行有1个，第1行有2个，换成index小于等于正好
            for (int j = 0; j < size; j++) {
                dp[i][j] += Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                // 下一层的长度比当前层长度长1，不会越界，需要取二者的最小值
//                Integer cur = triangle.get(i).get(j);
//                if (j + 1 < size) {
//                    dp[i][j] += Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + cur;
//                } else {
//                    dp[i][j] += dp[i + 1][j] + cur;
//                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        MinimumTotal120 main = new MinimumTotal120();
        List<List<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        triangle.add(list);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        triangle.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        triangle.add(list2);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);
        triangle.add(list3);

//        List<List<Integer>> triangle = new ArrayList<>();
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(-1);
//        triangle.add(list);
//        ArrayList<Integer> list1 = new ArrayList<>();
//        list1.add(-2);
//        list1.add(-3);
//        triangle.add(list1);
        System.out.println(main.minimumTotal(triangle));
    }
}
