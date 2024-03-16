package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * H 指数
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * <p>
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，
 * 一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
 * 并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 *
 * @author jd95288
 * @date 2024-03-12 17:14
 */
public class HIndex {

    public int hIndex(int[] citations) {
        int[] citationsCount = new int[citations.length + 1];
        for (int citation : citations) {
            citationsCount[Math.min(citation, citations.length)]++;
        }
        int count = 0;
        for (int i = citationsCount.length - 1; i >= 0; i--) {
            count += citationsCount[i];
            if (count >= i) {
                return i;
            }
        }
        return count;
    }
}
