package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 森林中的兔子
 * <p>
 * 森林中有未知数量的兔子。提问其中若干只兔子 "还有多少只兔子与你（指被提问的兔子）颜色相同?" ，
 * 将答案收集到一个整数数组 answers 中，其中 answers[i] 是第 i 只兔子的回答。
 * 给你数组 answers ，返回森林中兔子的最少数量。
 *
 * @author jd95288
 * @date 2025-04-20 14:09
 */
public class NumRabbits781 {

    public int numRabbits(int[] answers) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : answers) {
            map.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer colorCnt = entry.getKey() + 1;
            Integer groupCnt = entry.getValue();
            int colors = (groupCnt + colorCnt - 1) / colorCnt;
            res += colors * colorCnt;
        }
        return res;
    }
}
